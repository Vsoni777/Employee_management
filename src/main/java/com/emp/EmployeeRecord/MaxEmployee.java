package com.emp.EmployeeRecord;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MaxEmployee {
	public static void main(String[] args) {
		Configuration cfg=new Configuration().configure();
		SessionFactory sf=cfg.buildSessionFactory();
		Session sn=sf.openSession();
		Transaction tx=sn.beginTransaction();
		Query q=sn.createQuery("select max(sal) from Employee");
		List<Employee> list=q.list();
		
		System.out.println(list.get(0));
		Query q1=sn.createQuery("from Employee where sal=:r");
		q1.setParameter("r", list.get(0));
		List<Employee> list1=q1.list();
		for(Employee em:list1) {
			System.out.println(em);
		}
		tx.commit();
		sn.close();
		sf.close();
	}
}
