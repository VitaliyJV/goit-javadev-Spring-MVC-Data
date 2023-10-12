package goit.SpringData.Configuration;

import goit.SpringData.repository.NoteRepository;
import goit.SpringData.service.NoteService;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

    @Configuration
    @EnableJpaRepositories(
            entityManagerFactoryRef = "serversEntityManager",
            transactionManagerRef = "serversTransactionManager",
            basePackages = {"org.springdemo.multiple.datasources.repository.servers"}
    )
    public class AppConfig1 {

        @Autowired
        NoteRepository noteRepository;
        @Bean(name = "NoteService")
        public NoteService noteService()
        {
            NoteService noteService = new NoteService();
            noteService.setRepository(noteRepository);
        return new NoteService();
        }

        @Bean(name = "serversEntityManager")
        public LocalContainerEntityManagerFactoryBean getServersEntityManager(EntityManagerFactoryBuilder builder,
                                                                              @Qualifier("serversDataSource") DataSource serversDataSource){
            return builder
                    .dataSource(serversDataSource)
                    .packages("org.springdemo.multiple.datasources.domain.servers")
                    .persistenceUnit("servers")
                    .properties(additionalJpaProperties())
                    .build();

        }

        Map<String,?> additionalJpaProperties(){
            Map<String,String> map = new HashMap<>();

            map.put("hibernate.hbm2ddl.auto", "create");
            map.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
            map.put("hibernate.show_sql", "true");

            return map;
        }

        @Bean("serversDataSourceProperties")
        @Primary
        @ConfigurationProperties("spring")
        public DataSourceProperties serversDataSourceProperties(){
            return new DataSourceProperties();
        }

        @Bean("serversDataSource")
        @Primary
        @ConfigurationProperties("app.datasource.servers")
        public DataSource serversDataSource(@Qualifier("serversDataSourceProperties") DataSourceProperties serversDataSourceProperties) {
            return serversDataSourceProperties().initializeDataSourceBuilder().build();
        }

        @Bean(name = "serversTransactionManager")
        public JpaTransactionManager transactionManager(@Qualifier("serversEntityManager") EntityManagerFactory serversEntityManager){
            JpaTransactionManager transactionManager = new JpaTransactionManager();
            transactionManager.setEntityManagerFactory(serversEntityManager);

            return transactionManager;
        }





    }

