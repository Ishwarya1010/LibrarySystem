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

<html>
<head>
<meta charset="UTF-8">
<title>Books List</title>
</head>
<body>
  <h1>Books List</h1>
<table border="1">
<tr>
<td>Bid</td>
<td>Book Name</td>
<td>Book Publisher</td>
<td>Book Edition</td>

</tr>
<%
 Class.forName("com.mysql.jdbc.Driver");
	          try (Connection connection = DriverManager
			            .getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "iVenkat@2014");
	        		  PreparedStatement preparedStatement = connection.prepareStatement("select  * from books;")){
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
%>
</table>
	        	 
</body>
</html>