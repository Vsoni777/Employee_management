package com.emp.EmployeeRecord;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.toedter.calendar.JDateChooser;

public class EmpFrame extends JFrame implements ActionListener {
	JLabel l1,l2,l3,head,l4,l5,l6,foot;
	JTextField t1,t2,t3,t4,t5,t6;
	JButton b1,b2,b3,b4,b5,b6;
	JDateChooser dob;
	
	EmpFrame(){
		setSize(500,500);
		setLocation(350,30);
		setLayout(null);
		
		head=new JLabel("New student Details");
		head.setBounds(150,30,200,50);
		head.setFont(new Font("serif",Font.BOLD,20));
		add(head);
		
		
		l1=new JLabel("Empid:-   ");
		l1.setBounds(50, 80, 80, 20);
		add(l1);
		
		t1=new JTextField(20);
		t1.setBounds(140, 80, 150, 25);
		add(t1);
		

		l2=new JLabel("First Name:-");
		l2.setBounds(50,120, 80, 20);
		add(l2);
		
		t2=new JTextField(20);
		t2.setBounds(140, 120, 150, 25);
		add(t2);
		
		l4=new JLabel("Middle Name:-");
		l4.setBounds(50,150, 100, 20);
		add(l4);
		
		t4=new JTextField(20);
		t4.setBounds(140, 150, 150, 25);
		add(t4);
		
		l5=new JLabel("last Name:-");
		l5.setBounds(50,180, 100, 20);
		add(l5);
		
		t5=new JTextField(20);
		t5.setBounds(140, 180, 150, 25);
		add(t5);
		
		l3=new JLabel("Salary:-");
		l3.setBounds(50,210, 60, 20);
		add(l3);
		
		t3=new JTextField(20);
		t3.setBounds(140, 210, 150, 25);
		add(t3);
		
		l6=new JLabel("Joining Date");
		l6.setBounds(50,240,150,30);
		l6.setFont(new Font("serif",Font.BOLD,16));
		add(l6);
		
		dob=new JDateChooser();
		dob.setBounds(160, 240, 150, 30);
		add(dob);
		
		b1=new JButton("save");
		b1.setBounds(50, 300, 80, 30);
		add(b1);
		b2=new JButton("Update");
		b2.setBounds(150, 300, 80, 30);
		add(b2);
		b3=new JButton("Retrieve");
		b3.setBounds(250, 300, 100, 30);
		add(b3);
		b4=new JButton("Delete");
		b4.setBounds(50, 350, 80, 30);
		add(b4);
		b5=new JButton("Close");
		b5.setBounds(150, 350, 80, 30);
		add(b5);
		b6=new JButton("Reset");
		b6.setBounds(250, 350, 80, 30);
		add(b6);
		
		foot=new JLabel("");
		foot.setBounds(50,400,250,30);
		foot.setFont(new Font("serif",Font.BOLD,20));
		foot.setForeground(Color.GREEN);
		add(foot);
		
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
	}
	public static void main(String[] args) {
		EmpFrame em=new EmpFrame();
		em.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		
		
		//System.out.print(emp);
		Configuration cfg=new Configuration().configure();
		SessionFactory sf=cfg.buildSessionFactory();
		
		
		if(ae.getSource()==b1) {
			Employee emp=new Employee();
			try {
				emp.setId(Integer.parseInt(t1.getText()));
			}catch(NumberFormatException qe) {
				t1.setText("Invalid format");
			}
			
			Emp_name e=new Emp_name();
			e.setFname(t2.getText());
			e.setM_name(t4.getText());
			e.setLname(t5.getText());
			emp.setName(e);
			emp.setSal(Double.parseDouble(t3.getText()));
			emp.setJoindate(dob.getDate());
			Session sn=sf.openSession();
			Transaction tc=sn.beginTransaction();
			System.out.println(emp);
			
			  sn.save(emp);  
			  foot.setText("Records inserted successfully");
			  tc.commit();sn.close();
			
		}
		
		if(ae.getSource()==b3) {
			Employee e1=new Employee();
			e1.setId(Integer.parseInt(t1.getText()));
		
			
			  Session sn=sf.openSession(); Transaction tc=sn.beginTransaction(); 
			  Object obj=sn.get(Employee.class,e1.getId()); 
			  Employee emp1=(Employee)obj;
			 
			  if(emp1==null) {
				  foot.setText("Record not found");

			  }else {
			  System.out.println(emp1);
			  t2.setText(emp1.getName().getFname());
			  t4.setText(emp1.getName().getM_name());
			  t5.setText(emp1.getName().getLname());
			  t3.setText(String.valueOf(emp1.getSal()));
			  dob.setDate(emp1.getJoindate());
			  foot.setText("Record Found");
			  tc.commit();
			  }
			  
			  sn.close();
			 
		}
		if(ae.getSource()==b2) {
			Employee e1=new Employee();
			e1.setId(Integer.parseInt(t1.getText()));
		
			
			  Session sn=sf.openSession(); 
			  Transaction tc=sn.beginTransaction(); 
			  Object obj=sn.get(Employee.class,e1.getId()); 
			  Employee emp1=(Employee)obj;
			  if(emp1==null) {
				  foot.setText("Record not found");

			  }else {
					emp1.setSal(Double.parseDouble(t3.getText()));
					sn.update(emp1);
					  foot.setText("salary updated");

			  }
			  tc.commit();
			  sn.close();
		}
		
		if(ae.getSource()==b4) {
			Employee e1=new Employee();
			e1.setId(Integer.parseInt(t1.getText()));
		
			
			  Session sn=sf.openSession(); 
			  Transaction tc=sn.beginTransaction(); 
			  Object obj=sn.get(Employee.class,e1.getId()); 
			  Employee emp1=(Employee)obj;
			  if(emp1==null) {
				  foot.setText("Record not found");

			  }else {
					
					sn.delete(emp1);
					  foot.setText("Record delete successfully");

			  }
			  tc.commit();
			  sn.close();
		}
		if(ae.getSource()==b5) {
			setVisible(false);

		}
		if(ae.getSource()==b6) {
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
		}
	}
}
