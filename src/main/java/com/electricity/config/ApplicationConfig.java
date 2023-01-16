package com.electricity.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import javax.swing.plaf.basic.BasicToolBarUI;

@Configuration
//@EnableSwagger2
public class ApplicationConfig {

//    @Bean
//    public Docket api(){
//        return new Docket(DocumentationType.Swagger_2)
//                .select()
//                .apis(RequestHandlerSelectrors.any())
//                .paths(PathSelectors.any())
//                .build();
//    }

    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("messages/messages");
        return messageSource;
    }
}
