package com.wxy8866.mvnstudy.account.email;

import javax.mail.MessagingException;
import javax.mail.event.TransportListener;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class AccountEmailServiceImpl implements AccountEmailService
{
    private JavaMailSender javaMailSender;
    private String systemEmail;

    public void sendEmail(String to, String subject, String htmlText) throws AccountEmailException
    {
        try
        {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message);
            
            messageHelper.setFrom(systemEmail);
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            messageHelper.setText(htmlText,true);
            
            javaMailSender.send(message);
            
        }
        catch (MessagingException me)
        {
            throw new AccountEmailException("Failed to send email.", me);
        }
    }

    public JavaMailSender getJavaMailSender()
    {
        return javaMailSender;
    }

    public void setJavaMailSender(JavaMailSender javaMailSender)
    {
        this.javaMailSender = javaMailSender;
    }

    public String getSystemEmail()
    {
        return systemEmail;
    }

    public void setSystemEmail(String systemEmail)
    {
        this.systemEmail = systemEmail;
    };
    
}
