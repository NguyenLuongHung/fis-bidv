package com.bidd.customer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bidd.common.plugin.HibernatePlugin;
import com.bidd.customer.entity.Customer;

public class AddCustomerAction extends Action {
	
		public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			
			SessionFactory sessionFactory =
					(SessionFactory) servlet.getServletContext().getAttribute(HibernatePlugin.KEY_NAME);
			
			Session session = sessionFactory.openSession();
			
			Customer customer = new Customer();
			customer.setName(request.getParameter("name"));
			customer.setAddress(request.getParameter("address"));
			customer.setPhone(request.getParameter("phone"));
			
			Transaction tx = session.beginTransaction();
			session.save(customer);
			tx.commit();
			
			
			return mapping.findForward("success");
		}
}
