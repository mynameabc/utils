package communal.util;

import java.util.regex.Pattern;

/**
 * 正则验证
 * @author Administrator
 *
 */
public class RegexUtil {

    /**
     * 用户名验证
     * @param account
     * @return
     * 4-16位字母, 数字, 下划线或中文
     */
    public static boolean username(String account) {

        return Pattern.compile("^(?!\\d+$)(?=[a-zA-Z\\d_一-龥]*$).{6,18}$")
                .matcher(account)
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
     * @param mobileNumber
     * @return
     */
    public static boolean mobile(String mobileNumber) {

        return Pattern.compile("^1[3-9]\\d{9}$")
                .matcher(mobileNumber)
                .matches();
    }

    /**
     * 邮箱地址验证
     * @param EmailAddress
     * @return
     */
    public static boolean email(String EmailAddress) {

        return Pattern.compile("[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?")
                .matcher(EmailAddress)
                .matches();
    }

    /**
     * 金钱格式验证
     * @param money
     * @return
     */
    public static boolean money(String money) {

        return Pattern.compile("(^[1-9]([0-9]+)?(\\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\\.[0-9]([0-9])?$)")
                .matcher(money)
                .matches();
    }

    public static boolean validator_IDCard(String idcard) {

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

        System.out.println(RegexUtil.mobile(""));

        /*
		System.out.println(RegexUtil.validator_Email("135@59193463.x"));
		System.out.println(RegexUtil.validator_Password("Aaa1231231"));*/

    }
}

