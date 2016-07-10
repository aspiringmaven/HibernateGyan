package my.framework.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.framework.hibernate.mapping.pojo.CodeUser;
import my.framework.hibernate.mapping.pojo.CodeUserDetails;

public class JPAMapping3 {
	// One to one uni-directional mapping using primary forgien key
	//one to one bidirectinal mapping
	public static void main(String[] args) {	
		CodeUser codeUser = new CodeUser();
		CodeUserDetails codeUserDetails = new CodeUserDetails();
		
		codeUser.setEmail("sumit.k@hcl.com");
		codeUser.setName("Dev Sumit Kawatra");
		
		codeUserDetails.setCompany("HCLTech ltd.");
		codeUserDetails.setDesignation("Software Engineer");
		codeUserDetails.setProject("BFW");
		
		codeUser.setCodeUserDetails(codeUserDetails);
		codeUserDetails.setCodeUser(codeUser);
		
		
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		System.out.println("Saving....");
		session.beginTransaction();
		
		session.save(codeUser);
		
		session.getTransaction().commit();
		session.close();
		
		System.out.println("------------ fetching---------------");
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
//		CodeUser codeUser2 = (CodeUser) session.get(CodeUser.class, 1);
		CodeUserDetails codeUser2 = (CodeUserDetails) session.get(CodeUserDetails.class, 1);
		
		System.out.println(codeUser2.getCodeUser());
		
		session.getTransaction().commit();
		
		session.close();
		sessionFactory.close();
	}
}