package com.zking.gofcrm;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 说明：略
 *
 * @author Jzw
 * @date 2018/1/30 18:05
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringJUnitConfig(locations = {"classpath:springs/spring.xml"})
public class BaseCodeTest {

    @After
    public void after(){

    }

    @Before
    public void before(){

    }

}
