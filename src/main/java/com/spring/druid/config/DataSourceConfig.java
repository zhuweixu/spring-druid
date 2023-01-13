package com.spring.druid.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.spring.druid.Enum.DataSourceTypeEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {


    @Value("${spring.datasource.mysql.finedb.url}")
    private String mysqlUrl;

    @Value("${spring.datasource.mysql.username}")
    private String mysqlUsername;

    @Value("${spring.datasource.mysql.password}")
    private String mysqlPassword;

    @Value("${spring.datasource.mysql.driverClassName}")
    private String mysqlDriverClassName;

    @Value("${spring.datasource.mysql.finedb.url}")
    private String oracleUrl;

    @Value("${spring.datasource.mysql.username}")
    private String oracleUsername;

    @Value("${spring.datasource.mysql.password}")
    private String oraclePassword;

    @Value("${spring.datasource.mysql.driverClassName}")
    private String oracleDriverClassName;

    @Bean(name="dataSourceMysql")
    public DataSource dataSourceMysql(){
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(mysqlUrl);
        datasource.setDriverClassName(mysqlDriverClassName);
        datasource.setUsername(mysqlUsername);
        datasource.setPassword(mysqlPassword);
        // setDruidOptions(datasource); // 设置druid数据源的属性
        return datasource;
    }

    @Bean(name="dataSourceOracle")
    public DataSource dataSourceOracle(){
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(oracleUrl);
        datasource.setDriverClassName(oracleDriverClassName);
        datasource.setUsername(oracleUsername);
        datasource.setPassword(oraclePassword);
        // setDruidOptions(datasource); // 设置druid数据源的属性
        return datasource;
    }

    /*private void setDruidOptions(DruidDataSource datasource){

        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setPoolPreparedStatements(poolPreparedStatements);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        datasource.setKeepAlive(true);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        datasource.setPoolPreparedStatements(poolPreparedStatements);

        try {
            datasource.setFilters(filters);
        } catch (SQLException e) {
            log.error("druid configuration initialization filter Exception", e);
        }
    }*/

}
