package com.demo.basic;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

interface Connection{
    boolean build();
}

class DatabaseConnection implements Connection{

    @Override
    public boolean build() {
        System.out.println("进行数据库连接");
        return true;
    }
}

class CloudConnection implements Connection{

    @Override
    public boolean build() {
        System.out.println("进行云服务连接");
        return true;
    }
}

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface Channel{
    String value();
}

//@Channel("com.demo.basic.DatabaseConnection")
@Channel("com.demo.basic.CloudConnection")
class Message{
    private Connection conn;
    public Message(){
        Channel channel = this.getClass().getAnnotation(Channel.class);
        try {
            // 获取到Connection对象实例
            this.conn = (Connection) Class.forName(channel.value()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void send(String msg){
        // 执行build方法，实际上执行的是Connection接口的实现类
        if (this.conn.build()){
            System.out.println("消息发送:" + msg);
        }
    }
}
public class TestAnnotation {
    public static void main(String[] args) {
        Message msg = new Message();
        msg.send("Test Content");
    }
}
