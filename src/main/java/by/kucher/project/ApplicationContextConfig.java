package by.kucher.project;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("by.kucher.project")
@PropertySource("classpath:application.properties")
@EnableWebMvc
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "by.kucher.project.repositories")
public class ApplicationContextConfig {

	@Autowired
	private Environment enviroment;

	private static final String PROPERTY_NAME_DATABASE_DRIVER = "jdbc.driverClassName";
	private static final String PROPERTY_NAME_DATABASE_URL = "jdbc.url";
	private static final String PROPERTY_NAME_DATABASE_USERNAME = "jdbc.username";
	private static final String PROPERTY_NAME_DATABASE_PASSWORD = "jdbc.password";

	private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
	private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	private static final String PROPERTY_NAME_HIBERNATE_HBM2DDL = "hibernate.hbm2ddl.auto";
	private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";

	@Bean
	public PlatformTransactionManager transactionManager() {
		System.out.println("##1 - transactionManager");
		EntityManagerFactory entityManagerFactory = entityManagerFactory().getObject();
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(entityManagerFactory);
		return jpaTransactionManager;

	}

	@Bean
	public DataSource dataSource() {
		System.out.println("##2 - dataSource");
		// use org.apache.tomcat.jdbc.pool.DataSource
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(enviroment.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
		dataSource.setUrl(enviroment.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
		dataSource.setUsername(enviroment.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
		dataSource.setPassword(enviroment.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));
		return dataSource;

	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		System.out.println("##3 - entityManagerFactory");
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setGenerateDdl(Boolean.TRUE);
		hibernateJpaVendorAdapter.setShowSql(Boolean.TRUE);

		factoryBean.setDataSource(dataSource());
		factoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter);
		factoryBean.setJpaProperties(hibProperties());
		factoryBean.setPackagesToScan(enviroment
				.getRequiredProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));
		factoryBean.afterPropertiesSet();
		factoryBean.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
		return factoryBean;

	}

	private Properties hibProperties() {
		System.out.println("##4 - hibProperties");
		Properties properties = new Properties();
		properties.put(PROPERTY_NAME_HIBERNATE_DIALECT,
				enviroment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
		properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL,
				enviroment.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
		return properties;
	}

	@Bean
	public HibernateExceptionTranslator hibernateExceptionTranslator() {
		System.out.println("##5 - hibernateExceptionTranslator");
		return new HibernateExceptionTranslator();
	}

}
