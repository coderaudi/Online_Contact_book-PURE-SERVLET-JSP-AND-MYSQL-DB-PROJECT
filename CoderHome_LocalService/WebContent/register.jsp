<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login User</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default" style="background-color:yellow";>
  <div class="container-fluid row">
    <div class="navbar-header">
       <a class="navbar-brand" href="#"> 
        <img alt="CoderHome" src="https://www.designfreelogoonline.com/wp-content/uploads/2014/12/00240-Design-Free-3D-Company-Logo-Templates-03.png" width="100px" height="90px">
      </a>
      <a class="navbar-brand" href="#"> <h2>CoderHome Register Service...</h2></a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="#"></a></li>
      <li><a href="#"></a></li>
    </ul>
  </div>
</nav>

<div class="container">

<div class="col-sm-6 jumbotron">

<form action="register" method="post">
  
   <div class="form-group">
   <h3>${userMessage}</h3>
    <label for="username">User Name:</label> 
    <input type="text" class="form-control" id="username" name="username" required="required" >
  </div>
 <div class="form-group">
    <label for="email">Email address:</label> 
    <input type="email" class="form-control" id="email" name="email" required="required" >
  </div>
     <div class="form-group">
    <label for="mobile">Mobile No:</label> 
    <input type="text" class="form-control" id="mobile" name="mobile" required="required">
  </div>
  <div class="form-group">
    <label for="pwd">Password:</label>
    <input type="password" class="form-control " id="pwd" name="password" required="required">
  </div>
 <button type="reset" class="btn btn-primary">Reset</button>
  <button type="submit" class="btn btn-primary">Submit</button>
  <a href="login.jsp"> Go to Login </a>
</form>
</div>  

 </div>

<div class="row" style="background-color:yellow"; >
        <div class="col-lg-12">
            <ul class="nav nav-pills nav-justified">
                <li><a href="#"> &copy 2018 CoderHome.</a></li>
                <li><a href="#">Terms of Service</a></li>
                <li><a href="#">Privacy</a></li>
            </ul>
        </div>
    </div>
</body>
</html>