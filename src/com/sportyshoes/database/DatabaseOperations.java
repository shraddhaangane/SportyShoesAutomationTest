package com.sportyshoes.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DatabaseOperations {
	 public void cleanUserDetails(String email) throws SQLException {
	        ConnectionUtil connectionUtil = new ConnectionUtil();
	        Connection connection = connectionUtil.jdbcConnectionUtil();

	        String selectQuery = "select * from users where emailid =?";
	        PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
	        preparedStatement.setString(1, email);
	        ResultSet resultset = preparedStatement.executeQuery();
	        String email_id = null;
	        while (resultset.next()) {
	        	email_id = resultset.getString("emailid");
	        }

	        if (null != email_id) {
	        String deleteOrderdetailQuery = "DELETE from users where emailid=?";
            preparedStatement = connection.prepareStatement(deleteOrderdetailQuery);
			preparedStatement.setString(1, email_id);
            preparedStatement.executeUpdate();
            System.out.println("Record deleted from user for email_id:" + email_id);
       }
	   connection.close();
	 }
     
}
