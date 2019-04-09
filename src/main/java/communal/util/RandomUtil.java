package communal.util;

import java.util.Random;

public class RandomUtil {

	public static void main(String[] args) {
		
		String ccxl = generateNominateString(3);
		System.out.println(ccxl);
		
		String ccxl2 = getNumber(18);
		System.out.println(ccxl2);
		
		String ccxl3 = generateNominateNumber(3);
		System.out.println(ccxl3);
	}

	public static final String allChar1 = "123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String allChar2 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String allChar3 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String letterChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String numberChar1 = "123456789";
	public static final String numberChar2 = "0123456789";
	
	public static String generateNominateNumber(int length) {
		
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(numberChar1.charAt(random.nextInt(numberChar1.length())));
		}
		return sb.toString();
	}
	
	public static String generateNominateString(int length) {
		
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(allChar3.charAt(random.nextInt(allChar3.length())));
		}
		return sb.toString();
	}

	public static String generateString(int length) // 参数为返回随机数的长度
	{
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(allChar1.charAt(random.nextInt(allChar1.length())));
		}
		return sb.toString();
	}
	
	public static String getNumber(int length) {
		
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(allChar1.charAt(random.nextInt(numberChar1.length())));
		}
		return sb.toString();
	}
}
