package my.framework.hibernate.demo;


import my.framework.hibernate.beans.Address;
import my.framework.hibernate.beans.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Demo3 {

	public static void main(String[] args) {
		
		Student student = new Student();
		Address address = new Address();
		
		student.setRollNumber(11);
		student.setName("Sumit Kawatra");				
		address.setCity("Rohtak");
		address.setPincode("124001");		
		address.setState("Haryana");		
		student.setAddress(address);
		
		
		
		Student student2 = new Student();
		Address address2 = new Address();
		student2.setRollNumber(22);
		student2.setName("Rahul");
		address2.setCity("Delhi");
		address2.setPincode("201301");
		address2.setState("India");
		student2.setAddress(address2);
				
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		
		
		try{
			session.beginTransaction();						
			session.save(student);
			session.getTransaction().commit();	
			session.beginTransaction();						
			session.save(student2);
			session.getTransaction().commit();	
			
				
		}finally{
			session.close();
			sessionFactory.close();
		}
		
	}

}

