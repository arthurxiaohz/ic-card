package cn.net.iccard.util;



import java.math.BigDecimal;

public abstract class MoneyUtil {

	// Ĭ�ϳ������㾫��
	private static final int DEF_DIV_SCALE = 10;

	/**
	 * �������ؾ�ȷ���ֵ����Ϳɶ����.
	 * 
	 * @param amount
	 *            ��ȷ��1/10��.
	 * @return ���ͷֵ�λ
	 */
	public static String parseReadableAmount(Long amount) {
		try {
			BigDecimal bigDecimal = new BigDecimal(Long.toString(amount));
			return bigDecimal.divide(new BigDecimal("100"), 0,
					BigDecimal.ROUND_HALF_UP).toString();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * ������λΪ1/10������Ϳɶ���� �� �������뵽�ֵ����Ϳɶ����.
	 * 
	 * @param amount ��ȷ��1/10��.
	 * @return ���ͷֵ�λ
	 */
	public static Long parseAmountToRoundCent(Long amount) {
		return (new BigDecimal(amount).divide(new BigDecimal("100")))
			.setScale(0, BigDecimal.ROUND_HALF_UP).longValue();
	}

	/**
	 * �ӿɶ��ķֽ��������ؾ�ȷ��1/10��Ľ��.
	 * 
	 * @param amountStr
	 *            ��λС���ķֵ�λ
	 * @return ������1/10��
	 */
	public static Long parseFromReadableAmount(String amountStr) {
		try {
			return new Long(new BigDecimal(amountStr).multiply(
					new BigDecimal("100")).longValue());
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * �������(�ӷֵ�������λС����Ԫ��λ)
	 */
	public static String parseFromReadableAmountToRMB(String amount) {
		try {
			BigDecimal bigDecimal = new BigDecimal(amount);
			return bigDecimal.divide(new BigDecimal("100"), 2,
					BigDecimal.ROUND_HALF_UP).toString();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * �������(��ʮ��֮һ�嵽������λС����Ԫ��λ)
	 */
	public static BigDecimal parseFromReadableAmountToRMB(Long amount) {
		try {
			BigDecimal bigDecimal = new BigDecimal(amount);
			return bigDecimal.divide(new BigDecimal("10000"), 2,
					BigDecimal.ROUND_HALF_UP);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * �������(Ԫ��λ��ʮ��֮һ��)
	 */
	public static String parseFromRMBToReadableAmount(String amount) {
		try {
			return String.valueOf(parseFromRMBToReadableAmountLong(amount));
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * �������(Ԫ��λ��ʮ��֮һ��)
	 * 
	 * @param amount
	 * @return
	 */
	public static Long parseFromRMBToReadableAmountLong(String amount) {
		try {
			return new BigDecimal(amount).multiply(new BigDecimal("10000"))
					.longValue();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * �������(Ԫ��λ��ʮ��֮һ��)
	 */
	public static Long parseFromRMBToReadableAmount(BigDecimal amount) {
		try {
			return amount.multiply(new BigDecimal("10000")).setScale(0, BigDecimal.ROUND_HALF_UP).longValue();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * �������ӷֵ�λ��������λС����Ԫ��λ��
	 */
	public static String parseFromFenAmountToRMB(String amount) {
		try {
			BigDecimal bigDecimal = new BigDecimal(amount);
			return bigDecimal.divide(new BigDecimal("100"), 2,
					BigDecimal.ROUND_HALF_UP).toString();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * �������(�Ӵ�����λС����Ԫ��λ����)
	 */
	public static String parseFromRMBAmountToFen(String amount) {
		try {
			return String.valueOf(new BigDecimal(amount).multiply(
					new BigDecimal("100")).longValue());
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * ��λС����Ԫ��λ��С�Ƚ�
	 */
	public static boolean isCopmare(String first, String second) {
		first = parseFromRMBToReadableAmount(first);
		second = parseFromRMBToReadableAmount(second);
		if (Double.valueOf(first) > Double.valueOf(second)) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * �ṩ��ȷ�ļӷ����㡣
	 * 
	 * @param v1
	 *            ������
	 * 
	 * @param v2
	 *            ����
	 * 
	 * @return ���������ĺ�
	 * 
	 */

	public static double add(double v1, double v2) {

		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));

		return b1.add(b2).doubleValue();

	}

	/**
	 * 
	 * �ṩ��ȷ�ļ������㡣
	 * 
	 * @param v1
	 *            ������
	 * 
	 * @param v2
	 *            ����
	 * 
	 * @return ���������Ĳ�
	 * 
	 */

	public static double sub(double v1, double v2) {

		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));

		return b1.subtract(b2).doubleValue();

	}

	public static double sub(String v1, String v2) {

		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);

		return b1.subtract(b2).doubleValue();

	}

	/**
	 * 
	 * �ṩ��ȷ�ĳ˷����㡣
	 * 
	 * @param v1
	 *            ������
	 * 
	 * @param v2
	 *            ����
	 * 
	 * @return ���������Ļ�
	 * 
	 */

	public static double mul(double v1, double v2) {

		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));

		return b1.multiply(b2).doubleValue();

	}

	/**
	 * 
	 * �ṩ��ȷ�ĳ˷����㡣
	 * 
	 * @param v1
	 *            ������
	 * 
	 * @param v2
	 *            ����
	 * 
	 * @return ���������Ļ�
	 * 
	 */

	public static BigDecimal multiply(String v1, String v2) {

		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);

		return b1.multiply(b2);

	}

	/**
	 * 
	 * �ṩ��ȷ�ĳ˷����㣬����������롣
	 * 
	 * @param v1
	 *            ������
	 * @param v2
	 *            ����
	 * @param scale
	 *            ����
	 * @return ���������Ļ�
	 */

	public static double multiply(double v1, double v2, int scale) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.multiply(b2).setScale(scale, BigDecimal.ROUND_HALF_UP)
				.doubleValue();
	}

	/**
	 * 
	 * �ṩ����ԣ���ȷ�ĳ������㣬�����������������ʱ����ȷ��
	 * 
	 * С�����Ժ�10λ���Ժ�������������롣
	 * 
	 * @param v1
	 *            ������
	 * 
	 * @param v2
	 *            ����
	 * 
	 * @return ������������
	 * 
	 */

	public static double div(double v1, double v2) {

		return div(v1, v2, DEF_DIV_SCALE);

	}

	/**
	 * 
	 * �ṩ����ԣ���ȷ�ĳ������㡣�����������������ʱ����scale����ָ
	 * 
	 * �����ȣ��Ժ�������������롣
	 * 
	 * @param v1
	 *            ������
	 * 
	 * @param v2
	 *            ����
	 * 
	 * @param scale
	 *            ��ʾ��Ҫ��ȷ��С�����Ժ�λ��
	 * 
	 * @return ������������
	 * 
	 */

	public static double div(double v1, double v2, int scale) {

		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}

		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));

		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();

	}

	/**
	 * 
	 * �ṩ��ȷ��С��λ�������봦��
	 * 
	 * @param v
	 *            ��Ҫ�����������ֵ
	 * 
	 * @param scale
	 *            С���������λС��
	 * 
	 * @return ���������Ľ��
	 * 
	 */

	public static Double round(double v, int scale) {

		if (scale < 0) {
			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");
		}

		BigDecimal b = new BigDecimal(Double.toString(v));
		BigDecimal one = new BigDecimal("1");

		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();

	}
}
