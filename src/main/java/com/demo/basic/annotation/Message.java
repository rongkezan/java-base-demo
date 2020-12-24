package com.demo.basic.annotation;

/**
 * @author keith
 */
@Channel("com.demo.basic.annotation.DatabaseConnection")
public class Message{

    private Connection conn;

    public Message(){
        Channel channel = this.getClass().getAnnotation(Channel.class);
        try {
            // 获取到Connection对象实例
            conn = (Connection) Class.forName(channel.value()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void send(String msg){
        // 执行build方法，实际上执行的是Connection接口的实现类
        if (conn.build()){
            System.out.println("消息发送:" + msg);
        }
    }
}
