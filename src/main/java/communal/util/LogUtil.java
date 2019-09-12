package communal.util;

import org.apache.logging.log4j.Logger;

public class LogUtil {

    public static void error(Logger logger) {
/*

        String logInfo = "";
        logInfo += "\n[" + GlobalConstants.PROJECT_NAME + "] - [" + joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "]\n";
        logInfo += "[入参]      - " + Arrays.toString(joinPoint.getArgs()) + "\n";
        logInfo += "[返回值]    - " + joinPoint.proceed() + "\n";
        logInfo += "[异常信息]  - " + joinPoint.proceed() + "\n";
        logger.info(logInfo);
*/

/*
        logger.error("[" + ProjectContact.PROJECT_NAME + "] - [入参] -     [" + methodName + "] - " + LogInfoEncryptUtil.getLogString(arguments) + "]");
        logger.error("[" + ProjectContact.PROJECT_NAME + "] - [返回结果] - [" + methodName + "] - " + LogInfoEncryptUtil.getLogString(result));*/
    }

    public static void warn(Logger logger) {
/*        logger.warn("[" + ProjectContact.PROJECT_NAME + "] - [入参] -     [" + methodName + "] - " + LogInfoEncryptUtil.getLogString(arguments) + "]");
        logger.warn("[" + ProjectContact.PROJECT_NAME + "] - [返回结果] - [" + methodName + "] - " + LogInfoEncryptUtil.getLogString(result));*/
    }

    public static void warn(Logger logger, Exception e) {
/*        logger.warn("[" + ProjectContact.PROJECT_NAME + "] - [入参] -     [" + methodName + "] - " + LogInfoEncryptUtil.getLogString(arguments) + "]");
        logger.warn("[" + ProjectContact.PROJECT_NAME + "] - [返回结果] - [" + methodName + "] - " + LogInfoEncryptUtil.getLogString(result));*/
    }

    public static void info(Logger logger) {
/*        logger.info("[" + ProjectContact.PROJECT_NAME + "] - [入参] -     [" + methodName + "] - " + LogInfoEncryptUtil.getLogString(arguments) + "]");
        logger.info("[" + ProjectContact.PROJECT_NAME + "] - [返回结果] - [" + methodName + "] - " + LogInfoEncryptUtil.getLogString(result));*/
    }

    public static void debug(Logger logger) {
/*        logger.debug("[" + ProjectContact.PROJECT_NAME + "] - [入参] -     [" + methodName + "] - " + LogInfoEncryptUtil.getLogString(arguments) + "]");
        logger.debug("[" + ProjectContact.PROJECT_NAME + "] - [返回结果] - [" + methodName + "] - " + LogInfoEncryptUtil.getLogString(result));*/
    }

    public static void trace(Logger logger) {
/*        logger.trace("[" + ProjectContact.PROJECT_NAME + "] - [入参] -     [" + methodName + "] - " + LogInfoEncryptUtil.getLogString(arguments) + "]");
        logger.trace("[" + ProjectContact.PROJECT_NAME + "] - [返回结果] - [" + methodName + "] - " + LogInfoEncryptUtil.getLogString(result));*/
    }

}
