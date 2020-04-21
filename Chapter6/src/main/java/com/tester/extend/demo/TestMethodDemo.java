package com.tester.extend.demo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestMethodDemo {
    @Test
    public void test1(){
        Assert.assertEquals(1, 2);
    }

    @Test
    public void test2(){
        Assert.assertEquals(1, 1);
    }

    @Test
    public void logDemo(){
        Reporter.log("日志记录");
        throw new RuntimeException("运行异常");
    }

    @Test
    public void test3(){
        Assert.assertEquals("aaa", "aaa");
    }
}
