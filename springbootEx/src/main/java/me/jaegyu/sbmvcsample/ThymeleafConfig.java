package me.jaegyu.sbmvcsample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring4.SpringTemplateEngine;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
public class ThymeleafConfig {

	@Bean
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		
		/*
		 * 아래와 같이 Layout Dialet를 SpringTemplateEngine에 등록 할 경우에는
		 * 반드시 addDialect메서드를 이용해야 함
		 * */
		templateEngine.addDialect(new LayoutDialect());
		return templateEngine;
	}

}
