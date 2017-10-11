package com.ssh.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;
import org.junit.Test;
import java.util.Date;


@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations="classpath:beans.xml")  
public class SSHTest {  
      
    @Resource  
    private Date date;  
    
    
    @Test //测试Spring IOC的开发环境  
    public void springIoc() {  
        System.out.println(date);  
        System.out.println(date);  
    } 
}  