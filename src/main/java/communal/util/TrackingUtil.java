package communal.util;

/**
 * @author 林少君
 * @date 2021/7/19 17:29
 */
public class TrackingUtil {

    // 跟踪Id 格式:202107191738193_6位随机字符串_时间戳
    private final static String trackId_1 = "${nowTime}_${currentTimeMillis}_${randomNumber}";

    // 跟踪Id 格式:202107191738193_6位随机字符串_时间戳_外部传进来的自定义字符串
    private final static String trackId_2 = "${nowTime}_${currentTimeMillis}_${randomNumber}_${customize}";

    /**
     * 格式:202107191738193_时间戳_6位随机字符串
     * 生成跟踪ID 并返回
     * @return String
     */
    public static String create() {

        String nowTime = getNowTime();
        String randomString = getRandomNumber(6);
        String currentTimeMillis = String.valueOf(System.currentTimeMillis());

        return trackId_1
                .replace("${nowTime}", nowTime)
                .replace("${randomNumber}", randomString)
                .replace("${currentTimeMillis}", currentTimeMillis);
    }

    public static String create(String customize) {

        String nowTime = getNowTime();
        String randomString = getRandomNumber(6);
        String currentTimeMillis = String.valueOf(System.currentTimeMillis());

        return trackId_2
                .replace("${nowTime}", nowTime)
                .replace("${customize}", customize)
                .replace("${randomNumber}", randomString)
                .replace("${currentTimeMillis}", currentTimeMillis);
    }

    private static String getNowTime() {
        return JodaTimeUtil.getCurrentDateTimeOther();
    }

    private static String getRandomString(int len) {
        return RandomUtil.generateString(len);
    }

    private static String getRandomNumber(int len) {
        return RandomUtil.getNumber(len);
    }

    public static void main(String[] args) {
        System.out.println(TrackingUtil.create());
    }
}
