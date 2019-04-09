package communal.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	/**
	 *
	 * @param star
	 * @param end
	 * @return
	 */
	public static boolean isOrderTime(String star, String end) {

		SimpleDateFormat localTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();

		Date date = new Date();
		calendar.setTime(date);

		try{

			Date sdate = localTime.parse(calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" +  calendar.get(Calendar.DAY_OF_MONTH) + " " + star);
			Date edate = localTime.parse(calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" +  calendar.get(Calendar.DAY_OF_MONTH) + " " + end);

			if(date.after(sdate) && date.before(edate)){
				return true;
			} else{
				return false;
			}
		}catch(Exception e){}

		return false;
	}

	public static boolean isTime(Date orderTime, long lastTime) {

		long min = 0L;

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date1 = orderTime;
			Date date2 = new Date();
			long l = date2.getTime() - date1.getTime();
			long day = l / (24 * 60 * 60 * 1000);
			long hour = (l / (60 * 60 * 1000) - day * 24);
			min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
			long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (min >= lastTime) {
			return false;       //超过lastTime
		} else {
			return true;        //没有超过lastTime
		}
	}

	/**
	 * Date转String
	 * @return
	 */
	public static String dateFormatToString() {

		Date nowDate = new Date();
		SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format0.format(nowDate.getTime());
		return time;
	}

	/**
	 * Date转String
	 * @param date
	 * @return
	 */
	public static String dateFormatToString(Date date) {

		SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format0.format(date.getTime());
		return time;
	}

	/**
	 * String转Date
	 * @param date
	 * @return
	 */
	public static Date stringFormatDate(String date) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date _date = null;
		try {
			_date = sdf.parse(date);
		} catch (Exception e) {
			return null;
		}
		return _date;
	}

	/**
	 * String转DateTime
	 * @param date
	 * @return
	 */
	public static Date stringFormatDateTime(String date) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date _date = null;
		try {
			_date = sdf.parse(date);
		} catch (Exception e) {
			return null;
		}
		return _date;
	}

	/**
	 * 加10分钟
	 * @param createTime
	 * @return
	 */
	public static Date FormatDate(Date createTime) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date afterDate = new Date(createTime.getTime() + 600000);
		return afterDate;
	}

	/**
	 * 计算订单倒计时
	 * @param createTime
	 * @return
	 */
	public static Integer computOrderDateTime(Date createTime) {

		return differenceTime(FormatDate(createTime), new Date());
	}

	//返回2个时间的差值 （单位秒）
	public static Integer differenceTime(Date var1, Date var2) {
		return Math.toIntExact(Math.abs(var1.getTime() - var2.getTime()) / 1000);
	}

	//时间格式化拼接
	public static String operaTimeHoursMin(String time, Integer hours, Integer min) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date resultDate = sdf.parse(time);
		String resultTime = sdf.format(resultDate);
		if (hours < 10) {
			resultTime = resultTime + " 0" + hours;
		} else {
			resultTime = resultTime + " " + hours;
		}
		resultTime = resultTime + ":";
		if (min < 10) {
			resultTime = resultTime + "0" + min;
		} else {
			resultTime = resultTime + "" + min;
		}
		return resultTime;
	}

	public static void main(String args[]) {

		Date s = DateUtil.stringFormatDate("2018-10-10");
		System.out.println(s.getTime());
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

