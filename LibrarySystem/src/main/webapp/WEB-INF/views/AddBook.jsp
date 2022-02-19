<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enter Details</title>
</head>
<body>
<div align="center">
  <h1>Add Book</h1>
  <form action="<%= request.getContextPath() %>/BooksServlet" method="post">
   <table style="with: 80%">
    <tr>
     <td>Book Name</td>
     <td><input type="text" name="book_name" /></td>
    </tr>
     <tr>
     <td>Book Publisher</td>
     <td><input type="text" name="book_publisher" /></td>
    </tr>
     <tr>
     <td>Book Edition</td>
     <td><input type="text" name="book_edition" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
  </form>
  </div>
</body>
</html>