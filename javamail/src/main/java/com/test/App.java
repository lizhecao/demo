package com.test;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws MessagingException {
//        Properties props = new Properties();
//        // 开启debug 调试
//        props.setProperty("mail.debug", "true");
//        // 发送服务器 需要身份验证
//        props.setProperty("mail.smtp.auth", "true");
//        // 设置邮件服务器主机名
//        props.setProperty("mail.host", "smtp.163.com");
//        // 发送邮件协议名称
//        props.setProperty("mail.transport.protocol", "smtp");
//
//        // 设置环境信息
//        Session session = Session.getInstance(props);
//
//        // 创建邮件对象
//        Message msg = new MimeMessage(session);
//        msg.setSubject("java 邮件来了");
//        msg.setText("你好，这是一封来自demo 的java邮件, 原来发送邮件这么简单, 难怪什么应用都要搞邮件发送");
//        msg.setFrom(new InternetAddress("a541995149@163.com"));
//
//        Transport transport = session.getTransport();
//        // 连接服务器
//        transport.connect("a541995149", "13570237269asd");
//        // 发送邮件
//        transport.sendMessage(msg, new Address[] {new InternetAddress("541995149@qq.com")});
//        // 关闭连接
//        transport.close();
        Integer i = 0;
        App.test(i);
        System.out.println(i);
    }

    public static void test(Integer i) {
        i++;
    }
}
