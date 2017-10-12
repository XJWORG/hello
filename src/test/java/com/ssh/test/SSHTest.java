package com.ssh.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shop.model.Category;
import com.shop.service.CategoryService;
import com.shop.service.impl.CategoryServiceImpl;

import javax.annotation.Resource;
import org.junit.Test;
import java.util.Date;


@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations="classpath:beans.xml")  
public class SSHTest {  
      
    @Resource  
    private Date date;  

    @Resource
    private CategoryService categoryService;
    
    @Test //测试Spring IOC的开发环境  
    public void springIoc() {  
        System.out.println(date);  
    } 
    
    @Test
    public void hibernate(){
    	CategoryService categoryService = new CategoryServiceImpl();
    	Category category = new Category("男士fasion",true);
    	categoryService.save(category);
    }

    @Test //测试Hibernate和Spring整合后
    public void hibernateAndSpring() {
        categoryService.update(new Category(1, "休闲女式", true));
    }
    
}  