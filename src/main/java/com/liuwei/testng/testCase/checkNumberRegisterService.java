package com.liuwei.testng.testCase;

import com.liuwei.testng.base.LogUtils;
import com.liuwei.testng.common.PatternHelper;
import com.liuwei.testng.common.RequestService;
import com.liuwei.testng.common.TestConfigManager;


import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Request;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class checkNumberRegisterService {

    public  Map<String,String> checkNumberRegister(String inputPhoneNumber){
            Map<String,String> paramMap = new HashMap<>();
            String operationType = "alipayplus.mobilewallet.user.userRegistrationCheck";
            String envInfo = TestConfigManager.getTestConfig().getProperty("envInfo_native");
            String contentType = "application/x-www-form-urlencoded; charset-UTF-8";
            String phoneNumber = "";
            try{
                if(inputPhoneNumber.equals("")){
                    String phoneNumberTail1 = (System.currentTimeMillis()+"").substring(5);
                    Random rand1 = new Random();
                    int i = rand1.nextInt(9)+1; // 1-9
                    String phoneNumberTail = String.valueOf(i) + phoneNumberTail1; //非0开头9位数
                    Random rand = new Random();
                    int randNumber = rand.nextInt(2);
                    if (randNumber == 0){
                        phoneNumber = "27-" + "0" + phoneNumberTail;
                    }
                    if (randNumber == 1){
                        phoneNumber = "27-" + phoneNumberTail;
                    }
                }else {
                    phoneNumber = "27-" + inputPhoneNumber;
                }
                paramMap.put("phoneNumber",phoneNumber);
                OkHttpClient client = new OkHttpClient();
                String requestData = "[{\"envInfo\":"+envInfo+",\"phoneNumber\":\""+phoneNumber+"\"," +
                        "\"requestData\":\"{\\\"version\\\":\\\"wb\\\",\\\"data\\\":" +
                        "\\\"X4F\\\\/YV\\\\/CzSbqkDDcjudn4VLeTvpUXh2nibJMkT7Pv\\\\/3A6Mf7Bo9u3FY1PPcik90i0DuZM9ttc2DdEtTKIvCN2IOWy6GK0MCG1gw1XjEYm1oBTOSx59XgZJAdX4kiYfvzF6zWoP60b2lUPqUzXswAJTYHJbyjmG1rNDBUddCxMuedTzQxdR7YZ3KsuXmu3WHYbhmvwEUG5wMCyx88FSqs2PmmqZA7DqIxyWwl4Ae6DW4u5huoM\\\\/cqcsSbI86fah6kEOZbZ1weSTRN5XMisM607syV2LhVIiZzGuSG\\\\/Ilw2OfOHxNh1PHzRQV3ExVXIHaSCaPl6VO4+3JVZ5DsT7G7nE2DUPNCK0FRUCjvvEsuwodOCeXiJrtGzV3znbu0l8aU\\\\/Ks93ka+zUQ3f4gmAShBv4NWm5lLc6AEE1L6DZ9ZRDNBcAmkbKwoSYZxhACNM3BIPgrtbfizcPhZt0mAItmI+cmd\\\\/73cfriXwgdSHDZwGjB\\\\/FzgVDANZIah1Lm2BWq2Kkwhs9ErRsOEJu03IpCYxKhSYgJLbNdSyxt86b6zb+1rjcvCdDkRuuaqKeHS9t2QqaNvOwM6uKpSqOpShb9PtTL18B7XeqEN7shhjXD1\\\\/mR2Ouv73ntcXEWjdypVEuZMQV4tWC8n2hep+vgV+1EDjAMKK0a9TmT1g8sr5zTUKTguow9b1avK+0sWsRhLfyJLkrwxj2wQh2u5JzOe2JKXzvuNmAKue8RdHOXkmFzSBJtLdEuIyw\\\\/ScV+64K9o8qeoToJbTwg\\\\/oZHPkB6w7K6Lz5wJYs3vtztxrq3GqxCC7gTfO5FuS2urWTfq\\\\/6W\\\\/8BM88+3bQhKSavCZB53vV\\\\/6Vlie6eRUJM4LJC0wTqQWpNCAh4Fil9FWtsrS5BVZhuQDoXaj5\\\\/IfP0iRYHsJQO29bzKTmwfSZYc2ZuNyKCz7rbRbk+Ja3iFQ4t4U\\\\/Xdcell7S4tL\\\\/9gSMvhvpuuYAIAQFF+9g3BWM9tGe+mc3rXwIXuCp54vrE4kxUv4o4T3cd5NYFWkNEXrSN2GJDaFb5FP\\\\/vVZLlRf1xlYzBttVAIP7Q92Qv+i2wMkmOyBCnJRCQUEYn28ZiXH6qGQZW6sWIYTULeJifmYegBa06ZhoxfVhuiUZs9hp1dm64hZq6434eMqNoWF2vgaxIdclTYIERJH7iOXm5cnFkOYt+n\\\\/8fXnDmc3oEszOEgUcrbSserPahkE0NAnx6SUC4A0xkLhsnWlD72cqyx6SDOAb5cSyqHLYmRq9Jll3VUl00M\\\\/G19ED2zYxYDS\\\\/akUVZUWZaeOmu+RiwZnJsJDKXMWt7Uqaa9Hk19kvmz7ngSAsT0lwg58xYguLz4qUfztNjyzjdfWa0KfCmd\\\\/LyXaR\\\\/b7VvFwr+jo4Dv4+3qcqW3HwUVuw\\\\/Wkh4qiceB2kLK\\\\/CIyhJc8kssctOzYURGQZpHN7500RmK1G2QsmNir8kOnIMUM9eJ4MJ1KfCnheGNQ61eIDjlZCq8Qspdq0C7HZXteUObg4FSzVamsOyJEbxe2\\\\/Mb3wPORXPnV9zn7bbXuIW0FMTmC4dQcwT\\\\/Sg==\\\"}\"}]";

                Request request = RequestService.getRequest(paramMap,requestData,operationType,contentType);
                Response response = client.newCall(request).execute();

                String responseHeader = response.headers().toString();
                String responseBody = response.body().string();
                System.out.print("responseHeader is:"+responseHeader);
                System.out.print("responseBody is:"+responseBody);

                String Mgw_TraceId = PatternHelper.matchValue("Mgw-TraceId\\:([-A-Za-z0-9]+)",responseHeader);
                System.out.print("TraceId is:"+Mgw_TraceId);

            String string_CToken = PatternHelper.matchValue("ctoken=([-A-Za-z0-9]+)",responseHeader);
            Assert.assertTrue(StringUtils.isNoneEmpty(string_CToken),"string_CToken is empty, please check sofaId: "+Mgw_TraceId);
            paramMap.put("ctoken",string_CToken);
            String string_jsession = PatternHelper.matchValue("ctoken=([-A-Za-z0-9]+)",responseHeader);
            Assert.assertTrue(StringUtils.isNoneEmpty(string_jsession),"string_CToken is empty, please check sofaId: "+Mgw_TraceId);
            paramMap.put("jsession",string_jsession);

            //JSONObject jsonObject = JSON.
        }catch (Exception e){
            Assert.assertTrue(false, String.format("The api happen exception errorMessage is %s",e.getMessage()));
        }
        return paramMap;
    }
}
