package org.audi.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.audi.Factory.Factory;
import org.audi.beans.UserBean;
import org.audi.model.UserLogin;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean reguserBean = null ;
		UserBean userbean = new UserBean(); // obj pojo 
		 
		 try {
//			 userbean.setUserid(Integer.parseInt(request.getParameter("userid")));
//		 userbean.setUsername(request.getParameter("email"));
		 userbean.setEmail(request.getParameter("email"));
		 userbean.setPassword(request.getParameter("password"));
		 
			 
			   UserLogin ul = Factory.loginUser();
			   reguserBean =  ul.loginUser(userbean);
			   System.out.println(reguserBean.getEmail());
			 
		 }catch( Exception e) {
			 System.out.println("unable to login");
		 }
		 
		if(reguserBean != null) {
			
			HttpSession session = request.getSession(true); // get the session
			session.setAttribute("user", reguserBean); // set the obj in session
			session.setMaxInactiveInterval(60*5); // auto logout after 5 min
			response.sendRedirect("home.jsp"); // send to home page 
			
			//RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			//request.setAttribute("user", reguserBean);
			//rd.forward(request, response);
		}else {
			System.out.println("not user found ");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			request.setAttribute("userMessage","User ID or Password Incorrect");
			rd.forward(request, response);
		}
	}

}
