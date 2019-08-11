package com.example.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = DataSourceConfig.PACKAGE, sqlSessionTemplateRef = "SqlSessionTemplate")
public class DataSourceConfig {
    static final String PACKAGE = "com.example.demo.dao.*";
    private static final String MAPPER = "classpath:mapper/*.xml";

    @Bean(name = "DataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource setDataSource() {
        return new DruidDataSource();
    }

    @Bean(name = "TransactionManager")
    public DataSourceTransactionManager setTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "SqlSessionFactory")
    public SqlSessionFactory setSqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(DataSourceConfig.MAPPER));
        return bean.getObject();
    }

    @Bean(name = "SqlSessionTemplate")
    public SqlSessionTemplate setSqlSessionTemplates(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
