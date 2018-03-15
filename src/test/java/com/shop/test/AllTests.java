package com.shop.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.shop.action.UserActionTest;
import com.ssh.test.SSHTest;

@RunWith(Suite.class)
@SuiteClasses({UserActionTest.class,SSHTest.class,SSHTest.class})
public class AllTests {

    //此类的作用是整合测试也称 打包测试;可以把之前所有的写好的test class类进行集成;  
    //如需测试多个类时，只需要把相关的测试类加入到"{}"即可;如果不是同一个包类的class记得加上package名称。  
    //@Suite.SuiteClasses({JunitTest.class,TestClassDemo.class})  
}
