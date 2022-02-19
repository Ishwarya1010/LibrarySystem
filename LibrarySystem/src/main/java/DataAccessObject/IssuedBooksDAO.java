package DataAccessObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.Books;
import Model.IssuedBooks;
import Model.Users;

public class IssuedBooksDAO {
    public int issueBook(Books book,Users user,IssuedBooks ibook) throws ClassNotFoundException {
    	int result=0;
        String INSERT_ISSUEDBOOKS_SQL = "insert into issued_books(UID,BID,ISSUED_DATE) values(?,?,?);";
        

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "iVenkat@2014");

           
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ISSUEDBOOKS_SQL)) {
            preparedStatement.setInt(1, user.getUid());
            preparedStatement.setInt(2, book.getBid());
            preparedStatement.setString(3, ibook.getIssuedDate());
           

            System.out.println(preparedStatement);
           
           result=preparedStatement.executeUpdate();
          
        }
        
        catch (SQLException e) {
            
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






