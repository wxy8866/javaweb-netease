package com.wxy8866.mvnstudy.account.email;


public interface AccountEmailService
{
    public void sendEmail(String to, String subject, String htmlText) throws Exception;
}
