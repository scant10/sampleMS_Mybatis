package com.sk.sampleMS.application.sp.config;

import org.apache.ibatis.session.*;
import org.mybatis.spring.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.*;

@Configuration
@Import(MariaDBConnectionConfig.class)
@ComponentScan(basePackages = {"com.sk.sampleMS.domain.sample.repository"})
public class MyBatisConfig {
    @Autowired
    private MariaDBConnectionConfig mariaDBConfig;

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(mariaDBConfig.dataSource());
        sqlSessionFactoryBean.setConfigLocation((new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml")));
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:sample/mapper/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }
}
