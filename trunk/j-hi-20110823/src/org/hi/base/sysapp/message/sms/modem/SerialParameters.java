// Decompiled by Jad v1.5.7g. Copyright 2000 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/SiliconValley/Bridge/8617/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi 
// Source File Name:   SerialParameters.java

package org.hi.base.sysapp.message.sms.modem;


public class SerialParameters
{

    private String name;
    private String model;
    private int baudRate;
    private int databits;
    private int stopbits;
    private int parity;
    private int flowControlMode;

    public SerialParameters()
    {
        name = null;
        model = "unknown";
        baudRate = 0;
        databits = 0;
        stopbits = 0;
        parity = 0;
        flowControlMode = 0;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setBaudRate(int baudRate)
    {
        this.baudRate = baudRate;
    }

    public int getBaudRate()
    {
        return baudRate;
    }

    public void setDatabits(int databits)
    {
        this.databits = databits;
    }

    public int getDatabits()
    {
        return databits;
    }

    public void setStopbits(int Stopbits)
    {
        stopbits = Stopbits;
    }

    public int getStopbits()
    {
        return stopbits;
    }

    public void setParity(int parity)
    {
        this.parity = parity;
    }

    public int getParity()
    {
        return parity;
    }

    public void setFlowControlMode(int flowControlMode)
    {
        this.flowControlMode = flowControlMode;
    }

    public int getFlowControlMode()
    {
        return flowControlMode;
    }
}
