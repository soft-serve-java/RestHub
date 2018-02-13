package com.kh013j.model.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.kh013j.model.repository")

public class JPAConfig {
//  @Autowired
//  private Environment env;
//
//  @Bean
//  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//    vendorAdapter.setDatabase(Database.POSTGRESQL);
//    vendorAdapter.setGenerateDdl(true);
//
//    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//    em.setDataSource(dataSource());
//    em.setPackagesToScan("com.kh013j.model.domain");
//    em.setJpaVendorAdapter(vendorAdapter);
//    return em;
//  }
//
//  @Bean
//  public DataSource dataSource(){
//    DriverManagerDataSource dataSource = new DriverManagerDataSource();
//    dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
//    dataSource.setUrl(env.getProperty("spring.datasource.url"));
//    dataSource.setUsername(env.getProperty("spring.datasource.username"));
//    dataSource.setPassword(env.getProperty("spring.datasource.password"));
//    return dataSource;
//  }
//
//  @Bean
//  public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
//    JpaTransactionManager transactionManager = new JpaTransactionManager();
//    transactionManager.setEntityManagerFactory(emf);
//    return transactionManager;
//  }
//
//  @Bean
//  public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
//    return new PersistenceExceptionTranslationPostProcessor();
//  }
//

}