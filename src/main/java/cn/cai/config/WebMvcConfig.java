package cn.cai.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer
{
	@Override
	public void addViewControllers(ViewControllerRegistry registry)
	{
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/index.html").setViewName("index");
		registry.addViewController("/main.html").setViewName("main");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry)
	{
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns(
				"/", "/index", "/index.html", "/user/login", "/js/*", "/css/*", "/img/*");
	}

}
