package my.framework.hibernate.demo;

import my.framework.hibernate.beans.AmazonUser;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Demo5 {

	public static void main(String[] args) {
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		AmazonUser amazonUser = new AmazonUser();
		amazonUser.setName("Sumit kawatra");
		amazonUser.setAddress("Noida");
		amazonUser.setCredit(12000);
		amazonUser.setScore(120);

		session.beginTransaction();

		session.save(amazonUser);
		session.getTransaction().commit();

		session.close();

		session = null;

		session = sessionFactory.openSession();
		amazonUser = null;
		amazonUser = (AmazonUser) session.get(AmazonUser.class, 1);

		if (amazonUser != null) {
			System.out.println("name > " + amazonUser.getName());
			System.out.println("ID > " + amazonUser.getCustID());
			System.out.println("address > " + amazonUser.getAddress());
			System.out.println("score > " + amazonUser.getScore());
			System.out.println("Credit > " + amazonUser.getScore());
		} else {
			System.out.println("not Possible");
		}
		sessionFactory.close();
	}

}
