package com.emp.Criteriaexa;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.emp.EmployeeRecord.Employee;

public class TosetCriteria {
	public static void main(String[] args) {
		Configuration cfg=new Configuration().configure();
		SessionFactory sf=cfg.buildSessionFactory();
		Session sn=sf.openSession();
		Transaction tx=sn.beginTransaction();
		Criteria cr=sn.createCriteria(com.emp.EmployeeRecord.Employee.class);
		cr.add(Restrictions.eq("sal", 46500.6));
		List<Employee> list=cr.list();
		for(Employee em:list) {
			System.out.println(em);
		}
		tx.commit();
		sn.close();
		sf.close();
		
	}
}
