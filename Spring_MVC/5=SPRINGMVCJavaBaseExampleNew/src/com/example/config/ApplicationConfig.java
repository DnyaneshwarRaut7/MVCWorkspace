package com.example.config;

import java.util.Properties;

import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.example.model.Employee;
import com.example.model.FileData;

@Configuration
@ComponentScan(basePackages ="com.example")
@EnableWebMvc
public class ApplicationConfig {
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver ivr = new InternalResourceViewResolver();
		ivr.setSuffix(".jsp");
		return ivr;
		
	}
	// Database Connection
	
	@Bean
	public DriverManagerDataSource driverManagerDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/SpringMVCJavaBase1");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
		
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
		sf.setAnnotatedClasses(FileData.class);
		sf.setAnnotatedClasses(Employee.class);
		 return sf;
		 
	 }
	// file handling 
	@Bean
   public MultipartResolver multipartResolver() {
		
		return new CommonsMultipartResolver();
		
	}
	
	

}
