package communal.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	/**
	 * 当前系统时间Date转String
	 * @param pattern yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String dateFormatToString(String pattern) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		return dateFormat.format(new Date().getTime());
	}

	/**
	 * Date转String
	 * @param dateTime
	 * @param pattern yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String dateFormatToString(Date dateTime, String pattern) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		return dateFormat.format(dateTime.getTime());
	}

	/**
	 * String转Date
	 * @param pattern yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static Date stringFormatToDate(String pattern) {
		try {
			return new SimpleDateFormat(pattern)
					.parse(dateFormatToString(pattern));
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * String转Date
	 * @param dateTime
	 * @param pattern yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static Date stringFormatToDate(String dateTime, String pattern) {
		try {
			return new SimpleDateFormat(pattern)
					.parse(dateTime);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 时间格式字符转成long类型的时间戳
	 * @param dateTime yyyy-MM-dd
	 * @param pattern HH:mm:ss
	 * @return
	 */
	public static Long stringDateFormatToLong(String dateTime, String pattern) {
		dateTime = dateTime.trim();
		dateTime = dateTime + " " + pattern;
		if (!RegexUtil.isDate(dateTime)) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				return sdf.parse(dateTime).getTime();
			} catch (Exception var3) {
				throw new ClassCastException();
			}
		} else {
			return -1L;
		}
	}

	public static void main(String args[]) {

		Date s = DateUtil.stringFormatToDate("2018-10-10", "yyyy-MM-dd");
		System.out.println(DateUtil.dateFormatToString("yyyyMMddHHmmss"));
/*
        DateUtil.StringFormatDate("2017-12-27 09:26:56");
        System.out.println(DateUtil.computOrderDateTime(DateUtil.StringFormatDate("2017-12-27 09:59:56")));

*/
/*        System.out.println(DateUtil.isOrderTime("09:00:00", "14:30:00"));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String str = sdf.format(new Date());
        System.out.print(str);*//*


        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date afterDate = new Date(now.getTime() + 600000);
        System.out.println(sdf.format(afterDate ));
*/


/*        String s = "2";
        if (MoneyUtil.Judgement("1", s)) {
            s = "0";
        } else {
            s = MoneyUtil.mul(s, "0.5");
        }

        System.out.println(s);

        System.out.println(DateUtil.dateFormatToString());*/

/*        System.out.println(Math.floor(0.01));
        System.out.println(MoneyUtil.add("0.0","1"));*/

//        System.out.println(DateUtil.differenceTime(new Date(), DateUtil.StringFormatDate(s)));
	}
}

