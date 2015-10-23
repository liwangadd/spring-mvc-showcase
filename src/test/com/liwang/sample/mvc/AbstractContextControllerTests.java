package com.liwang.sample.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by Nikolas on 2015/10/23.
 */
@WebAppConfiguration
@ContextConfiguration("classpath:mvc-config.xml")
public class AbstractContextControllerTests {

    @Autowired
    protected WebApplicationContext wac;

}
