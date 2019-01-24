package com.springappcon.test.aop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.springappcon.test.aop.service.model.Circle;
@Component
public class JdbcDAOImpl 
{
	Connection conn=null;
	public Circle getCircle() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		return null;
		/*String connectionString = "jdbc:oracle:thin:@ofss222745.in.oracle.com:1521/ODT12CDB";
		String driver="oracle.jdbc.driver.OracleDriver";
		Class.forName(driver).newInstance();
		conn=DriverManager.getConnection(connectionString);
		String query = "SELECT * FROM CSTB_CALL_FORM_NODES";
		PreparedStatement ps= conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next())
		{
			System.out.println(rs.getString(1));
		}
		return null;*/
		/*ApplicationContext context = 
	    		new ClassPathXmlApplicationContext("Spring-Module.xml");
	    	 
			JdbcDAOImpl jdbcDAOImpl = (CustomerDAO) context.getBean("dataSource");
	        Customer customer = new Customer(1, "mkyong",28);
	        customerDAO.insert(customer);
	    	
	        Customer customer1 = customerDAO.findByCustomerId(1);
	        System.out.println(customer1);*/
	}
}
