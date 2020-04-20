package com.course.testng.paramter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DateProvider {
    @Test(dataProvider = "data")
    public void testDateProvider(String name, int age){
        System.out.println("name " + name + "; age" + age);
    }

    @DataProvider(name="data")
    public Object[][] providerData(){
        Object[][] o = new Object[][]{
                {"张珊", 11},
                {"李思", 12},
                {"王武", 13}
        };
        return o;
    }

    @Test(dataProvider = "method")
    public void test1(String name, int age){
        System.out.println("test1 name="+name+"; age="+age);
    }

    @Test(dataProvider = "method")
    public void test2(String name, int age){
        System.out.println("test2 name="+name+"; age="+age);
    }

    @DataProvider(name = "method")
    public Object[][] methodDataTest(Method method){
        Object[][] res = null;
        if(method.getName().equals("test1")){
            res = new Object[][]{
                    {"张珊", 13},
                    {"李思", 15}
            };
        }else if(method.getName().equals("test2")){
            res = new Object[][]{
                    {"王武", 22},
                    {"赵柳", 21}
            };
        }
        return res;
    }


}
