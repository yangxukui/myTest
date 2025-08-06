package com.liuwei.testng.common.logs;

import com.liuwei.testng.inter.Logger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.Field;

public class LoggerFactor extends LogFactory {
    private static boolean isLog4jJCLAvailable = false;
    private static Field loggerFieId = null;

    static {
        try{
            Class<?> log4jLogClass = LoggerFactor.class.getClassLoader().loadClass("org.apache.logging.log4j");
            loggerFieId = log4jLogClass.getDeclaredField("logger");
            loggerFieId.setAccessible(true);
            isLog4jJCLAvailable = true;
        }catch (Exception var){

        }
    }
    public static Logger getLogger(Class clazz){
        ClassLoader oldLoader = Thread.currentThread().getContextClassLoader();

        Logger var2;
        try{
            Thread.currentThread().setContextClassLoader(LogFactory.class.getClassLoader());
            var2 = getLogger(getLog(clazz));
        }finally {
            Thread.currentThread().setContextClassLoader(oldLoader);
        }
        return var2;
    }

    public static Logger getLogger(String name){
        ClassLoader oldLoader = Thread.currentThread().getContextClassLoader();

        Logger var2;
        try{
            Thread.currentThread().setContextClassLoader(LogFactory.class.getClassLoader());
            var2 = getLogger(getLog(name));
        }finally {
            Thread.currentThread().setContextClassLoader(oldLoader);
        }
        return var2;
    }

    private static Logger getLogger(Log log){
        if(log instanceof Logger){
            return (Logger) log;
        }else
            //if(isLog4jJCLAvailable && loggerFieId != null && log instanceof Log4JLogger)
            {
            try{
               org.apache.logging.log4j.core.Logger extendLogger = (org.apache.logging.log4j.core.Logger)loggerFieId.get(log);
                return new Log4j2Logger(extendLogger);
            }catch (IllegalAccessException var2){
                throw new RuntimeException(var2);
            }
        }

    }
}
