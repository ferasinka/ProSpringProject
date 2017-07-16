package com.ferasinka.prospringproject.ch13;

import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.util.fileloader.XlsDataFileLoader;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Profile("test")
@Configuration
@ImportResource("classpath:spring/datasource-tx-jpa-ch12.xml")
@ComponentScan(basePackages = {"com.ferasinka.prospringproject.ch12"})
public class ServiceTestConfig {
	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("classpath:db/ch12/schema.sql").build();
	}
	
	@Bean(name = "databaseTester")
	public DataSourceDatabaseTester dataSourceDatabaseTester() {
		return new DataSourceDatabaseTester(dataSource());
	}
	
	@Bean(name = "xlsDataFileLoader")
	public XlsDataFileLoader xlsDataFileLoader() {
		return new XlsDataFileLoader();
	}
}
