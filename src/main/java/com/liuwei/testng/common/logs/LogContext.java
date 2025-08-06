package com.liuwei.testng.common.logs;

import java.io.Serializable;

public class LogContext implements Serializable {

    private long threadId;
    private String traceId;

    public StringBuffer getLogBuffer() {
        return logBuffer;
    }

    public void setLogBuffer(StringBuffer logBuffer) {
        this.logBuffer = logBuffer;
    }

    private StringBuffer logBuffer = new StringBuffer();

    public LogContext(){

    }

    public void setThreadId(long threadId){
        this.threadId = threadId;
    }
    public void setTraceId(String traceId){
        this.traceId = traceId;
    }

    public String getTraceId(String traceId){
        return this.traceId;
    }

    public long getThreadId(){
        return this.threadId;
    }

}
