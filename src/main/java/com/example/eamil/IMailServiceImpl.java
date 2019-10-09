package com.example.eamil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailParseException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class IMailServiceImpl implements IMailService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Spring Boot 提供了一个发送邮件的简单抽象，使用的是下面这个接口，这里直接注入即可使用
     */
    @Autowired
    private JavaMailSender mailSender;

    /**
     * 配置文件中我的qq邮箱
     */
    @Value("${spring.mail.from}")
    private String from;

    /**
     * 简单文本邮件
     * @param to 收件人
     * @param subject 主题
     * @param content 内容
     */
    @Override
    public void sendSimpleMail(String to, String subject, String content) {
        //创建SimpleMailMessage对象
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件发送人
        message.setFrom(from);
        //邮件接收人
        message.setTo(to);
        //邮件主题
        message.setSubject(subject);
        //邮件内容
        message.setText(content);
        //发送邮件
        mailSender.send(message);
    }

    @Override
    public void setFrom(String s) throws MailParseException {

    }

    @Override
    public void setReplyTo(String s) throws MailParseException {

    }

    @Override
    public void setTo(String s) throws MailParseException {

    }

    @Override
    public void setTo(String... strings) throws MailParseException {

    }

    @Override
    public void setCc(String s) throws MailParseException {

    }

    @Override
    public void setCc(String... strings) throws MailParseException {

    }

    @Override
    public void setBcc(String s) throws MailParseException {

    }

    @Override
    public void setBcc(String... strings) throws MailParseException {

    }

    @Override
    public void setSentDate(Date date) throws MailParseException {

    }

    @Override
    public void setSubject(String s) throws MailParseException {

    }

    @Override
    public void setText(String s) throws MailParseException {

    }
}
