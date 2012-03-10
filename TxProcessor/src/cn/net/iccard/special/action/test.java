package cn.net.iccard.special.action;

import java.math.BigDecimal;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigDecimal a = new BigDecimal("2.01").movePointRight(2);
		System.out.println(Integer.valueOf(new BigDecimal("2.01").movePointRight(2).toString()));
	}

}
