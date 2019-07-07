package communal.util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MoneyUtil {
	
	// 默认除法运算精度
	private static final int DEF_DIV_SCALE = 16;

	/**
	 * 有效位数精度
	 */
	private static final int PRECISION = 3;

	private static MathContext mathContext = new MathContext(PRECISION);

	// 不能实例化
	private MoneyUtil() {}

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
		return b1.add(b2, mathContext).toString();
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
		return b1.subtract(b2, mathContext).toString();
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
		return b1.multiply(b2, mathContext).toString();
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
	 * 判断parameter1是否大于parameter2
	 * @param parameter1
	 * @param parameter2
	 * @return
	 */
	public static boolean greaterThan(String parameter1, String parameter2) {
		BigDecimal b1 = new BigDecimal(parameter1);
		BigDecimal b2 = new BigDecimal(parameter2);
		return (1 == b1.compareTo(b2)) ? (true) : (false);
	}

	/**
	 * 判断parameter1是否小于parameter2
	 * @param parameter1
	 * @param parameter2
	 * @return
	 */
	public static boolean lessThan(String parameter1, String parameter2) {
		BigDecimal b1 = new BigDecimal(parameter1);
		BigDecimal b2 = new BigDecimal(parameter2);
		return (-1 == b1.compareTo(b2)) ? (true) : (false);
	}
	
	/**
	 * 判断money1是否和money2相等
	 * @param money1
	 * @param money2
	 * @return
	 */
	public static boolean isEqual(String money1, String money2) {
		BigDecimal b1 = new BigDecimal(money1);
		BigDecimal b2 = new BigDecimal(money2);
		return (0 == b1.compareTo(b2)) ? (true) : (false);
	}

	/**
	 * 判断money是否可以被当做金钱被计算
	 * @param money
	 * @return
	 */
/*	public static boolean isMoney(String money) {

		return Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$").matcher(money).matches(); //判断小数点后2位的数字的正则表达式
	}*/

	/**
	 * 判断money是否可以被当做金钱被计算
	 * @param money
	 * @return
	 */
	public static boolean isMoney(String money){

		if(money == null || money.trim().length() == 0){
			return false;
		}

		char[] chars = money.toCharArray();
		int sz = chars.length;
		int i = (chars[0] == '-') ? 1 : 0;
		if(i == sz) return false;

		if(chars[i] == '.') return false;//除了负号，第一位不能为'小数点'

		boolean radixPoint = false;
		for(; i < sz; i++){
			if(chars[i] == '.'){
				if(radixPoint) return false;
				radixPoint = true;
			}else if(!(chars[i] >= '0' && chars[i] <= '9')){
				return false;
			}
		}
		return true;
	}

	public static void main(String args[]) {

		String money = "-0.0123";
		System.out.println(MoneyUtil.isMoney(money));

/*		try {
			System.out.println(MoneyUtil.getPercent("10000", "100"));
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}
}
