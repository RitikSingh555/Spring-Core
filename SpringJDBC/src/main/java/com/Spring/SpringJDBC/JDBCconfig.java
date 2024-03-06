package com.Spring.SpringJDBC;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.Spring.SpringJDBC.dao.StudentDao;
import com.Spring.SpringJDBC.dao.StudentDaoImpl;

@Configuration
@ComponentScan(basePackages = {"com.Spring.SpringJDBC"})
public class JDBCconfig {
	
	@Bean("ds")
	public DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("Ritik#123");
		
		return ds;
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate gettemplate()
	{
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
	
	/*
	 * @Bean("studentDao") public StudentDao getStudentDao() { StudentDaoImpl
	 * studentDao=new StudentDaoImpl(); studentDao.setJdbcTemplate(gettemplate());
	 * return studentDao; }
	 */
	
	

}
