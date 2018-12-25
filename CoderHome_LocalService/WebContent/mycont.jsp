<%@page import="java.util.ArrayList"%>
<%@page import="org.audi.beans.ContactBean"%>
<%@page import="org.audi.beans.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% UserBean us = null; %>
 <%	
 if (session.getAttribute("user") == null) {
	 response.sendRedirect("index.html");
	}else{
		us = (UserBean) session.getAttribute("user");
}
 %>
 
 <%  
// retrieve your list from the request, with casting 
ArrayList<ContactBean> list = (ArrayList<ContactBean>) request.getAttribute("allcont");

// print the information about every category of the list

%>
 
 
 
<!DOCTYPE html> 
<html lang="en">
<head>
  <title> <%=us.getUsername() %> Add Contacts </title>
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
      <li><a href="profile.jsp">Profile</a></li>
      <li ><a href="addcont.jsp">Add Contact</a></li>
       <li  class="active"><a href="allcont">My Contacts</a></li>
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


<h1>Your All Contacts </h1>


<div class="table-responsive">          
  <table class="table">
     <thead>

            <tr>
               <th>Serial Number</th>
                <th>Contact Names  </th>
                <th>Mobile Numbers  </th>
            </tr>
        </thead>
        <tbody>
           <% for(int i = 0; i < list.size(); i++) {
                ContactBean cont  = new ContactBean();
                cont = list.get(i);
    
            %>
           <tr>
                <td><%=i+1 %></td>
                <td><%=cont.getName() %></td>
                <td><%=cont.getMobile() %></td>
            </tr>
             <%
            };
            %>
        </tbody>
  </table>
   <form action=" " method="get"> 
 <input type="text" name="mobile"><input type="submit" value="delete cont">
  </form>
  </div>


</body>
</html>

