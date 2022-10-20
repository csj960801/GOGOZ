package com.myapp.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

// servlet-context.xml에 빈 설정
@Configuration
public class Jackson2JsonView {
	@Bean
	public BeanNameViewResolver viewResolver() {
		BeanNameViewResolver view = new BeanNameViewResolver();
		view.setOrder(0);
		return view;
	}

	@Bean
	public MappingJacksonJsonView jsonView() {
		MappingJacksonJsonView jsonview = new MappingJacksonJsonView();
		jsonview.setContentType("application/json;charset=UTF-8");
		return jsonview;
	}

}
