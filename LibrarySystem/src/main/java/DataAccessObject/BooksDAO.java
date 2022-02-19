package DataAccessObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Books;

public class BooksDAO {
	

	    public int registerBook(Books book) throws ClassNotFoundException {
	        String INSERT_BOOKS_SQL = "insert into books(book_name,book_publisher,book_edition) values(?,?,?);";

	        int result = 0;

	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "iVenkat@2014");

	           
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOKS_SQL)) {
	            preparedStatement.setString(1, book.getBook_name());
	            preparedStatement.setString(2, book.getBook_publisher());
	            preparedStatement.setString(3, book.getBook_edition());
	           

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


