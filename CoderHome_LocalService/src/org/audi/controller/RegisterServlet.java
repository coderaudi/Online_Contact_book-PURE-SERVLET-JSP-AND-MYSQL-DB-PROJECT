package org.audi.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.audi.Factory.Factory;
import org.audi.beans.UserBean;
import org.audi.model.UserAc;
import org.audi.model.UserDAO;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = "";
		UserBean reguserBean = null ;
		UserBean userbean = new UserBean();
		try {
			
		//	userbean.setUserid(Integer.parseInt(request.getParameter("userid")));
			userbean.setMobile(Long.parseLong(request.getParameter("mobile")));
			userbean.setUsername(request.getParameter("username"));
			userbean.setEmail(request.getParameter("email"));
			userbean.setPassword(request.getParameter("password"));
			
			UserAc nac = Factory.registerUser();
			reguserBean	= nac.createAc(userbean);
			
		}catch(NumberFormatException e) {
			System.out.println("Number Format exception check the userid field ");
			message = "Check Mobile Number";
		}
		
		
		// after register return 
	
			if(reguserBean != null) {
				
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				request.setAttribute("msg", "Account Created Successfully !");
				rd.forward(request, response);
//				HttpSession session = request.getSession(true); // get the session
//				session.setAttribute("user", reguserBean); // set the obj in session
//				
//				session.setMaxInactiveInterval(20);
//				response.sendRedirect("home.jsp"); // send to home page 
//				RequestDispatcher rd = request.getRequestDispatcher("mess/suss.jsp");
//				request.setAttribute("user",reguserBean);
//				rd.forward(request, response);
//				
				
		//		response.sendRedirect("home.jsp");
				System.out.println("ac created ..");
				System.out.println("account details are as follows ");
				System.out.println(reguserBean.getUsername());
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
				
				if(message.equals("")) {
					message = "User Already present";
				}
				request.setAttribute("userMessage",message);
				request.setAttribute("user",userbean);
				rd.forward(request, response);
				System.out.println("not created..");
			}
		
	}

}
