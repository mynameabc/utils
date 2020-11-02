package communal.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则验证
 * @author Administrator
 *
 */
public class RegexUtil {

    /**
     * 用户名验证
     * @param name
     * @return
     * 4-16位字母, 数字, 下划线或中文
     */
    public static boolean username(String name) {

        return Pattern.compile("^(?!\\d+$)(?=[a-zA-Z\\d_一-龥]*$).{6,18}$")
                .matcher(name)
                .matches();
    }

    /**
     * 密码验证
     * 大小写字母和数字的组合，不能使用特殊字符，长度在6-10之间
     * @param password
     * @return
     */
    public static boolean password(String password) {

        return Pattern.compile("^[\\S]{6,16}$")
                .matcher(password)
                .matches();
    }

    /**
     * 手机号码验证
     * @param mobile
     * @return
     */
    public static boolean isMobile(String mobile) {

        return Pattern.compile("^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$")
                .matcher(mobile)
                .matches();
    }

    /**
     * 邮箱地址验证
     * @param email
     * @return
     */
    public static boolean isEmail(String email) {

        return Pattern.compile("[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?")
                .matcher(email)
                .matches();
    }

    /**
     * 金钱格式验证
     * @param money
     * @return
     */
    public static boolean isMoney(String money) {

        return Pattern.compile("(^[1-9]([0-9]+)?(\\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\\.[0-9]([0-9])?$)")
                .matcher(money)
                .matches();
    }

    private static boolean isDate(String strDate) {
        Pattern pattern = Pattern
                .compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");
        Matcher m = pattern.matcher(strDate);
        if (m.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isIDCard(String idcard) {

        if (idcard.length() == 15) {

            return Pattern.compile("^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$")
                    .matcher(idcard)
                    .matches();
        }

        if (idcard.length() == 18) {

            return Pattern.compile("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$")
                    .matcher(idcard)
                    .matches();
        }

        return false;
    }

    public static void main(String [] args) {

        String money = null;
//        System.out.println(RegexUtil.username(money));
        if (money == null || money.length() <= 0) {
            System.out.println("不通过!");
        }

        System.out.println(RegexUtil.isMobile(""));

        /*
		System.out.println(RegexUtil.validator_Email("135@59193463.x"));
		System.out.println(RegexUtil.validator_Password("Aaa1231231"));*/

    }
}

