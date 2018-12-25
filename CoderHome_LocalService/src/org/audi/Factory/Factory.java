package org.audi.Factory;

import java.util.ArrayList;

import org.audi.beans.ContactBean;
import org.audi.model.AllContact;
import org.audi.model.AllContactDAO;
import org.audi.model.Contact;
import org.audi.model.ContactDAO;
import org.audi.model.UserAc;
import org.audi.model.UserDAO;
import org.audi.model.UserLogin;
import org.audi.model.UserLoginDAO;

public class Factory {
	private Factory() {
		
	}
	
	public static UserAc registerUser() {
		return (UserAc)  new UserDAO();
	}
	
	public static UserLogin loginUser() {
		return (UserLogin) new UserLoginDAO();
	}
	
	public static Contact addContact() {
		return (Contact)  new ContactDAO();
		
	}
	
	public static AllContact allContact(){
		return  (AllContact) new AllContactDAO();
		
	}
}
