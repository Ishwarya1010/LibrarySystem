<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Functions</title>
</head>
<body>
<div align="center">
  <h1>Admin Functions</h1>
<table>
    <tr>
     <td><button onclick="window.location.href='/LibrarySystem/ViewBooksServlet'">View Books</button></td>
     <td><button onclick="window.location.href='/LibrarySystem/ViewUsersServlet'">View Users</button></td>
     <td><button onclick="window.location.href='/LibrarySystem/ViewIssuedBooksServlet'">View Issued Books</button></td>   
     <td><button onclick="window.location.href='/LibrarySystem/IssuedBooksServlet'">Issue Book</button></td>
     <td><button onclick="window.location.href='/LibrarySystem/AddUserServlet'">Add User</button></td>
     <td><button onclick="window.location.href='/LibrarySystem/BooksServlet'">Add Book</button></td>
    <td><button onclick="window.location.href='/LibrarySystem/ReturnedBooksServlet'">Return Book</button></td>
    </tr>
</table>
</div>
</body>
</html>