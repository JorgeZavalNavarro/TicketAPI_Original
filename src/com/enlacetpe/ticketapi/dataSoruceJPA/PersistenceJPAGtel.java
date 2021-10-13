package com.enlacetpe.ticketapi.dataSoruceJPA;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.enlacetpe.ticketapi.util.AES128;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		basePackages = "com.enlacetpe.ticketapi.repositoryGetl", 
	    entityManagerFactoryRef = "entityManagerFactoryGetl", 
	    transactionManagerRef = "transactionManagerGetl")
@PropertySource({ "classpath:dataBasesJPA.properties" })
public class PersistenceJPAGtel {
	
	@Autowired
    private Environment env;
	
	@Bean 
	 public LocalContainerEntityManagerFactoryBean entityManagerFactoryGetl() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSourceGetl());
		em.setPackagesToScan(new String[]{"com.enlacetpe.ticketapi.modelGetl"});
		em.setJpaVendorAdapter(jpaVendorAdapter());
		em.setJpaProperties(jpaProperties());
		return em;
	}
	
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		 JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		 return vendorAdapter;
	}
	
	
	@Bean
	public DataSource dataSourceGetl() {
		AES128 aes = new AES128();
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setDriverClassName(env.getProperty("driverJPA"));
		dataSource.setJdbcUrl(env.getProperty("urlJPAGetl")); 
		dataSource.setUsername(aes.decrypt(env.getProperty("userJPAGetl")));
		dataSource.setPassword(aes.decrypt(env.getProperty("passJPAGetl")));
		dataSource.setMaximumPoolSize(1);
		return dataSource;
	}
	
	
	@Bean
	public PlatformTransactionManager transactionManagerGetl() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(this.entityManagerFactoryGetl().getObject());
		return transactionManager;
	}
	

	private Properties jpaProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.hbm2ddl.auto","validate");
        properties.put("hibernate.show_sql","false");
        properties.put("hibernate.format_sql","true");
        properties.put("hibernate.connection.release_mode", "ON_CLOSE");
        return properties;
    }

}
