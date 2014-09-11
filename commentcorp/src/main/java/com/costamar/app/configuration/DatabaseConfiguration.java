package com.costamar.app.configuration;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatabaseConfiguration {
	
	
	
	@Bean
	public DriverManagerDataSource poolDataSource(){
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/commentcorp");
		ds.setUsername("root");
		ds.setPassword("mysql");
		return ds;
	}
	
	
	@Bean
	public DriverManagerDataSource poolDataSourceSQL(){
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		ds.setUrl("jdbc:sqlserver://10.34.3.46:1433;databaseName=CostamarCorporate; catalogName=CostamarCorporate");
		ds.setUsername("costa");
		ds.setPassword("@c0$t@_?_j@v@");
		return ds;
	}
	
	
	
	
	
	
//	 ----------------------
	 
	 
	@Bean(name = "transactionManager")
	public DataSourceTransactionManager transactionManagerMyBatis(){
		DataSourceTransactionManager tm = new DataSourceTransactionManager();
			tm.setDataSource(poolDataSource());			
		return tm;
	}
	
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory(){
		SqlSessionFactoryBean sf = new SqlSessionFactoryBean();
			sf.setDataSource(poolDataSource());
		return sf;
	}
	
	@Bean
	public MapperScannerConfigurer mapperConfigurer() {
		MapperScannerConfigurer ms = new MapperScannerConfigurer();
		ms.setBasePackage("com.costamar.app");
		return ms;
	}
	
}
