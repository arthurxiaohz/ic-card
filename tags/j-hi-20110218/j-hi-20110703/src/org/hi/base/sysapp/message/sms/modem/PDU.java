// Decompiled by Jad v1.5.7g. Copyright 2000 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/SiliconValley/Bridge/8617/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi 
// Source File Name:   PDU.java

package org.hi.base.sysapp.message.sms.modem;


class PDU
{

    private final String ISO = "iso-8859-1";
    private final String UNI = "unicode";
    private String sSMCAddr;
    private String sDestAddr;
    private String sTime;

    PDU()
    {
    }

    public void setSMCAddr(String sValue)
    {
        sSMCAddr = sValue;
    }

    public String getSMCAddr()
    {
        return sSMCAddr;
    }

    public void setDestAddr(String sValue)
    {
        sDestAddr = sValue;
    }

    public String getDestAddr()
    {
        return sDestAddr;
    }

    private void setTime(String sValue)
    {
        sTime = sValue;
    }

    public String getTime()
    {
        return sTime;
    }

    private String int2hex(int i)
        throws Exception
    {
        if(i > 0)
            if(i < 16)
                return "0" + Integer.toHexString(i).toUpperCase();
            else
                return Integer.toHexString(i);
        if(i < 0)
            return Integer.toHexString(i).substring(6, 8).toUpperCase();
        else
            return "00";
    }

    private int hex2int(String s)
        throws Exception
    {
        getClass();
        byte b[] = s.getBytes("iso-8859-1");
        int r = 0;
        if(b[0] >= 48 && b[0] <= 57)
            r = (b[0] - 48) * 16;
        else
            r = ((b[0] - 65) + 10) * 16;
        if(b[1] >= 48 && b[1] <= 57)
            r += b[1] - 48;
        else
            r += (b[1] - 65) + 10;
        return r;
    }

    private String InvertStr(String s)
        throws Exception
    {
        byte b[] = s.getBytes("iso-8859-1");
        for(int i = 0; i < b.length; i += 2)
        {
            byte t = b[i];
            b[i] = b[i + 1];
            b[i + 1] = t;
        }

        return new String(b, "iso-8859-1");
    }

    public String encode(String sData)
        throws Exception
    {
        String sResult = "";
        int iLen = getSMCAddr().length();
        iLen = ((iLen & 0x1) != 0 ? iLen + 1 : iLen) / 2 + 1;
        sResult = sResult + int2hex(iLen);
        sResult = sResult + "91";
        String s = getSMCAddr();
        if(s.length() % 2 == 1)
            s = s + "F";
        sResult = sResult + InvertStr(s);
        sResult = sResult + "11";
        sResult = sResult + "00";
        s = getDestAddr();
        sResult = sResult + int2hex(s.length());
        sResult = sResult + "91";
        if(s.length() % 2 == 1)
            s = s + "F";
        sResult = sResult + InvertStr(s);
        sResult = sResult + "00";
        sResult = sResult + "08";
        sResult = sResult + "00";
        if(sData.equals(""))
            sData = " ";
        sResult = sResult + int2hex(sData.length() * 2);
        byte b[] = sData.getBytes("unicode");
        for(int i = 2; i < b.length; i += 2)
            sResult = sResult + int2hex(b[i + 1]) + int2hex(b[i]);

        return sResult;
    }

    private String decode7(int data[])
        throws Exception
    {
        int iLen = data.length;
        int i = 0;
        int iByte = 0;
        int iLeft = 0;
        int iDst = 0;
        byte r[] = new byte[iLen];
        for(; i < iLen; i++)
        {
            byte b = (byte)((data[i] << iByte | iLeft) & 0x7f);
            iLeft = data[i] >> 7 - iByte;
            iDst++;
            if(++iByte == 7)
            {
                data[i] = iLeft;
                iDst++;
                iByte = 0;
                iLeft = 0;
            }
            r[i] = b;
        }

        return new String(r);
    }

    private String decode16(int data[])
        throws Exception
    {
        byte r[] = new byte[data.length + 2];
        r[0] = -1;
        r[1] = -2;
        int i = 0;
        for(int j = 0; j < data.length / 2; j++)
        {
            r[i + 2] = (byte)data[i + 1];
            r[i + 3] = (byte)data[i];
            i += 2;
        }

        return new String(r, "unicode");
    }

    public String decodePDU(String sPDU)
        throws Exception
    {
        String sResult = "";
        String sLen = sPDU.substring(0, 2);
        int iLen = hex2int(sLen) - 1;
        int iOffset = 0;
        String sTemp = InvertStr(sPDU.substring(4, iLen * 2));
        if(sPDU.charAt((iLen + 1) * 2) == 'F')
            setSMCAddr(sTemp.substring(0, sTemp.length() - 2));
        else
            setSMCAddr(sTemp);
        iOffset = iLen * 2 + 4;
        sTemp = sPDU.substring(iOffset, iOffset + 2);
        int iRe = hex2int(sTemp);
        iOffset += 2;
        sLen = sPDU.substring(iOffset, iOffset + 2);
        iLen = hex2int(sLen);
        iOffset += 4;
        if(iRe == 0)
        {
            sTemp = "";
        } else
        {
            if(iLen % 2 == 0)
            {
                sTemp = sPDU.substring(iOffset, iOffset + iLen);
                iOffset += iLen + 2;
            } else
            {
                sTemp = sPDU.substring(iOffset, iOffset + iLen + 1);
                iOffset += iLen + 1 + 2;
            }
            sTemp = InvertStr(sTemp).substring(0, iLen);
        }
        setDestAddr(sTemp);
        sTemp = sPDU.substring(iOffset, iOffset + 2);
        int iCode = hex2int(sTemp);
        iOffset += 2;
        sTemp = sPDU.substring(iOffset, iOffset + 14);
        setTime(InvertStr(sTemp));
        iOffset += 14;
        sLen = sPDU.substring(iOffset, iOffset + 2);
        iLen = hex2int(sLen);
        iOffset += 2;
        sTemp = sPDU.substring(iOffset, iOffset + iLen * 2);
        int iArrResult[] = new int[iLen];
        int i = 0;
        for(int j = 0; i < sTemp.length(); j++)
        {
            iArrResult[j] = hex2int(sTemp.substring(i, i + 2));
            i += 2;
        }

        if(iCode == 0)
            sResult = decode7(iArrResult);
        else
        if(iCode == 8)
            sResult = decode16(iArrResult);
        else
            sResult = "";
        return sResult;
    }

    public String encodeUCS2(String sData)
        throws Exception
    {
        String sResult = "";
        byte b[] = sData.getBytes("unicode");
        for(int i = 2; i < b.length; i += 2)
            sResult = sResult + int2hex(b[i + 1]) + int2hex(b[i]);

        return sResult;
    }

    public String decodeUCS2(String sData)
        throws Exception
    {
        try
        {
            int iLen = sData.length() / 2;
            int iArrResult[] = new int[iLen];
            int i = 0;
            for(int j = 0; i < sData.length(); j++)
            {
                iArrResult[j] = hex2int(sData.substring(i, i + 2));
                i += 2;
            }

            return decode16(iArrResult);
        }
        catch(Exception e)
        {
            throw e;
        }
    }
}
