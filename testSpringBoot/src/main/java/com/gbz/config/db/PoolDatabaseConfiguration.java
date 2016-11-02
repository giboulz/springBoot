package com.gbz.config.db;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jndi.JndiTemplate;

@Profile("Pool")
@Configuration
public class PoolDatabaseConfiguration {

	private static final Logger LOGGER = Logger.getLogger(PoolDatabaseConfiguration.class);
	
	
	@Bean
    DataSource dataSource() {
        DataSource dataSource = null;
        JndiTemplate jndi = new JndiTemplate();
        try {
            dataSource = (DataSource) jndi.lookup("java:comp/env/jdbc/infoAceDB");
        } catch (NamingException e) {
        	LOGGER.error("NamingException for java:comp/env/jdbc/infoAceDB", e);
        }
        return dataSource;
    }
	
}
