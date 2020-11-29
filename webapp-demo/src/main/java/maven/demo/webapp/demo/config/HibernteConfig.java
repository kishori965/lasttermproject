package maven.demo.webapp.demo.config;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import com.mysql.cj.jdbc.Driver;


@Configuration
@ComponentScan(basePackages = "maven.demo.webapp.demo")
@EnableTransactionManagement
public class HibernteConfig {
	@Bean
	public DataSource getDataSource() throws SQLException {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriver(new Driver());
		dataSource.setUrl("jdbc:mysql://localhost:3306/spring_webapp_article");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		dataSource.setInitialSize(20);
		dataSource.setMaxTotal(100);

		return dataSource;

	}

	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getProperties());
	builder.scanPackages("maven.demo.webapp.demo.dto");
		return builder.buildSessionFactory();
	}

	public Properties getProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57InnoDBDialect");
	
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.show_sql", "true");
		return properties;
	}

	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}

}

