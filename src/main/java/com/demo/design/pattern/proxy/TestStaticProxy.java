package com.demo.design.pattern.proxy;

/**
 * 静态代理类举例
 * 代理类和被代理类在编译期间就确定了
 */
interface ClothFactory{
    void produceCloth();
}

// 代理类
class ProxyClothFactory implements ClothFactory{
    private ClothFactory factory;   // 用被代理对象进行实例化

    public ProxyClothFactory(ClothFactory factory){
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");
        factory.produceCloth();
        System.out.println("代理工厂做一些收尾工作");
    }
}

// 被代理类
class NikeClothFactory implements ClothFactory{
    @Override
    public void produceCloth() {
        System.out.println("耐克工厂生产一批运动服");
    }
}

public class TestStaticProxy {
    public static void main(String[] args) {
        // 创建被代理类的对象
        NikeClothFactory nike = new NikeClothFactory();
        // 创建代理类的对象
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nike);
        proxyClothFactory.produceCloth();
    }
}
