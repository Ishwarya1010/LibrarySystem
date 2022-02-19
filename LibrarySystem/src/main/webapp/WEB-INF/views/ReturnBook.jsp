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
  <h1>Return Book</h1>
  <form action="<%= request.getContextPath() %>/ReturnedBooksServlet" method="post">
   <table style="with: 80%">
    <tr>
     <td>Issue ID</td>
     <td><input type="text" name="issueid" /></td>
    </tr>
    <tr>
     <td>Return Date</td>
     <td><input type="text" name="returndate" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
  </form>
  </div>
</body>
</html>