package com.stackroute.config;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.stackroute.domain.Track;
import com.stackroute.exception.TrackAlreadyExistsException;
import com.stackroute.repository.TrackRepository;
import com.stackroute.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class WebConfiguration {

    private final
    TrackService trackService;

    @Autowired
    public WebConfiguration(TrackService trackService) {
        this.trackService = trackService;
    }

    @EventListener
    public void handleContextRefreshEvent(ContextRefreshedEvent cfr) {
        try {
            trackService.saveTrack(new Track(1,"Happy","Tim"));
            trackService.saveTrack(new Track(2,"Love me like u do","Christina"));
            System.out.println("Context Refreshed");
        } catch (TrackAlreadyExistsException e) {
            e.printStackTrace();
        }
    }



    @Bean
    ServletRegistrationBean h2servletRegistration(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new WebServlet());
        servletRegistrationBean.addUrlMappings("/console/*");
        return servletRegistrationBean;

    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.stackroute.muzix.controllers"))
                .paths(PathSelectors.regex("/.*"))
                .build();
    }



}