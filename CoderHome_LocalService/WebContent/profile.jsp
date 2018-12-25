<%@page import="org.audi.beans.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% UserBean us = null; %>
 <%	
 if (session.getAttribute("user") == null && us == null) {
	 response.sendRedirect("index.html");
	}else{
		 us = (UserBean) session.getAttribute("user");
	}
 %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title> <%=us.getUsername() %> Profile </title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body background="" >

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">CoderHome</a>
    </div>
    <ul class="nav navbar-nav">
      <li ><a href="home.jsp">Home</a></li>
      <li class="active"><a href="profile.jsp">Profile</a></li>
       <li><a href="addcont.jsp">Add Contact</a></li>
       <li><a href="allcont">My Contacts</a></li>
      <li>
      
      <form class="navbar-form navbar-left" action="/action_page.php">
      <div class="form-group">
        <input type="text" class="form-control" placeholder="Search" name="search">
      </div>
      <button type="submit" class="btn btn-default">Submit</button>
    </form>
      </li>
      <li>
      <form class="navbar-form navbar-left" action="logout" method="post">
      <button type="submit" class="btn btn-danger">Logout</button>
    </form>
      </li>
    </ul>
    
    
    
  </div>
</nav>

<div class="container">
 
 
<div class="container-fluid">

  <h1> <%=us.getUsername() %> Profile Details</h1>
 
 <h4>
 UserID: <%=us.getUserid() %>  <br>
 UserName: <%=us.getUsername() %>  <br>
 Email: <%=us.getEmail() %>  <br>
 Mobile:<%=us.getMobile() %>  <br>
 </h4>


</div>
 
</div>


<hr>




</body>
</html>