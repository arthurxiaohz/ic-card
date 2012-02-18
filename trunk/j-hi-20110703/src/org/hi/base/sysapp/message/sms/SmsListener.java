// Decompiled by Jad v1.5.7g. Copyright 2000 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/SiliconValley/Bridge/8617/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi 
// Source File Name:   SmsListener.java

package org.hi.base.sysapp.message.sms;

import java.util.Vector;

public interface SmsListener
{

    public abstract void SmsArrive(Vector vector);
}
