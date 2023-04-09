package org.example.mvcconfigs;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    private static final String ENV_JDBC_PASSWORD = "jdbc.password";
    private static final String ENV_JDBC_USERNAME = "jdbc.username";
    private static final String ENV_JDBC_URL = "jdbc.url";
    private static final String ENV_DRIVER_CLASS_NAME = "jdbc.driver-class-name";
    private Environment env;

    @Bean
    @Profile("dev")
    public DataSource dataSource() {
        //using an inmemory db for testing purposes
//        return new EmbeddedDatabaseBuilder()
//                .setType(EmbeddedDatabaseType.H2)
//                .build();
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty(ENV_DRIVER_CLASS_NAME));
        dataSource.setUsername(env.getProperty(ENV_JDBC_USERNAME));
        dataSource.setPassword(env.getProperty(ENV_JDBC_PASSWORD));
        dataSource.setUrl(env.getProperty(ENV_JDBC_PASSWORD));
        return dataSource;
    }

    @Bean
    @Profile("staging")
    public DataSource testDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
//        Apache Commons DBCP (Database Connection Pool)

        dataSource.setInitialSize(5); // Set the initial pool size
        dataSource.setMaxTotal(10); // Set the maximum number of connections in the pool
        dataSource.setMaxIdle(5); // Set the maximum number of idle connections in the pool
        dataSource.setMinIdle(2); // Set the minimum number of idle connections in the pool
        dataSource.setMaxWaitMillis(5000); // Set the maximum time in milliseconds that the pool will wait for a connection to be returned before throwing an exception
        dataSource.setValidationQuery("SELECT 1"); // Set the validation query that will be used to test connections before they are returned from the pool
        dataSource.setTestOnBorrow(true); // Set whether connections should be tested when borrowed from the pool
        dataSource.setTestOnReturn(false); // Set whether connections should be tested when returned to the pool
        dataSource.setTestWhileIdle(false); // Set whether connections should be tested while idle in the pool
        dataSource.setTimeBetweenEvictionRunsMillis(1800000); // Set the time in milliseconds between runs of the idle connection validation thread
        dataSource.setMinEvictableIdleTimeMillis(3600000); // Set the minimum time in milliseconds that an idle connection can remain in the pool before being evicted
        dataSource.setRemoveAbandonedOnBorrow(true); // Set whether to remove abandoned connections when they are borrowed from the pool
        dataSource.setRemoveAbandonedTimeout(300); // Set the timeout in seconds for removing abandoned connections
        dataSource.setLogAbandoned(true); // Set whether to log abandoned connections

        dataSource.setDriverClassName(env.getProperty(ENV_DRIVER_CLASS_NAME));
        dataSource.setUrl(env.getProperty(ENV_JDBC_URL));
        dataSource.setUsername(env.getProperty(ENV_JDBC_USERNAME));
        dataSource.setPassword(env.getProperty(ENV_JDBC_PASSWORD));
        return dataSource;
    }
    @Bean
    @Profile("prod")
    public DataSource prodDataSource() {
//        for prod purposes: using tomcat pool: configs are in the resources doc in tomcat conf
        JndiObjectFactoryBean ds = new JndiObjectFactoryBean();
        ds.setLookupOnStartup(true);
        ds.setJndiName(env.getProperty("jdbc/jwtDB"));
        ds.setCache(true);

        return (DataSource) ds.getObject();
    }
    @Autowired
    public void setEnv(Environment env) {
        this.env = env;
    }
}
