package com.liuwei.testng.common;

public class StringUtil {

    public static String subStingAfter(String str, String separator){
        if(str != null && str.length() != 0){
            if (separator == null){
                return "";
            }else {
                int pos = str.indexOf(separator);
                return pos == -1? "" : str.substring(pos + separator.length());
            }
        }else{
            return str;
        }
    }

    public static String toUpperCase(String str){
        return str == null? null:str.toUpperCase();
    }

    public static boolean isBlank(String str){
        int strLen;
        if(str != null && (strLen = str.length()) != 0){
            for(int i= 0; i < strLen; ++i){
                if(!Character.isWhitespace(str.charAt(i))){
                    return false;
                }
            }
            return true;
        }else {
            return true;
        }
    }
}
