package br.com.lab0102.sistema_de_aluguel_de_veiculos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.*;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@EnableWebMvc
@Configuration
@Import(PersistenceConfig.class)
@ComponentScan("br.com.lab0102.*")
public class WebConfig implements WebMvcConfigurer {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Bean
	public SpringResourceTemplateResolver templateResolver() {
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setApplicationContext(applicationContext);
		templateResolver.setPrefix("/WEB-INF/views/");
		templateResolver.setSuffix(".html");
		templateResolver.setCacheable(false);
		return templateResolver;
	}
	
	@Bean
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver());
//		templateEngine.addDialect(new SpringSecurityDialect());
		templateEngine.setEnableSpringELCompiler(true);
		return templateEngine;
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		String[] excludedViews = new String[] { "/assets/**", "/plugins/**" };
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setTemplateEngine(templateEngine());
		resolver.setOrder(1);
		resolver.setExcludedViewNames(excludedViews);
		registry.viewResolver(resolver);
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/**", "/plugins/**").addResourceLocations("/WEB-INF/assets/", "/WEB-INF/plugins/");
	}
}
