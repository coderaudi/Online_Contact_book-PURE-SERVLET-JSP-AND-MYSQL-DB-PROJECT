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


/**
 * Servlet implementation class AllContact
 */
public class AllContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	
//		// get the current user session details
//		UserBean usinfo	= (UserBean) request.getSession(false).getAttribute("user");
//		// session details
//		
//		// set your contactBean
//		ContactBean contbean = new ContactBean();
//		contbean.setUserid(usinfo.getUserid());
//		
//		System.out.println("all cont servlet req");
//		Factory.allContact().getAllContact(contbean);
//	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get the current user session details
		ArrayList<ContactBean> allcont = new ArrayList<ContactBean>();
				try {
					UserBean usinfo	= (UserBean) req.getSession(false).getAttribute("user");
					// session details
					
					// set your contactBean
					ContactBean contbean = new ContactBean();
					contbean.setUserid(usinfo.getUserid());
					
					System.out.println(usinfo.getUserid());
				
				  allcont =	Factory.allContact().getAllContact(contbean);
				  
				}catch(Exception e){
					System.out.println("contact not found...");
				}
				
				if(allcont != null) {
					System.out.println("all cont get succ in arraylist");
					
					RequestDispatcher rd = req.getRequestDispatcher("mycont.jsp");
			        req.setAttribute("allcont", allcont);
					rd.forward(req, resp);
				
				//	response.sendRedirect("addcont.jsp"); // send to home page 
				}else {
				
					req.setAttribute("contStatusMessage","No Contact Found ");
					RequestDispatcher rd = req.getRequestDispatcher("addcont.jsp");
					rd.forward(req, resp);
				}
	}

}
