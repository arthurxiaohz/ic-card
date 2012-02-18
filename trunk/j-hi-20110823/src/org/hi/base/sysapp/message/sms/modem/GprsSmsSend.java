// Decompiled by Jad v1.5.7g. Copyright 2000 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/SiliconValley/Bridge/8617/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi 
// Source File Name:   GprsSmsSend.java

package org.hi.base.sysapp.message.sms.modem;

import java.io.PrintStream;
import java.util.*;

import org.hi.base.sysapp.message.sms.SmsListener;

// Referenced classes of package com.kenoah.sms.gsm:
//            Sms, GprsManager, SmsPort, GprsSmsMessenger, 
//            SerialConnection, SerialParameters

public class GprsSmsSend extends Thread
{

    private Vector messengers;
    private static GprsSmsSend instance = null;
    private Vector smsList;
    private int i;
    private boolean bSendSms;
    private int sendCount;
    private String smsPort;
    

	private GprsSmsSend()
    {
        messengers = new Vector();
        smsList = new Vector();
        i = 0;
        bSendSms = true;
        sendCount = 0;
        start();
    }

    public static GprsSmsSend getInstance()
    {
    	if(instance == null)
    		instance = new GprsSmsSend();
        return instance;
    }

    public void setMessenger(SmsListener messenger)
    {
        messengers.add(messenger);
    }

    public void removeMessenger(SmsListener messenger)
    {
        messengers.remove(messenger);
    }

    public void addQueue(Sms msg)
    {
        smsList.add(msg);
    }

    public void run()
    {
        do
            if(bSendSms)
            {
                Sms msg = null;
                try
                {
                    if(smsList.size() != 0)
                        msg = (Sms)smsList.remove(0);
                }
                catch(Exception e)
                {
                    System.err.println(e);
                }
                if(msg != null)
                    sendMsg(msg);
                if(++sendCount > 10)
                {
                    bSendSms = false;
                    sendCount = 0;
                }
            } else
            {
                readMsg();
                try
                {
                    Thread.sleep(10000L);
                }
                catch(Exception exception) { }
                bSendSms = true;
            }
        while(true);
    }

    private void sendMsg(Sms msg)
    {
        GprsManager manger = GprsManager.getInstance();
        try
        {
            SmsPort sp = manger.getConnection(smsPort);
            sp.sendMessage(msg.getMobileNumber(), msg.getMessage());
            i = 0;
            Thread.sleep(3000L);
        }
        catch(Exception e)
        {
            i++;
            if(i > 10)
                try
                {
                    manger.clearConnection();
                }
                catch(Exception exception) { }
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(msg.getDate());
            calendar.add(12, 360);
            Date endkeepDate = calendar.getTime();
            if(endkeepDate.after(new Date()) && msg.getMobileNumber() != null && !msg.getMobileNumber().equals(""))
//                addQueue(msg);
            	;
        }
    }

    private void readMsg()
    {
        GprsManager manger = GprsManager.getInstance();
        SmsPort sp = manger.getConnection(smsPort);
        try
        {
            if(sp != null)
            {
                Vector v = sp.receiveMessage();
                if(v != null && v.size() > 0)
                {
                    for(int i = 0; i < messengers.size(); i++)
                    {
                        SmsListener messenger = (SmsListener)messengers.get(i);
                        messenger.SmsArrive(v);
                    }

                }
                Thread.sleep(3000L);
            }
        }
        catch(Exception e)
        {
            this.i++;
            if(this.i > 10)
                try
                {
                    manger.clearConnection();
                }
                catch(Exception exception) { }
        }
    }

    public SerialParameters getParameters()
    {
        return GprsManager.getInstance().getConnection(smsPort).getSerialConn().getParameters();
    }

    public void setSmsPort(String smsPort) {
		this.smsPort = smsPort;
	}
//    static 
//    {
//        instance = new GprsSmsSend();
//    }
}
