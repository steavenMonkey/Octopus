package org.xuanchan.common.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Formatter;
import org.slf4j.Logger;

public class LoggerUtil {

    private static Formatter formatter = new Formatter();

    /**
     * 记录INFO级别日志
     * 
     * @param logger
     * @param msg 待格式的内容，使用%s作为占位符 eg：userName: %s
     * @param args 占位值数组
     */
    public static void info(Logger logger, String msg, Object... args) {
        logger.info(formatMsg(msg, args));
    }

    /**
     * 记录ERROR级别日志
     *
     * @param logger
     * @param msg 待格式的内容，使用%s作为占位符 eg：userName: %s
     * @param args 占位值数组
     */
    public static void error(Logger logger, String msg, Object... args) {
        logger.error(formatMsg(msg, args));
    }

    /**
     * 记录ERROR级别日志，带异常栈
     * 
     * @param logger
     * @param e
     * @param msg 待格式的内容，使用%s作为占位符 eg：userName: %s
     * @param args 占位值数组
     */
    public static void error(Logger logger, Throwable e, String msg, Object... args) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        e.printStackTrace(printWriter);
        msg = msg + "\n\r" + stringWriter.toString();
        logger.error(formatMsg(msg, args));
    }

    /**
     * 记录WARN级别日志
     * 
     * @param logger
     * @param msg 待格式的内容，使用%s作为占位符 eg：userName: %s
     * @param args 占位值数组
     */
    public static void warn(Logger logger, String msg, Object... args) {
        logger.warn(formatMsg(msg, args));
    }

    private static String formatMsg(String msg, Object... args) {
        return formatter.format(msg, args).toString();
    }

}
