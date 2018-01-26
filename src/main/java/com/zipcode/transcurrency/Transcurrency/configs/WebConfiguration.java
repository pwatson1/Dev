package com.zipcode.transcurrency.Transcurrency.configs;

import org.h2.server.web.WebServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {
    private final Logger LOG = LoggerFactory.getLogger(WebConfiguration.class);

    @Bean
    ServletRegistrationBean h2servletRegistration(){
        LOG.info("Registering webServlet");
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }
}
