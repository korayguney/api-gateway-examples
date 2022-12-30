package com.apigateway.springbootzuulgatewayproxy;

import com.apigateway.springbootzuulgatewayproxy.Filters.ErrorFilter;
import com.apigateway.springbootzuulgatewayproxy.Filters.PostFilter;
import com.apigateway.springbootzuulgatewayproxy.Filters.PreFilter;
import com.apigateway.springbootzuulgatewayproxy.Filters.RouteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class SpringBootZuulgatewayproxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootZuulgatewayproxyApplication.class, args);
	}

	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}
	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}
	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}
	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}
}
