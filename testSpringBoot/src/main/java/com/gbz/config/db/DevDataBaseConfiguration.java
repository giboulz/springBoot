package com.gbz.config.db;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;






//@EntityScan(basePackages = { "com.gbz.entity" })
//@EnableTransactionManagement
//@EnableAutoConfiguration
@Profile("Dev")
@Configuration
public class DevDataBaseConfiguration {

	private static final Logger LOGGER = Logger.getLogger(DevDataBaseConfiguration.class);

	
	private static final String driver = "com.sybase.jdbc4.jdbc.SybDriver";
	private static final String url = "jdbc:sybase:Tds:s00va9926963.fr.net.intra:5500/info_ace?HOSTNAME=DataSquare&DB_CLOSE_ON_EXIT=FALSE";
	private static final String user = "SICPADM";
	private static final String password = "france";

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(password);
		return dataSource;
	}

	// le provider JPA
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setShowSql(true);
		hibernateJpaVendorAdapter.setGenerateDdl(false);
		hibernateJpaVendorAdapter.setDatabase(Database.SYBASE);
		return hibernateJpaVendorAdapter;
	}
	
	@PostConstruct
	public void printInfosConfig() {
		LOGGER.info("Driver is : " + driver);
		LOGGER.info("url is : " + url);
		LOGGER.info("user is : " + user);

	}
	
	
}
