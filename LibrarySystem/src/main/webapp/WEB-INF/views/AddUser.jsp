<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enter User Details</title>
</head>
<body>
<div align="center">
  <h1>Add User</h1>
  <form action="<%= request.getContextPath() %>/AddUserServlet" method="post">
   <table style="with: 80%">
    <tr>
     <td>Name</td>
     <td><input type="text" name="name" /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" /></td>
    </tr>
     <tr>
     <td><input type="radio" name = "usertype" value="1"> Admin</td>
     <td><input type="radio" name = "usertype" value="0">User</td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>
</body>
</html>