package DataAccessObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Books;
import Model.IssuedBooks;
import Model.ReturnedBooks;
import Model.Users;

public class ReturnedBooksDAO {

	public void returnBook(IssuedBooks ibooks, ReturnedBooks rbooks) throws ClassNotFoundException {
		Books book=new Books();
		Users user=new Users();
		 int uid=0;
		 int bookid=0;
		 String ISSUED_BOOKS_SQL = "select *from issued_books where IID=?;";
		 String ADD_RETURNED_BOOKS_SQL = "insert into returned_books(uid,bid,return_date) values(?,?,?);";
		 String DELETE_ISSUED_BOOKS_SQL="delete from issued_books where UID=? AND BID=?;";

	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "iVenkat@2014");

	           
	            PreparedStatement preparedStatement = connection.prepareStatement(ISSUED_BOOKS_SQL)) {
	            preparedStatement.setInt(1, ibooks.getIssuedId());
	            System.out.println(preparedStatement);
	            ResultSet resultSet=preparedStatement.executeQuery();
		          while(resultSet.next()){
		        	   uid= resultSet.getInt("UID");
			           bookid=resultSet.getInt("BID");
			          
			        	
		          }
		         

	        } catch (SQLException e) {
	            
	            printSQLException(e);
	        }

	        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "iVenkat@2014");

	           
	            PreparedStatement preparedStatement = connection.prepareStatement(ADD_RETURNED_BOOKS_SQL )) {
	            preparedStatement.setInt(1, uid);
	            preparedStatement.setInt(2, bookid);
	            preparedStatement.setString(3, rbooks.getReturn_date());
	            
	            
	            System.out.println(preparedStatement);
	           
	          preparedStatement.executeUpdate();
		          }
		         

	        catch (SQLException e) {
	            
	            printSQLException(e);
	        }
	        
	        try (Connection connection = DriverManager
		            .getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "iVenkat@2014");

		           
		            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ISSUED_BOOKS_SQL )) {
		            preparedStatement.setInt(1, uid);
		            preparedStatement.setInt(2, bookid);
		           
		   
		            
		            System.out.println(preparedStatement);
		           
		            preparedStatement.executeUpdate();
		            return;
			          }
			         

		        catch (SQLException e) {
		            
		            printSQLException(e);
		        }
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

