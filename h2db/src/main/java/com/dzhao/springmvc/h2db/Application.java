package com.dzhao.springmvc.h2db;

import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * Created by dzhao on 9/05/2016.
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args){
        SpringApplication app = new SpringApplication(Application.class);
        app.run(Application.class, args);
    }

    /**
     * H2 web Connsole access configuration
     * @return
     */
    @Bean
    public ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
        registration.addUrlMappings("/console/*");
        return registration;
    }
}
