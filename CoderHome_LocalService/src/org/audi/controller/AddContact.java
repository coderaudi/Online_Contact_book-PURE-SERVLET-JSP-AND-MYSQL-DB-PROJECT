package org.audi.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.audi.Factory.Factory;
import org.audi.beans.ContactBean;
import org.audi.beans.UserBean;
import org.audi.model.Contact;

/**
 * Servlet implementation class AddContact
 */
public class AddContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	UserBean usinfo	= (UserBean) request.getSession(false).getAttribute("user");
		
	// setting data to contBean 
	
		ContactBean cont = new ContactBean();
		ContactBean rcbena = null;
		try {
		cont.setUserid(usinfo.getUserid());
		cont.setName(request.getParameter("contname"));
		cont.setMobile(Long.parseLong(request.getParameter("mobile")));
		
		 Contact ct = Factory.addContact();
		      rcbena =  ct.addCont(cont);
		}catch(Exception e) {
			System.out.println(e);
			cont.setMesg("Unable to add contact Sorry try again !");
		}
		
		if(rcbena != null) {
			System.out.println("added cont");
			request.setAttribute("contStatusMessage","Contact Is added");
			RequestDispatcher rd = request.getRequestDispatcher("addcont.jsp");
	        request.setAttribute("addcont", rcbena);
			rd.forward(request, response);
		//	response.sendRedirect("addcont.jsp"); // send to home page 
		}else {
		
			request.setAttribute("contStatusMessage","Mobile no is invalide");
			RequestDispatcher rd = request.getRequestDispatcher("addcont.jsp");
		
			rd.forward(request, response);
		}
		
		// sending to db 
		
		System.out.println(cont.getName()+cont.getMobile());
		System.out.println(usinfo.getUserid()+usinfo.getEmail());
	  
	}

}
