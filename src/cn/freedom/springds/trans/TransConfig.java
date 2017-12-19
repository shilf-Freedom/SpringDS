package cn.freedom.springds.trans;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@Configuration
@ComponentScan
@EnableTransactionManagement
public class TransConfig implements TransactionManagementConfigurer {
	// 数据源
	private DataSource dataSource = null;
	
	/*
	 * 配置数据源
	 * @return 数据源
	 */
	@Bean(name="dataSource")
	public DataSource initDataSource() {
		if(dataSource != null) {
			return dataSource;
		}
		
		Properties properties = new Properties();
		properties.setProperty("driverClassName", "com.mysql.jdbc.Driver");
		properties.setProperty("url", "jdbc:mysql://localhost:3306/ssm");
		properties.setProperty("username", "root");
		properties.setProperty("password", "shilongfei");
		properties.setProperty("maxActive", "200");
		properties.setProperty("maxIdle", "20");
		properties.setProperty("maxWait", "30000");
		
		try {
			dataSource = BasicDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dataSource; 
	}
	
	/*
	 * 配置JdbcTemplate
	 * @return 返回jdbcTemplate
	 */
	@Bean(name="jdbcTemplate")
	public JdbcTemplate initJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(initDataSource());
		return jdbcTemplate;
	}

	@Override
	@Bean(name="transactionManager")
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		DataSourceTransactionManager manager = new DataSourceTransactionManager();
		manager.setDataSource(initDataSource());
		return manager;
	}
	
}
