<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Functions</title>
</head>
<body>
<% session.setAttribute("userId", (Integer)request.getAttribute("UserId"));%>
 <div align="center">
  <h1>User Functions</h1>
 <table>
    <tr>
     <td><button onclick="window.location.href='/LibrarySystem/ViewBooksServlet'">View Books</button></td>
     <td><button onclick="window.location.href='/LibrarySystem/ViewMyBooksServlet'">My Books</button></td>
     </tr>
     </table>
 </div>
</body>
</html>