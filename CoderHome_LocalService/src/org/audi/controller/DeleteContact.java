package org.audi.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.audi.Factory.Factory;
import org.audi.beans.ContactBean;
import org.audi.beans.UserBean;
import org.audi.model.DeleteCont;

/**
 * Servlet implementation class DeleteContact
 */
public class DeleteContact extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserBean user = (UserBean) request.getSession(false).getAttribute("user");  // current user
		ArrayList<ContactBean> allcont = new ArrayList<ContactBean>(); // contact list 
		Long mobile = Long.parseLong(request.getParameter("mobile")); // mobile no 2 delete
		System.out.println("delcont"+mobile);
								
			DeleteCont dcont =	Factory.deleteCont(); // factory to delete 
			boolean dresult =	dcont.deleteCont(user, mobile);
			
			if(dresult == true) {
				// disp updated contact list 
				ContactBean contbean = new ContactBean();
				contbean.setUserid(user.getUserid());
				allcont = Factory.allContact().getAllContact(contbean);
				
				RequestDispatcher rd = request.getRequestDispatcher("mycont.jsp");
		        request.setAttribute("allcont", allcont);
				rd.forward(request, response);
			}
			else {
				response.getWriter().println("<h1>Contact Not Deleted ...! </h1>");
			}
			
		
	}

}
