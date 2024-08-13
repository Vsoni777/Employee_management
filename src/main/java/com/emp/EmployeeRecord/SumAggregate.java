package com.emp.EmployeeRecord;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SumAggregate {
	public static void main(String[] args) {
		Configuration cfg=new Configuration().configure();
		SessionFactory sf=cfg.buildSessionFactory();
		Session sn=sf.openSession();
		Transaction ts=sn.beginTransaction();
		/*
		 * Query q=sn.createQuery("from Employee"); List<Employee> list=q.list();
		 * for(Employee e:list) { System.out.println(list); }
		 */
		
		Query q=sn.createQuery(" select sum(sal) from Employee");
		List<Employee> em=q.list();
		System.out.println(em.get(0));
		ts.commit();
		sn.close();
		sf.close();
		
		
	}
}
