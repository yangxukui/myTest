package com.yoopay.testng;

import com.yoopay.testng.base.TestBase;
import com.yoopay.testng.testCase.checkNumberRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class testLoadBankInfo extends TestBase {
    @Autowired
    checkNumberRegisterService  checkRegister;

    @Test(description = "loadBankInfo")
    public  void testLoadBank (){
       // LogUtils.info("123456666");
        Map<String,String> paramMap = new HashMap<>();
        checkRegister.checkNumberRegister("321333007");
    }

}
