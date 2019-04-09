package communal.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;



/**
 * 目标：封装加减乘除操作的自定义工具类 原因：float ,double
 * 只能用来做科学计算或者工程计算，但在商业计算中要用java.math.BigDecimal 创建人: 李林君 邮箱：liljb@yonyou.com
 * 创建日期: 2013-9-28
 * <p>
 * 
 * @version 1.0
 * @since NC5.7
 */
public class MoneyUtil {
	
	// 默认除法运算精度
	private static final int DEF_DIV_SCALE = 16;

	// 不能实例化
	private MoneyUtil() {
	}

	/**
	 * 说明： 提供精确的加法运算 创建人: 李林君 邮箱：liljb@yonyou.com 创建日期: 2013-9-28
	 * 
	 * @param v1
	 *            被加数
	 * @param v2
	 *            加数
	 * @return 两个参数的和
	 */
	public static String add(String v1, String v2) {

		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);

		return b1.add(b2).toString();
	}

	/**
	 * 说明： 提供精确的减法运算 创建人: 李林君 邮箱：liljb@yonyou.com 创建日期: 2013-9-28
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static String sub(String v1, String v2) {

		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);

		return b1.subtract(b2).toString();
	}

	/**
	 * 说明： 提供精确的乘法运算 创建人: 李林君 邮箱：liljb@yonyou.com 创建日期: 2013-9-28
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static String mul(String v1, String v2) {

		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);

		return b1.multiply(b2).toString();
	}

	/**
	 * 说明： 提供相对精确的除法运算，当发生除不尽的情况，精确到.后10位 创建人: 李林君 邮箱：liljb@yonyou.com 创建日期:
	 * 2013-9-28
	 * 
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static String div(String v1, String v2) {

		return div(v1, v2, DEF_DIV_SCALE);
	}

	/**
	 * 说明： 创建人: 李林君 邮箱：liljb@yonyou.com 创建日期: 2013-9-28
	 * 
	 * @param v1
	 * @param v2
	 * @param scale
	 * @return
	 */
	private static String div(String v1, String v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(
					" the scale must be a positive integer or zero");
		}

		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);

		return b1.divide(b2, scale, BigDecimal.ROUND_UP).toString();// scale
																			// 后的四舍五入
	}
	
	/**
	 * 显示百分比
	 * @return
	 */
	public static String getPercent(String v1, String v2) {

		String p = div(v1, v2);
		DecimalFormat nf = (DecimalFormat) NumberFormat.getPercentInstance();
		nf.applyPattern("0%"); //00表示小数点2位
		nf.setMaximumFractionDigits(5); //2表示精确到小数点后2位
		return nf.format(p);
	}
	
	/**
	 * 判断v1是否大于v2
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static boolean GreaterThan(String v1, String v2) {
		
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		
		String _temp = b1.subtract(b2).toString();
		
		if (Double.parseDouble(_temp) > 0) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * 判断v1是否大于或者等于v2
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static boolean Judgement(String v1, String v2) {
		
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		
		String _temp = b1.subtract(b2).toString();
		
		if (Double.parseDouble(_temp) >= 0) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * 判断v1是否小于v2
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static boolean LessThan(String v1, String v2) {
		
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		
		String _temp = b1.subtract(b2).toString();
		if (Double.parseDouble(_temp) < 0) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * 判断v1是否和v2相等
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static boolean isEqual(String v1, String v2) {
		
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		
		String _temp = b1.subtract(b2).toString();
		
		if (Double.parseDouble(_temp) == 0) {
			return true;
		}
		
		return false;
	}

}
