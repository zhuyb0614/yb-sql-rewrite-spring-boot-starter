package com.github.zhuyb0614.sqlrewrite;

import javax.sql.DataSource;
import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

/**
 * @author yunbo.zhu
 * @version 1.0
 * @date 2022/7/15 10:19 上午
 */
public class DataSourceWrapper implements DataSource, Closeable {
    private DataSource dataSource;

    public DataSourceWrapper(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Connection getConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        return new ConnectionWrapper(connection);
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        Connection connection = dataSource.getConnection(username, password);
        return new ConnectionWrapper(connection);
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return dataSource.getLogWriter();
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {
        dataSource.setLogWriter(out);
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return dataSource.getLoginTimeout();
    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
        dataSource.setLoginTimeout(seconds);
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return dataSource.getParentLogger();
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return dataSource.unwrap(iface);
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return dataSource.isWrapperFor(iface);
    }

    @Override
    public void close() throws IOException {
        if (dataSource instanceof AutoCloseable) {
            try {
                ((AutoCloseable) dataSource).close();
            } catch (Exception e) {
                throw new IOException(e.getMessage());
            }
        }
    }
}
