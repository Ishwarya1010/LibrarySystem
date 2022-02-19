package DataAccessObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import Model.Books;
import Model.Users;

public class LoginDAO

{
	
	
	 public int loginTry (Users user) throws ClassNotFoundException {
	
		
		 
		 String SELECT_USERS_SQL="select UID,USERNAME,PASSWORD from users where USERNAME=? AND PASSWORD=?;";
		          Class.forName("com.mysql.jdbc.Driver");
		          try (Connection connection = DriverManager
				            .getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "iVenkat@2014");
		        		  PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERS_SQL)){
		          preparedStatement.setString(1, user.getUsername());
		            preparedStatement.setString(2, user.getPassword());
		          ResultSet resultSet=preparedStatement.executeQuery();
		          while(resultSet.next()){
		        	  user.setUid(resultSet.getInt("UID"));
		        	String username= resultSet.getString("USERNAME");
		        	String password=resultSet.getString("PASSWORD");
		        	
		        	if(username.equals("admin")&&password.equals("admin"))
		        		return 1;
		        	else if(!username.isEmpty()&&!password.isEmpty())
		        		return 2;
		        	else
		        		return 0;
		          }
	 }
		   catch (SQLException e) {
		  System.out.println("Error while connecting to the database");
		  }
		 return 0;
		
}
	
}

