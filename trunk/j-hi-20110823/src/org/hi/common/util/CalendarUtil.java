/**
 * @{#} CalendarUtil.java Create on May 28, 2010
 *
 * Copyright (c) 2010 by xinfeng
 */
package org.hi.common.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/** 
 * @author xinfeng <br>
 *         email: bkyangxinfeng@hotmail.com 
 * @version 1.0
 * @description 
 */
public class CalendarUtil {
	
	public static Timestamp getDateFor00(Calendar calendar) {
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return new Timestamp(calendar.getTimeInMillis());
	}
	public static Timestamp getDateFor23(Calendar calendar) {
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return new Timestamp(calendar.getTimeInMillis());
	}
	
	public static Timestamp getDateFor00(Date date) {
		if(date == null)
			return null;
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		return getDateFor00(calendar);
	}
	
	public static Timestamp getDateFor23(Date date) {
		if(date == null)
			return null;
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		return getDateFor23(calendar);
	}
	
	public static Timestamp getDateFor00(Timestamp timestamp) {
		if(timestamp == null)
			return null;
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(new Date(timestamp.getTime()));
		return getDateFor00(calendar);
	}
	
	public static Timestamp getDateFor23(Timestamp timestamp) {
		if(timestamp == null)
			return null;
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(new Date(timestamp.getTime()));
		return getDateFor23(calendar);
	}
	
}
