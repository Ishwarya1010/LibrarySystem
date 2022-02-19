<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@ page import ="java.util.ArrayList"%>

<html>
<head>
<meta charset="UTF-8">
<title>My Books List</title>
</head>
<body>
  <h1>My Books</h1>
<table border="1">
<tr>
<td>Bid</td>
<td>Book Name</td>
<td>Book Publisher</td>
<td>Book Edition</td>

</tr>
<%ArrayList<Integer> bid=new ArrayList<>(); %>
<%int uid=(Integer)session.getAttribute("UID"); %>
<%  Class.forName("com.mysql.jdbc.Driver");
	          try (Connection connection = DriverManager
			            .getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "iVenkat@2014");
	        		  PreparedStatement preparedStatement = connection.prepareStatement("select  BID from issued_books where UID=uid;")){
	          ResultSet resultSet=preparedStatement.executeQuery();
	          while(resultSet.next()){
	        	bid.add(resultSet.getInt("BID"));}}
	          catch (Exception e) {
	        	  e.printStackTrace();
	        	  }
	        	  %>
	        	  <%for (int counter = 0; counter < bid.size(); counter++)
	        	  {
	        		  try (Connection connection = DriverManager
			            .getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "iVenkat@2014");
	        		  PreparedStatement preparedStatement = connection.prepareStatement("select  * from books where bid=?;")){
	        			  preparedStatement.setInt(1, bid.get(counter));
	     
	          ResultSet resultSet=preparedStatement.executeQuery();
	          while(resultSet.next()){ 
	        		  %>
	        	  
	          <tr>
	        	 <td><%=resultSet.getInt("bid")%></td>
	        	   <td><%=resultSet.getString("book_name")%></td>
	        	     <td><%=resultSet.getString("book_publisher")%></td>
	        	      <td><%=resultSet.getString("book_edition")%></td>
	        	      </tr>
	        	  
	        	  <%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
	        	  }
%>

</table>
</body>
</html>