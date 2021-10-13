package com.enlacetpe.ticketapi.configuration;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.enlacetpe.ticketapi.util.AES128;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.enlacetpe.ticketapi.repositoryMDB")
@PropertySource({ "classpath:dataBaseConection.properties" })
public class JDBCConfiguration {

	@Autowired
    private Environment env;
	
	@Bean
	@Primary
	public DataSource dataSource() {
		AES128 aes = new AES128();
		DriverManagerDataSource manager = new DriverManagerDataSource();
		manager.setDriverClassName(env.getProperty("jdbc.driver"));
		manager.setUrl(env.getProperty("jdbc.url"));
		manager.setUsername(aes.decrypt(env.getProperty("jdbc.user")));
		manager.setPassword(aes.decrypt(env.getProperty("jdbc.pass")));
		manager.setSchema("datahub");
		manager.setConnectionProperties(jpaProperties()); 	
		return manager;
	}
	
	 @Bean
	 @Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		 LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
	     em.setDataSource(dataSource());
	     em.setPackagesToScan(new String[] { "com.enlacetpe.ticketapi.modelMDB" });
	 
	     JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	     em.setJpaVendorAdapter(vendorAdapter);
	     em.setJpaProperties(jpaProperties());
	     
	     return em;
	}
	 
	@Bean
	@Primary
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
		JpaTransactionManager transactionManager = new JpaTransactionManager();
	    transactionManager.setEntityManagerFactory(emf);
	 
	    return transactionManager;
	}
	 
	@Bean
	@Primary
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
		return new PersistenceExceptionTranslationPostProcessor();
	}
	   
	@Bean
	@Primary
	public Properties jpaProperties() { 
		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		jpaProperties.put("hibernate.hbm2ddl.auto", "validate");
		jpaProperties.put("hibernate.show_sql", "false");
		jpaProperties.put("hibernate.format_sql", "true");
		return jpaProperties;
	}
}
