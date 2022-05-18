package com.test.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloController {
    private static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        logger.info("test");

        return "www.biancheng.net";
    }



}
