package com.comsysto.config;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseFactoryBean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author sekibomazic
 */
@Configuration
//@ImportResource(value = "classpath:META-INF/spring/applicationContext.xml")
@EnableJpaRepositories(basePackages = "com.comsysto.repositories")
@EnableTransactionManagement
public class JpaConfig {

    @Bean
    public EntityManagerFactory entityManagerFactory() {

        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(datasource());
        entityManagerFactory.setPackagesToScan(new String[]{"com.comsysto"});
        entityManagerFactory.setPersistenceProvider(new HibernatePersistence());

        //entityManagerFactory.setJpaProperties(getProperties());
        entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter());

        entityManagerFactory.afterPropertiesSet();
        return entityManagerFactory.getObject();
    }

    // use this together with setJpaProperties(...)
    private Properties getProperties() {
        Properties props = new Properties();
        props.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
        props.put("hibernate.hbm2ddl.auto", "create");

        return props;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setShowSql(true);
        jpaVendorAdapter.setDatabase(Database.H2);
        jpaVendorAdapter.setGenerateDdl(true);

        return jpaVendorAdapter;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager(entityManagerFactory());
        transactionManager.setDataSource(datasource());
        transactionManager.setJpaDialect(new HibernateJpaDialect());

        return transactionManager;
    }

    @Bean
    public DataSource datasource() {
        EmbeddedDatabaseFactoryBean bean = new EmbeddedDatabaseFactoryBean();
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
        databasePopulator.addScript(new ClassPathResource("com/comsysto/config/schema.sql"));
        bean.setDatabasePopulator(databasePopulator);
        bean.setDatabaseName("ComSystoTestDB");
        bean.setDatabaseType(EmbeddedDatabaseType.H2);

        // necessary because EmbeddedDatabaseFactoryBean is a FactoryBean
        bean.afterPropertiesSet();

        return bean.getObject();
    }

    @Bean
    public HibernateExceptionTranslator hibernateExceptionTranslator() {
        return new HibernateExceptionTranslator();
    }

}