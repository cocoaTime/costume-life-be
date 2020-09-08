package costume.life.be.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource({"classpath:application.properties"})
@EnableJpaRepositories(
        basePackages = "costume.life.be.repository.costume.life",
        entityManagerFactoryRef = "costumeLifeEntityManager",
        transactionManagerRef = "costumeLifeTransactionManager")
public class PersistenceCostumeLifeAutoConfig {
    @Autowired
    private Environment env;
    public static final String COSTUME_LIFE_BE_MODEL_PACKAGE = "costume.life.be.model.costume.life";

    @Bean
    public LocalContainerEntityManagerFactoryBean costumeLifeEntityManager(){
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(costumeLifeDataSource());
        em.setPackagesToScan(new String[]{COSTUME_LIFE_BE_MODEL_PACKAGE});

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        em.setJpaPropertyMap(properties);
        return em;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.second-datasource")
    public DataSource costumeLifeDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public PlatformTransactionManager costumeLifeTransactionManager() {

        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(costumeLifeEntityManager().getObject());
        return transactionManager;
    }
}
