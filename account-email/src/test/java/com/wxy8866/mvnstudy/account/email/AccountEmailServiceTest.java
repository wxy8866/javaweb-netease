package com.wxy8866.mvnstudy.account.email;

import static org.junit.Assert.*;

import javax.mail.Message;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetup;

public class AccountEmailServiceTest
{
    private GreenMail greenMail;

    @Before
    public void startMailServer()
    {
        greenMail = new GreenMail(ServerSetup.SMTP);
        greenMail.setUser("wxy@wxy8866.com", "!wxy7lstpqb78D");
        greenMail.start();
    }

    @Test
    public void testSendMail() throws Exception
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("account-email.xml");
        AccountEmailService accountEmailService = (AccountEmailService) ctx.getBean("accountEmailService");
        String subject = "This is the subject of my test email";
        String htmlText = "<h3>Test</h3>";
        accountEmailService.sendEmail("shxywei@cn.ibm.com", subject, htmlText);
        greenMail.waitForIncomingEmail(2000, 1);
        Message[] messages = greenMail.getReceivedMessages();
        assertEquals(1, messages.length);
        assertEquals(subject, messages[0].getSubject());
        assertEquals(htmlText, GreenMailUtil.getBody(messages[0]).trim());

    }

    @After
    public void stopMailServer()
    {
        greenMail.stop();
    }
}
