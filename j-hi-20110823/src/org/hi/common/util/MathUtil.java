/**
 * @{#} MathUtil.java Create on May 29, 2010
 *
 * Copyright (c) 2010 by xinfeng
 */
package org.hi.common.util;

import java.math.BigDecimal;

/** 
 * @author xinfeng <br>
 *         email: bkyangxinfeng@hotmail.com 
 * @version 1.0
 * @description 
 */
public class MathUtil {

	public static Double add(Double d1,Float f1) {
		BigDecimal b1 = new BigDecimal(Double.toString(d1));
		BigDecimal b2 = new BigDecimal(Float.toString(f1));
		return b1.add(b2).doubleValue();
	}
	
	public static Double sub(Double d1,Float f1) {
		BigDecimal b1 = new BigDecimal(Double.toString(d1));
		BigDecimal b2 = new BigDecimal(Float.toString(f1));
		return b1.subtract(b2).doubleValue();
	}
	
	public static Double add(Double d1,Double d2) {
		BigDecimal b1 = new BigDecimal(Double.toString(d1));
		BigDecimal b2 = new BigDecimal(Double.toString(d2));
		return b1.add(b2).doubleValue();
	}
	
	public static Double sub(Double d1,Double d2) {
		BigDecimal b1 = new BigDecimal(Double.toString(d1));
		BigDecimal b2 = new BigDecimal(Double.toString(d2));
		return b1.subtract(b2).doubleValue();
	}
	
	public static Double multiply(Double d1,Float f2) {
		return multiply(d1,new Double(f2));
	}
	
	public static Double multiply(Double d1,Double d2) {
		BigDecimal b1 = new BigDecimal(Double.toString(d1));
		BigDecimal b2 = new BigDecimal(Double.toString(d2));
		return b1.multiply(b2).doubleValue();
	}
	
	public static Double divide(Double d1,Float f2) {
		BigDecimal b1 = new BigDecimal(Double.toString(d1));
		BigDecimal b2 = new BigDecimal(Float.toString(f2));
		return b1.divide(b2).doubleValue();
	}
	
	public static Double divide(Double d1,Double d2) {
		BigDecimal b1 = new BigDecimal(Double.toString(d1));
		BigDecimal b2 = new BigDecimal(Double.toString(d2));
		return b1.divide(b2,10,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}
