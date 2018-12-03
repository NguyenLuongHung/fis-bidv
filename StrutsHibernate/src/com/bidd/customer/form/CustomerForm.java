package com.bidd.customer.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class CustomerForm extends ActionForm {
	
	private String name;
	private String address;
	private String phone;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		
		ActionErrors error = new ActionErrors();
		
		if ((getName() == null) || ("".equals(getName()))) {
			error.add("customer.name.error", new ActionMessage("customer.name.err.required"));
		}
		
		if ((getAddress() == null) || ("".equals(getAddress()))) {
			error.add("customer.address.error", new ActionMessage("customer.address.err.required"));
		}
		if ((getPhone() == null) || ("".equals(getPhone()))) {
			error.add("customer.address.error", new ActionMessage("customer.phone.error.required"));
		}
		
		return error;
	}
	
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		name = "";
		address = "";
		phone = "";
	}
}
