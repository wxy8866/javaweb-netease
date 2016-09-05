package com.wxy8866.mvnstudy.account.email;

import javax.mail.MessagingException;

public class AccountEmailException extends Exception
{

    public AccountEmailException(String string, MessagingException me)
    {
       System.out.println(string);
    }

}
