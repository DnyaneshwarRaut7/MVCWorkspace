package com.example.config;

import java.util.Properties;

import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.example.model.Employee;

@Configuration
@ComponentScan(basePackages = "com.example")
@EnableWebMvc
public class ApplicationConfig {
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver ivr = new InternalResourceViewResolver();
		ivr.setSuffix(".jsp");
		return ivr;
	}

	@Bean
	public DriverManagerDataSource driverManagerDataSource() {
		DriverManagerDataSource ds =  new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springbatch22javabase");
		ds.setUsername("root");
		ds.setPassword("root");
		
		return ds;
	}
	
//	@Bean
//	public MultipartFile multipartResolver() {
//		CommonsMultipartFile comFile = new CommonsMultipartFile(new F);
//		return comFile;
//	}
	
	  @Bean
	    public MultipartResolver multipartResolver() {
	        return new CommonsMultipartResolver();
	    }
	  
	@Bean
	public LocalSessionFactoryBean getSessionFactoryBean() {
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		sf.setDataSource(driverManagerDataSource());
		
		Properties properties = new Properties();
		properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
		properties.put(Environment.HBM2DDL_AUTO, "update");
		properties.put(Environment.SHOW_SQL, true);
		
		sf.setHibernateProperties(properties);
		
		sf.setAnnotatedClasses(Employee.class);
		
		return sf;
	}
}
