package com.example.yeomanbg.config.datasource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@PropertySource(value = "classpath:jdbc.properties")
public class DruidConfiguration {



    @Bean("first")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource primary() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean("second")
    @ConfigurationProperties(prefix = "spring.datasource.second")
    public DataSource second() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean("dynamicDataSource")
    @Primary
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setDefaultTargetDataSource(primary());

        Map<Object,Object> dataSources = new HashMap<>(2);
        dataSources.put(DataSourceType.PRIMARY.getDbType(),primary());
        dataSources.put(DataSourceType.SECOND.getDbType(),second());
        dynamicDataSource.setTargetDataSources(dataSources);
        return dynamicDataSource;
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }


    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dynamicDataSource());
        return sessionFactory.getObject();
    }
}
