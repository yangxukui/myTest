package com.yoopay.testng.common;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JsonUtil {

    public static Map<String,String> getHeaderMapFromJson(JSONObject json){
        Map<String,String> headMap = new HashMap<>(16);
        Iterator iterator = json.keySet().iterator();
        while (iterator.hasNext()){
            String key = (String) iterator.next();
            String value = json.getString(key);
            headMap.put(key,value);
        }
        return headMap;
    }

    public static String getPrettyJson(Object o){
        try{
            return JSON.toJSONString(o,true);
        }catch (Exception e){
            return o.toString();
        }
    }
}
