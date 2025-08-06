package com.liuwei.testng.common.logs;

import com.liuwei.testng.inter.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogUtil {

    public static void info(Logger logger, Object... objects){
        if(logger.isInfoEnabled()){
            logger.info(getLogString(objects));
        }
    }

    public static String getLogString(Object... objects){
        StringBuffer log = new StringBuffer();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.append(df.format(new Date()));
        if(LogView.getLogContext()!= null){
            log.append(",").append(LogView.getLogContext().getThreadId());
        }
        log.append(']');
        Object[] var2 = objects;
        int var3 = objects.length;

        for(int var4 = 0; var4 < var3; ++var4){
            Object o = var2[var4];
            log.append(o);
        }
        if(LogView.getLogContext() != null){
            LogView.getLogContext().getLogBuffer().append(log.toString() + "\n");
        }
        return log.toString();
    }
}
