package com.liuwei.testng;

import com.liuwei.testng.base.LogUtils;
import com.liuwei.testng.base.TestBase;
import com.liuwei.testng.testCase.checkNumberRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
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
