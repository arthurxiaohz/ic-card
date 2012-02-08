// Decompiled by Jad v1.5.7g. Copyright 2000 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/SiliconValley/Bridge/8617/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi 
// Source File Name:   SmsPort.java

package org.hi.base.sysapp.message.sms.modem;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.comm.CommPortIdentifier;
import javax.comm.NoSuchPortException;
import javax.comm.PortInUseException;
import javax.comm.UnsupportedCommOperationException;



public class SmsPort
{

    private final String OK = "OK";
    private final String ERROR = "ERROR";
    private final byte ESC = 27;
    private String smsPort = "COM4";
    private SerialConnection SerialConn;

    public SmsPort(String smsPort)
    {
    	if(smsPort != null) this.smsPort = smsPort;
        SerialConn = new SerialConnection();
    }
    
    public SmsPort()
    {
        SerialConn = new SerialConnection();
    }

    public void open(SerialParameters param)
        throws UnsupportedCommOperationException, IOException, PortInUseException, NoSuchPortException
    {
        SerialConn.open(param);
        try
        {
            init();
        }
        catch(Exception exception) { }
    }

    public void close()
    {
        SerialConn.close();
    }

    public boolean isOpen()
    {
        return SerialConn.isOpen();
    }

    public SerialConnection getSerialConn()
    {
        return SerialConn;
    }

    public void sendCommand(String data)
        throws IOException
    {
        try
        {
            SerialConn.write(data + "\r");
            Thread.sleep(100L);
        }
        catch(InterruptedException interruptedexception) { }
    }

    public void sendData(byte data[])
        throws IOException
    {
        try
        {
            SerialConn.write(data);
            Thread.sleep(100L);
        }
        catch(InterruptedException interruptedexception) { }
    }

    public void sendData(String data)
        throws IOException
    {
        try
        {
            SerialConn.write(data);
            Thread.sleep(100L);
        }
        catch(InterruptedException interruptedexception) { }
    }

    public String receiveData()
    {
        try
        {
            return SerialConn.read();
        }
        catch(IOException ioexception)
        {
            return null;
        }
    }

    public void sendMessage(String mobileNum, String stMsg)
        throws Exception
    {
        PDU pdu = new PDU();
        String encodeMsg = pdu.encodeUCS2(stMsg);
        sendCommand("AT+CMGS=\"" + mobileNum + "\"");
        boolean b = true;
        int i = 0;
        while(b) 
        {
            String ret = receiveData();
            if(ret.indexOf("ERROR") != -1)
                throw new Exception();
            if(ret.indexOf(">") != -1)
            {
                sendData(encodeMsg + '\032');
                break;
            }
            i++;
            Thread.sleep(200L);
            if(i > 10)
                throw new Exception();
        }
        i = 0;
        while(b) 
        {
            String ret = receiveData();
            if(ret.indexOf("ERROR") != -1)
                throw new Exception();
            if(ret.indexOf("OK") != -1)
            {
                System.out.println("Send Success!");
                break;
            }
            i++;
            Thread.sleep(200L);
            if(i > 10)
                throw new Exception();
        }
    }

    public Vector receiveMessage()
        throws Exception
    {
        Vector v = new Vector();
        sendCommand("AT+CMGL=\"ALL\"");
        String ret = "";
        for(String dd = receiveData(); !dd.equals(""); dd = receiveData())
            ret = ret + dd;

        if(ret != null && !ret.trim().equals(""))
        {
            boolean b = false;
            String id = null;
            String time = null;
            String mobile = null;
            String msg = null;
            for(StringTokenizer st = new StringTokenizer(ret, "\n"); st.hasMoreTokens();)
            {
                ret = st.nextToken().trim();
                if(ret != null && !ret.equals(""))
                    if(b && ret.indexOf("OK") == -1 && ret.toUpperCase().indexOf("+CMGL") == -1)
                    {
                        System.out.println(ret);
                        try
                        {
                            deleteMessage(id);
                            java.util.Date d = null;
                            try
                            {
                                DateFormat df = new SimpleDateFormat("yy/MM/dd,HH:mm:ss");
                                d = df.parse(time);
                            }
                            catch(ParseException e)
                            {
                                System.err.println(e);
                            }
                            try
                            {
                                PDU pdu = new PDU();
                                msg = pdu.decodeUCS2(ret.substring(0, ret.length()));
                            }
                            catch(Exception e)
                            {
                                msg = null;
                            }
                            msg.trim().equals("");
                            Sms s = new Sms(mobile, msg, d);
                            v.add(s);
                            b = false;
                            id = null;
                            time = null;
                            mobile = null;
                            msg = null;
                        }
                        catch(Exception exception) { }
                    } else
                    if(ret != null && !ret.equals("") && ret.toUpperCase().startsWith("+CMGL"))
                    {
                        StringTokenizer st2 = new StringTokenizer(ret, ",");
                        for(int i = 0; st2.hasMoreTokens(); i++)
                        {
                            String ret2 = st2.nextToken();
                            switch(i)
                            {
                            case 0: // '\0'
                                id = ret2.substring(7);
                                break;

                            case 2: // '\002'
                                mobile = ret2.substring(1, ret2.length() - 1);
                                break;

                            case 3: // '\003'
                                time = ret2;
                                break;

                            case 4: // '\004'
                                time = time + "," + ret2;
                                time = time.substring(1, time.length() - 1);
                                time = time.substring(0, time.indexOf("+"));
                                break;
                            }
                        }

                        b = false;
                        try
                        {
                            Integer.parseInt(id);
                            b = true;
                        }
                        catch(NumberFormatException numberformatexception) { }
                        if(b)
                            System.out.println(ret);
                    }
            }

        }
        return v;
    }

    public void deleteMessage(String id)
        throws Exception
    {
        for(String ret = ""; ret.indexOf("OK") == -1;)
        {
            sendCommand("AT+CMGD=" + id);
            Thread.sleep(1000L);
            ret = receiveData();
            System.out.println(ret);
            if(ret.indexOf("ERROR") != -1)
                throw new Exception();
        }

    }

    public void init()
        throws Exception
    {
        byte b2[] = {
            13, 10
        };
        int i = 0;
        boolean b = true;
        for(int j = 0; j < 5; j++)
        {
            sendData(b2);
            receiveData();
        }

        sendCommand("AT+CMGF=1");
        while(b) 
        {
            String ret = receiveData();
            Thread.sleep(100L);
            if(++i > 9)
                throw new Exception();
            if(ret.indexOf("ERROR") != -1)
                throw new Exception();
            if(ret.indexOf("OK") != -1)
                break;
        }
        sendCommand("AT+CSCS=\"CUSTOM\"");
        while(b) 
        {
            String ret = receiveData();
            Thread.sleep(100L);
            if(++i > 9)
                throw new Exception();
            if(ret.indexOf("ERROR") != -1)
                throw new Exception();
            if(ret.indexOf("OK") != -1)
                break;
        }
        sendCommand("AT+CSMP=16,168,0,8");
        while(b) 
        {
            String ret = receiveData();
            Thread.sleep(100L);
            if(++i > 9)
                throw new Exception();
            if(ret.indexOf("ERROR") != -1)
                throw new Exception();
            if(ret.indexOf("OK") != -1)
                break;
        }
        byte bt[] = {
            27, 27
        };
        sendData(bt);
        for(int j = 0; j < 10; j++)
            receiveData();

    }

    public synchronized SerialParameters detectSmsPort()
    {
        SerialParameters param = isGprsPort(smsPort);
        if(param != null)
            return param;
        CommPortIdentifier PortId = null;
        for(Enumeration e = CommPortIdentifier.getPortIdentifiers(); e.hasMoreElements();)
        {
            PortId = (CommPortIdentifier)e.nextElement();
            if(PortId.getPortType() == 1)
            {
                param = isGprsPort(PortId.getName());
                if(param != null)
                    return param;
            }
        }

        return null;
    }

    public synchronized SerialParameters isGprsPort(String PortName)
    {
        SerialParameters param = new SerialParameters();
        SerialConnection conn = new SerialConnection();
        int staybaudRate[] = {
            9600, 115200, 19200, 38400
        };
        for(int i = 0; i < staybaudRate.length; i++)
        {
            param.setName(PortName);
            param.setBaudRate(staybaudRate[i]);
            param.setDatabits(8);
            param.setStopbits(1);
            param.setParity(0);
            param.setFlowControlMode(0);
            try
            {
                conn.open(param);
                if(!conn.isOpen())
                    return null;
                conn.write("AT\r");
                String result = conn.read();
                if(result.indexOf("OK") == -1)
                {
                    conn.close();
                } else
                {
                    conn.close();
                    return param;
                }
            }
            catch(Exception e)
            {
                conn.close();
            }
        }

        return null;
    }
}
