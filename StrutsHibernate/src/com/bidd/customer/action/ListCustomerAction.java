package com.bidd.customer.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bidd.common.plugin.HibernatePlugin;
import com.bidd.customer.entity.Customer;

public class ListCustomerAction extends Action {
	
	public ActionForward execute (ActionMapping mapping, ActionForm form, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
		
		SessionFactory sf =
				(SessionFactory) servlet.getServletContext().getAttribute(HibernatePlugin.KEY_NAME);
		
		Session session = sf.openSession();
		
		DynaActionForm dyna = (DynaActionForm) form;
		
		List<Customer> list = session.createQuery("from Customer").list();
		
		dyna.set("customerList",  list);
		
		
		return mapping.findForward("success");
	}
}
