package communal.util;

import eu.bitwalker.useragentutils.DeviceType;
import eu.bitwalker.useragentutils.UserAgent;

public class UserAgentUtils {

    /**
     * 获取用户代理对象
     * @param userAgent
     * @return
     */
    public static UserAgent getUserAgent(String userAgent){
        return UserAgent.parseUserAgentString(userAgent);
    }
    
    /**
     * 获取设备类型
     * @param userAgent
     * @return
     */
    public static DeviceType getDeviceType(String userAgent){
        return getUserAgent(userAgent).getOperatingSystem().getDeviceType();
    }
    
    /**
     * 是否是PC
     * @param userAgent
     * @return
     */
    public static boolean isComputer(String userAgent){
        return DeviceType.COMPUTER.equals(getDeviceType(userAgent));
    }

    /**
     * 是否是手机
     * @param userAgent
     * @return
     */
    public static boolean isMobile(String userAgent){
        return DeviceType.MOBILE.equals(getDeviceType(userAgent));
    }
    
    /**
     * 是否是平板
     * @param userAgent
     * @return
     */
    public static boolean isTablet(String userAgent){
        return DeviceType.TABLET.equals(getDeviceType(userAgent));
    }

    /**
     * 是否是手机和平板
     * @param userAgent
     * @return
     */
    public static boolean isMobileOrTablet(String userAgent){
        DeviceType deviceType = getDeviceType(userAgent);
        return DeviceType.MOBILE.equals(deviceType) || DeviceType.TABLET.equals(deviceType);
    }

    public static void main(String args[]) {
        System.out.println();
    }
    
}