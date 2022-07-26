package com.github.zhuyb0614.sqlrewrite;

import lombok.Data;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 配置信息
 *
 * @author zhuyunbo
 */
@ConfigurationProperties(prefix = "yb.sql-rewrite")
@Data
public class SqlRewriteProperties {
    /**
     * 是否开启
     */
    private String openSwitch = "on";
    /**
     * 数据源配置
     */
    private DataSourceProperties dataSource;
}
