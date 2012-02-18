// Decompiled by Jad v1.5.7g. Copyright 2000 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/SiliconValley/Bridge/8617/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi 
// Source File Name:   GprsManager.java

package org.hi.base.sysapp.message.sms.modem;


// Referenced classes of package com.kenoah.sms.gsm:
//            SmsPort

public class GprsManager
{

    private final byte ESC = 27;
    private SmsPort sp;
    private static GprsManager instance = new GprsManager();

    private GprsManager()
    {
        sp = null;
    }

    public static GprsManager getInstance()
    {
        return instance;
    }

    public SmsPort getConnection(String smsPort)
    {
        if(sp == null || !sp.isOpen())
        {
            sp = new SmsPort(smsPort);
            SerialParameters param = sp.detectSmsPort();
            if(param != null)
            {
                try
                {
                    sp.open(param);
                }
                catch(Exception exception) { }
                if(sp.isOpen())
                    return sp;
            }
            sp = null;
        }
        return sp;
    }

    public void clearConnection()
        throws Exception
    {
        byte b[] = {
            27, 27, 27
        };
        byte b2[] = {
            13, 10
        };
        if(sp.isOpen())
        {
            sp.sendData(b);
            try
            {
                Thread.sleep(1000L);
            }
            catch(InterruptedException interruptedexception) { }
            sp.receiveData();
            for(int i = 0; i < 5; i++)
            {
                sp.sendCommand("AT");
                sp.receiveData();
            }

            for(int i = 0; i < 5; i++)
            {
                sp.sendData(b2);
                sp.receiveData();
            }

            sp.close();
            sp = null;
        }
    }

}
