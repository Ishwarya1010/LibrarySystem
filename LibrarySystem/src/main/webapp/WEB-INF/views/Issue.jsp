<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Issue Book</title>
</head>
<body>
<div align="center">
  <h1>Issue Book</h1>
  <form action="<%= request.getContextPath() %>/IssuedBooksServlet" method="post">
   <table style="with: 80%">
    <tr>
     <td> Book ID</td>
     <td><input type="text" name="bookid" /></td>
    </tr>
    <tr>
     <td>User ID</td>
     <td><input type="text" name="userid" /></td>
    </tr>
      <tr>
     <td>Issued Date</td>
     <td><input type="text" name="issueddate" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>
</body>
</html>