package com.liuwei.testng.base;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogUtils {

    public static void info(String msg){
//        LogUtil.info(LOGGER,msg);
//        Reporter.log(msg);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.print("["+df.format(new Date())+"]"+msg+"\n");
    }
}
