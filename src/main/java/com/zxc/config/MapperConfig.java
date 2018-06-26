package com.zxc.config;

import com.zxc.mapper.CfFansMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * Description:
 * User: blkfhusky
 * Date: 2018-06-22
 * Time: 下午4:49
 */
@Configuration
//@MapperScan("com.zxc.mapper")
public class MapperConfig {

    @Value("classpath:config/mapperConfig.xml")
    Resource mybatisMapperConfig;

    @Autowired
    DataSource dataSource;

    <T> MapperFactoryBean<T> newMapperFactoryBean(Class<T> clazz) throws Exception {
        final MapperFactoryBean<T> b = new MapperFactoryBean<T>();
        b.setMapperInterface(clazz);
        b.setSqlSessionFactory(sqlSessionFactory());
        return b;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        final SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setConfigLocation(mybatisMapperConfig);
        fb.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath:mybatis/*Mapper.xml");
        fb.setMapperLocations(resources);
        return fb.getObject();
    }

    @Bean
    public CfFansMapper cfFansAddMapper() throws Exception {
//        org.apache.zookeeper.server.quorum.flexible.QuorumMaj
//        com.alibaba.dubbo.remoting.zookeeper.curator.CuratorZookeeperTransporter
//        org.apache.curator.RetryPolicy
        return newMapperFactoryBean(CfFansMapper.class).getObject();
    }
}
