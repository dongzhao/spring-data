package com.dzhao.springmvc.h2db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by dzhao on 9/05/2016.
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args){
        SpringApplication app = new SpringApplication(Application.class);
        app.run(Application.class, args);
    }
}
