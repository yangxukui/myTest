//package com.liuwei.testng.tr;
//
//import static  com.liuwei.testng.common.TestConfigManager.getConfigByKey;
//
//import com.liuwei.testng.base.LogUtils;
//import com.liuwei.testng.common.JsonUtil;
//import org.testng.Assert;
//
//import java.lang.reflect.Method;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//public class TrClient {
//    private static Map<String, Object> clientCache = new ConcurrentHashMap<>();
//
//    public static <T,R> R call(String serviceUrlConfigName, Class<?> servicceClass , String methodName, Class<T>requestClass,
//                               List<Object> parameterList){
//        Method method = null;
//        try{
//            method = servicceClass.getMethod(methodName,requestClass);
//        }catch (NoSuchMethodException e){
//            Assert.fail(e.getMessage(), e);
//        }
//        String serviceAddress = getConfigByKey(serviceUrlConfigName);
//        Assert.assertNotNull(serviceAddress, "failed to fetch tr address config");
//        return (R) TrClient.call(serviceAddress, servicceClass, method, parameterList);
//    }
//
//    public static <T> Object call(String serviceUrl, Class<T> servicce, Method method,List<Object> parameterList){
//        LogUtils.info("============ call Tr:"+ servicce.getName());
//        printParameterList(parameterList);
//
//        Object result = null;
//        Object[] parameterArray = null;
//
//        if(parameterList != null){
//            parameterArray = parameterList.toArray();
//        }
//
//        try {
//
//        }
//
//    }
//    public static void printParameterList(List<Object> parameterList){
//        if(parameterList == null){
//            return;
//        }
//        LogUtils.info("Tr request:");
//        for(Object parameter:parameterList){
//            if(parameter != null){
//                printPretty(parameter);
//            }else {
//                LogUtils.info("The parameter is null");
//            }
//        }
//    }
//    public static void printPretty(Object object){
//        try{
//            LogUtils.info(JsonUtil.getPrettyJson(object));
//        }catch (Exception e){
//
//        }
//    }
//
//    public static <T> T getClient(Class<T> service, String serviceUrl){
//        String key = serviceUrl + service.getSimpleName();
//        synchronized (clientCache){
//            if(clientCache.get(serviceUrl) == null){
//                LogUtils.info("construct rpc client"+serviceUrl);
//                Object proxy =
//            }
//        }
//
//    }
//
//    private static <T> Object constructReference(Class<T> service, String serviceUrl){
//
//
//    }
//}
