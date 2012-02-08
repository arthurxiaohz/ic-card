// Decompiled by Jad v1.5.7g. Copyright 2000 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/SiliconValley/Bridge/8617/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi 
// Source File Name:   SerialConnection.java

package org.hi.base.sysapp.message.sms.modem;

import java.io.*;
import javax.comm.*;

// Referenced classes of package com.kenoah.sms.gsm:
//            SerialParameters

public class SerialConnection
{

    private final String ISO = "iso8859-1";
    private SerialParameters params;
    private InputStream input;
    private OutputStream output;
    private boolean bOpen;
    private CommPortIdentifier PortId;
    private SerialPort sPort;

    public SerialConnection()
    {
    }

    public synchronized void open(SerialParameters param)
        throws UnsupportedCommOperationException, IOException, PortInUseException, NoSuchPortException
    {
        SerialParameters oldparam = new SerialParameters();
        try
        {
            PortId = CommPortIdentifier.getPortIdentifier(param.getName());
        }
        catch(NoSuchPortException e)
        {
            throw e;
        }
        try
        {
            sPort = (SerialPort)PortId.open("sms", 2000);
        }
        catch(PortInUseException e)
        {
            throw e;
        }
        oldparam.setBaudRate(sPort.getBaudRate());
        oldparam.setDatabits(sPort.getDataBits());
        oldparam.setStopbits(sPort.getStopBits());
        oldparam.setFlowControlMode(sPort.getFlowControlMode());
        oldparam.setParity(sPort.getParity());
        try
        {
            sPort.setSerialPortParams(param.getBaudRate(), param.getDatabits(), param.getStopbits(), param.getParity());
            sPort.setFlowControlMode(param.getFlowControlMode());
        }
        catch(UnsupportedCommOperationException e)
        {
            sPort.setSerialPortParams(oldparam.getBaudRate(), oldparam.getDatabits(), oldparam.getStopbits(), oldparam.getParity());
            sPort.setFlowControlMode(oldparam.getFlowControlMode());
            sPort.close();
            throw e;
        }
        try
        {
            input = sPort.getInputStream();
            output = sPort.getOutputStream();
        }
        catch(IOException e)
        {
            sPort.close();
            throw e;
        }
        try
        {
            sPort.enableReceiveTimeout(300);
        }
        catch(UnsupportedCommOperationException unsupportedcommoperationexception) { }
        params = param;
        bOpen = true;
    }

    public SerialParameters getParameters()
    {
        return params;
    }

    public synchronized void close()
    {
        if(!bOpen)
            return;
        if(sPort != null)
        {
            try
            {
                input.close();
                output.close();
            }
            catch(IOException ioexception) { }
            sPort.close();
        }
        params = null;
        bOpen = false;
    }

    public boolean isOpen()
    {
        return bOpen;
    }

    public void write(String data)
        throws IOException
    {
        write(data.getBytes("iso8859-1"));
    }

    public synchronized void write(byte data[])
        throws IOException
    {
        output.write(data);
    }

    public synchronized String read()
        throws IOException
    {
        StringBuffer buf = new StringBuffer();
        int iData = 0;
        do
        {
            iData = input.read();
            if(iData != -1)
                buf.append((char)iData);
        } while(iData != -1);
        return new String(buf);
    }
}
