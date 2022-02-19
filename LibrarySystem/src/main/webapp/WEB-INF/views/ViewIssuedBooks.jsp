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
<title>Issued Books List</title>
</head>
<body>
  <h1>Issued Books List</h1>
<table border="1">
<tr>
<td>Issued ID</td>
<td>User ID</td>
<td>Book ID</td>
<td>Issued Date</td>

</tr>
<%
 Class.forName("com.mysql.jdbc.Driver");
	          try (Connection connection = DriverManager
			            .getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "iVenkat@2014");
	        		  PreparedStatement preparedStatement = connection.prepareStatement("select  * from issued_books;")){
	          ResultSet resultSet=preparedStatement.executeQuery();
	          while(resultSet.next()){
	        	  %>
	           <tr>
	        	 <td><%=resultSet.getInt("IID")%></td>
	        	   <td><%=resultSet.getInt("UID")%></td>
	        	     <td><%=resultSet.getInt("BID")%></td>
	        	      <td><%=resultSet.getString("ISSUED_DATE")%></td>
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