package com.github.zhuyb0614.sqlrewrite;


import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;

/**
 * @author zhuyunbo
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnProperty(value = "yb.sql-rewrite.open-switch", havingValue = "on", matchIfMissing = true)
@Slf4j
@EnableConfigurationProperties(SqlRewriteProperties.class)
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
public class SqlRewriteAutoConfiguration {

    @Bean
    public DataSource dataSource(SqlRewriteProperties sqlRewriteProperties) {
        DataSourceProperties properties = sqlRewriteProperties.getDataSource();
        HikariDataSource dataSource = (HikariDataSource) properties.initializeDataSourceBuilder().type((Class<? extends DataSource>) HikariDataSource.class).build();
        if (StringUtils.hasText(properties.getName())) {
            dataSource.setPoolName(properties.getName());
        }
        return new DataSourceWrapper(dataSource);
    }
}
