package com.spring.druid.config;

import com.spring.druid.Enum.DataSourceTypeEnum;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Component
@Primary
public class DynamicDataSource extends AbstractRoutingDataSource implements InitializingBean {

    public static ThreadLocal<String> dataSourceType = new ThreadLocal();

    @Autowired
    private DataSource dataSourceMysql;

    @Autowired
    private DataSource dataSourceOracle;

    @Override
    public void afterPropertiesSet() {
        Map<Object,Object> map = new HashMap<>();
        map.put(DataSourceTypeEnum.Mysql.getName(), dataSourceMysql);
        map.put(DataSourceTypeEnum.Oracle.getName(), dataSourceOracle);
        super.setTargetDataSources(map);
        super.setDefaultTargetDataSource(dataSourceOracle);
        super.afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return dataSourceType.get();
    }

}
