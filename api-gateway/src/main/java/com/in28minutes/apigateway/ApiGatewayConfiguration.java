package com.in28minutes.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
    @Bean
    public RouteLocator xyz(RouteLocatorBuilder builder){
        return builder.routes().
                route(p-> p.path("/get").uri("https://www.oneplus.in/communityideas#/")).
                route(p->p.path("/currency-exchange/**").filters(f->f.addRequestHeader("MyHeader","URI")).uri("lb://currency-exchange")).
                route(p->p.path("/currency-conversion/**").filters(f->f.addRequestHeader("MyHeader","URI")).uri("lb://currency-conversion")).
                route(p->p.path("/currency-conversion-feign/**").filters(f->f.addRequestHeader("MyHeader","URI")).uri("lb://currency-conversion")).
                route(p->p.path("/currency-conversion-new/**").filters(f->f.rewritePath("/currency-conversion-new/(?<segment>.*)","/currency-conversion-feign/${segment}")).uri("lb://currency-conversion")).

                build();
    }
}
