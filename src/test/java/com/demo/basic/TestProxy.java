package com.demo.basic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理举例
 *
 * 要想实现动态代理，需要解决的问题？
 * 1. 如何根据加载到内存中的被代理类动态的创建一个代理类及其对象
 * 2. 当通过代理类的对象调用方法时，如何动态的调用被代理类的同名方法
 */

interface Human{
    String getBelief();

    void eat(String food);
}

// 被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I believe I can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}

class ProxyFactory{
    // obj: 被代理类对象(解决问题1)
    public static Object getProxyInstance(Object obj){
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}

class MyInvocationHandler implements InvocationHandler {
    // 被代理类对象
    private Object obj;

    public void bind(Object obj){
        this.obj = obj;
    }

    // 当我们通过代理类的对象，调用方法a时，就会自动的调用 invoke()
    // 将被代理类要执行的方法a就声明在 invoke() 之中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // method即为代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法(解决问题2)
        Object result = method.invoke(this.obj, args);
        return result;
    }
}

public class TestProxy {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        // 代理类对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        System.out.println(proxyInstance.getBelief());
        proxyInstance.eat("苹果");
    }
}
