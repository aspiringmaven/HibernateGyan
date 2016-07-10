package my.framework.hibernate.demo;

import java.util.LinkedHashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.framework.hibernate.beans.Engineer;

public class Demo2 {
	
	public static void main(String[] args) {
		Engineer engineer1 =  new Engineer();
		Engineer engineer2 =  new Engineer();
		
		engineer1.setSkills(new LinkedHashSet<String>());
		engineer2.setSkills(new LinkedHashSet<String>());
		
		engineer1.setEmpId(1);
		engineer1.setEmpId(2);
		
		engineer1.setName("Sumit Kawatra");
		engineer2.setName("Rahul Bhayana");
		
		engineer1.getSkills().add("Java");
		engineer1.getSkills().add("JSP");
		engineer1.getSkills().add("SERVLET");
		engineer1.getSkills().add("JNDI");
		engineer1.getSkills().add("JavaScript");
		engineer1.getSkills().add("JQuery");
		engineer1.getSkills().add("Spring");
		engineer1.getSkills().add("Hibernate");
		
		
		engineer2.getSkills().add("SQL");
		engineer2.getSkills().add("PL/SQL");
		engineer2.getSkills().add("SSIS");
		engineer2.getSkills().add("SSRS");
		engineer2.getSkills().add("ETL");
		engineer2.getSkills().add("C#");
		engineer2.getSkills().add("LINQ");
		
		
		
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		
		session.beginTransaction();
		
		try{
			
			session.save(engineer1);
			session.save(engineer2);
			
			session.getTransaction().commit();
			System.out.println("Done");
		}finally{
			session.close();
			sessionFactory.close();
		}
		
		
		
		
	}
	
}
