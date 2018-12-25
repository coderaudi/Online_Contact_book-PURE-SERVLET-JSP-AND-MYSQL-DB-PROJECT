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
      <li class="active"><a href="home.jsp">Home</a></li>
      <li><a href="profile.jsp">Profile</a></li>
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

<button type="button" class="btn btn-info" data-toggle="collapse" data-target="#demo">Current User Details</button>
  <div id="demo" class="collapse">
 <h1>Welcome <%=us.getUsername() %></h1>
<%=us.getEmail() %>
<%=us.getMobile() %>
  </div>

<br> <br> <br>

 <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">

      <div class="item active">
        <img src="https://www.businessdayonline.com/wp-content/uploads/2015/04/ICT.png" alt="Los Angeles" style="width:100%;">
        <div class="carousel-caption">
          <h3>Los Angeles</h3>
          <p>LA is always so much fun!</p>
        </div>
      </div>

      <div class="item">
        <img src="https://www.gizbot.com/files/2011/12/online-tech.jpeg" alt="Chicago" style="width:100%;">
        <div class="carousel-caption">
          <h3>Chicago</h3>
          <p>Thank you, Chicago!</p>
        </div>
      </div>
    
      <div class="item">
        <img src="data:image/jpeg;base64,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" alt="New York" style="width:100%;">
        <div class="carousel-caption">
          <h3>New York</h3>
          <p>We love the Big Apple!</p>
        </div>
      </div>
  
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>


</div>
 
</div>

  



</body>
</html>