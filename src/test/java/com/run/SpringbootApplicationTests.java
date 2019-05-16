package com.run;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

    @Test
    public void contextLoads() {
    }
    @Test
    public void testOne(){
        System.out.println("测试");
        TestCase.assertEquals(1,1);
    }
    @Before
    public void testBefore(){
        System.out.println("用于资源的启动开启连接");
    }
    @After
    public void testAfter(){
        System.out.println("用于资源的回收应用");
    }

}
