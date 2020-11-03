package communal.format;

import communal.util.RegexUtil;

import java.text.SimpleDateFormat;

public class ParameterFormatUtil {

    /**
     * 时间格式字符转成long类型的时间戳
     * @param stringDate yyyy-MM-dd
     * @param timeString HH:mm:ss
     * @return
     */
    public static Long stringDateFormatToLong(String stringDate, String timeString) {
        stringDate = stringDate.trim();
        stringDate = stringDate + " " + timeString;
        if (!RegexUtil.isDate(stringDate)) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                return sdf.parse(stringDate).getTime();
            } catch (Exception e) {
                throw new ClassCastException();
            }
        }
        return null;
    }
}
