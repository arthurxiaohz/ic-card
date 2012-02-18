// Decompiled by Jad v1.5.7g. Copyright 2000 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/SiliconValley/Bridge/8617/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi 
// Source File Name:   Sms.java

package org.hi.base.sysapp.message.sms.modem;

import java.util.Date;

public class Sms
{

    private String mobileNumber;
    private String Message;
    private Date date;

    public Sms(String mobileNum, String msg)
    {
        mobileNumber = null;
        Message = null;
        date = null;
        mobileNumber = mobileNum;
        Message = msg;
        date = new Date();
    }

    public Sms(String mobileNum, String msg, Date d)
    {
        mobileNumber = null;
        Message = null;
        date = null;
        mobileNumber = mobileNum;
        Message = msg;
        date = d;
    }

    public String getMobileNumber()
    {
        return mobileNumber;
    }

    public String getMessage()
    {
        return Message;
    }

    public Date getDate()
    {
        return date;
    }
}
