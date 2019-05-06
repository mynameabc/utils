package communal.util;


import org.apache.logging.log4j.Logger;

public class LogUtil {

    public static void error(Logger logger) {
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
