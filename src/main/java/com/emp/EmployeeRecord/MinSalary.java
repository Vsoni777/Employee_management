package com.emp.EmployeeRecord;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MinSalary {
	public static void main(String[] args) {
		Configuration cfg=new Configuration().configure();
		SessionFactory sf=cfg.buildSessionFactory();
		Session sn=sf.openSession();
		Transaction tx=sn.beginTransaction();
		Double min=(Double)sn.createQuery("select min(sal) from Employee").getSingleResult();
		System.out.println(min);
		
		Query<Employee> q=sn.createQuery("from Employee where sal=:r");
		q.setParameter("r", min);

		List<Employee> list=q.list();
		for(Employee em:list) {
			System.out.println(em);
		}
		tx.commit();
		sn.close();
		sf.close();
	}
}
