package com.yoopay.testng.common.logs;

public class LogView {

    protected static final ThreadLocal<LogContext> contextHolder = new ThreadLocal<>();

    public LogView(){

    }

    public static void starLogger(){
        LogContext logContext = new LogContext();
        logContext.setThreadId(Thread.currentThread().getId());
        logContext.setTraceId(String.valueOf(Thread.currentThread().getId()));
        contextHolder.set(logContext);
    }

    public static LogContext getLogContext(){
        return (LogContext)contextHolder.get();
    }


}
