package co.jp.admission.config;

import co.jp.admission.model.enums.DatabaseType;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author p-tvo-khanhnv
 */
@Configuration
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
public class JdbcConfig {
    private static final String ORACLE_URL_FORMAT = "jdbc:oracle:thin:@{server}:{port}:earth";
    private static final String SQL_SERVER_URL_FORMAT = "jdbc:jtds:sqlserver://{server}:{port};"
            + "databaseName={schema};integratedSecurity=false;";

    private static final Logger LOG = LoggerFactory.getLogger(JdbcConfig.class);


    @Value("${spring.datasource.schema-name}")
    private String schemaName;
    @Value("${spring.datasource.server}")
    private String server;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.maximum-pool-size}")
    private String maxPoolSize;
    @Value("${spring.datasource.db-type}")
    private String dbType;
    @Value("${spring.datasource.port}")
    private String port;
    @Value("${spring.datasource.sid}")
    private String sid;

    public DataSource dataSource() {
        LOG.debug("Create new hikari data source");
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(DatabaseType.ORACLE.toString());
        config.setJdbcUrl(createDbUrl());
        config.setUsername(username);
        config.setPassword(password);

        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        config.addDataSourceProperty("useServerPrepStmts", "true");
        config.setMaximumPoolSize(Integer.parseInt(maxPoolSize));

        return new HikariDataSource(config);
    }

    @Bean
    public PlatformTransactionManager getPlatformTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    private String createDbUrl() {
        LOG.info("Create Database Url");
        String dbUrl = ORACLE_URL_FORMAT;
        dbUrl = dbUrl.replace("{sid}", sid)
                .replace("{server}", server)
                .replace("{port}", String.valueOf(port))
                .replace("{schema}", schemaName);
        LOG.info("dbUrl=" + dbUrl);

        return dbUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the schemaName
     */
    public String getSchemaName() {
        return schemaName;
    }

    /**
     * @param schemaName the schemaName to set
     */
    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    /**
     * @return the server
     */
    public String getServer() {
        return server;
    }

    /**
     * @param server the server to set
     */
    public void setServer(String server) {
        this.server = server;
    }

    /**
     * @return the maxPoolSize
     */
    public String getMaxPoolSize() {
        return maxPoolSize;
    }

    /**
     * @param maxPoolSize the maxPoolSize to set
     */
    public void setMaxPoolSize(String maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    /**
     * @return the dbType
     */
    public String getDbType() {
        return dbType;
    }

    /**
     * @param dbType the dbType to set
     */
    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

    /**
     * @return the port
     */
    public String getPort() {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(String port) {
        this.port = port;
    }


    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}
