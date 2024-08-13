package com.emp.EmployeeRecord;



import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Configuration cfg=new Configuration();
    	cfg.configure("Hibernate.cfg.xml");
    	SessionFactory sf=cfg.buildSessionFactory();
        Session sn=sf.openSession();
        Transaction ts=sn.beginTransaction();
		/*
		 * Emp_name em=new Emp_name(); em.setFname("vivek3"); em.setM_name("Atul");
		 * em.setLname("soni"); Employee emp=new Employee();
		 * 
		 * 
		 * emp.setName(em); emp.setSal(20000.6); emp.setImg("demo"); emp.setJoindate(new
		 * Date("01/21/2021")); sn.save(emp);
		 */
        Object obj=sn.load(Employee.class,1);//you should give primary key value
    	Employee s=(Employee) obj;
    	System.out.println(s);
        ts.commit();
        sn.close();
        sf.close();
    }
}
