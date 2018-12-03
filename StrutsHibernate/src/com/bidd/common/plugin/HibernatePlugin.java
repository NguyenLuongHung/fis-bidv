package com.bidd.common.plugin;

import java.net.URL;

import javax.servlet.ServletException;

import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.metamodel.source.MappingException;

public class HibernatePlugin implements PlugIn {
	private Configuration config;
	private SessionFactory factory;
	private String path = "/hibernate.cfg.xml";
	private static Class clazz = HibernatePlugin.class;
	
	public static final String KEY_NAME = clazz.getName();
	
	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		try {
			factory.close();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public void init(ActionServlet servlet, ModuleConfig arg1) throws ServletException {
		// TODO Auto-generated method stub
		
		// Save SessionFactory to ServletContext
		try {
			URL url = HibernatePlugin.class.getResource(path);
			config = new Configuration().configure(url);
			factory = config.buildSessionFactory();
			servlet.getServletContext().setAttribute(KEY_NAME, factory);
		} catch (MappingException ex) {
			ex.printStackTrace();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		}

	}

}
