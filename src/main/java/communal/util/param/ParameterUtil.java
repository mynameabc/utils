package communal.util.param;

import communal.util.DateUtil;

import java.math.BigDecimal;
import java.util.Date;
import java.util.regex.Pattern;

public class ParameterUtil {

    public static Date dateCheck(String parameter) {

        if (null == parameter || "".equals(parameter)) {
            return null;
        } else if ("".equals(parameter.trim())) {
            return null;
        }

        return DateUtil.stringFormatDate(parameter);
    }

    public static Date dateTimeCheck(String parameter, String added) {

        if (null == parameter || "".equals(parameter)) {
            return null;
        } else if ("".equals(parameter.trim())) {
            return null;
        }

        return DateUtil.stringFormatDateTime(parameter + " " + added);
    }

    public static BigDecimal bigDecimalCheck(String parameter, String defaultValue) {

        if (null == parameter || "".equals(parameter)) {
            return new BigDecimal(defaultValue);
        } else {
            if (parameter.trim().length() >= 1) {
                return new BigDecimal(parameter.trim());
            } else {
                return new BigDecimal(defaultValue);
            }
        }
    }

    public static Boolean booleanCheck(String parameter) {

        if (null == parameter || "".equals(parameter))
            return false;
        if (parameter.trim().length() <= 0)
            return false;
        if ("0".equals(parameter)) {
            return false;
        }
        return true;
    }

    public static Boolean booleanCheck(String parameter, boolean defaultValue) {

        if (null == parameter || "".equals(parameter))
            return defaultValue;
        if (parameter.trim().length() <= 0)
            return defaultValue;
        if ("0".equals(parameter)) {
            return defaultValue;
        }
        return true;
    }

    public static String stringCheck(String parameter, String defaultValue) {

        if (null == parameter || "".equals(parameter)) {
            return defaultValue;
        } else {
            if (parameter.trim().length() >= 1) {
                return parameter.trim();
            } else {
                return defaultValue;
            }
        }
    }

    public static Integer integerCheck(String parameter, Integer defaultValue) {

        if (null == parameter || "".equals(parameter))
            return defaultValue;

        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return (pattern.matcher(parameter).matches()) ? (Integer.valueOf(parameter)) : (defaultValue);
    }

    public static Long longCheck(String parameter, Long defaultValue) {

        if (null == parameter || "".equals(parameter))
            return defaultValue;

        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return (pattern.matcher(parameter).matches()) ? (Long.valueOf(parameter)) : (defaultValue);
    }
}
