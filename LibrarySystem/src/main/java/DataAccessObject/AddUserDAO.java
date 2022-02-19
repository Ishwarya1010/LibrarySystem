package DataAccessObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import Model.Users;

public class AddUserDAO {
    public int registerUser(Users user) throws ClassNotFoundException {
    	
    	 
 	       
 	       String INSERT_USERS_SQL = "insert into users(USERNAME,PASSWORD,USER_TYPE) values(?,?,?);";
 	        int result = 0;

 	        Class.forName("com.mysql.jdbc.Driver");


 	        try (Connection connection = DriverManager
 	            .getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "iVenkat@2014");

 	           
 	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
 	           preparedStatement.setString(1, user.getUsername());
 	            preparedStatement.setString(2, user.getPassword());
 	            preparedStatement.setInt(3, user.getUsertype());
 	           

 	            System.out.println(preparedStatement);
 	           
 	            result = preparedStatement.executeUpdate();

 	        } catch (SQLException e) {
 	            
 	            printSQLException(e);
 	        }
 	        return result;
 	    }
 	   

 	    private void printSQLException(SQLException ex) {
 	        for (Throwable e: ex) {
 	            if (e instanceof SQLException) {
 	                e.printStackTrace(System.err);
 	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
 	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
 	                System.err.println("Message: " + e.getMessage());
 	                Throwable t = ex.getCause();
 	                while (t != null) {
 	                    System.out.println("Cause: " + t);
 	                    t = t.getCause();
 	                }
 	            }
 	        }
 	    }
 	}



    	
    	
    	
    	
    	