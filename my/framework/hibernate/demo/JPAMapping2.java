package my.framework.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.framework.hibernate.mapping.pojo.BankAccount;
import my.framework.hibernate.mapping.pojo.BankAccountPlus;

public class JPAMapping2 {
	// One to one bi-directional mapping using primary Key  sharing
	public static void main(String[] args) {
		BankAccount bankAccount = new BankAccount();
		BankAccountPlus bankAccountPlus = new BankAccountPlus();
		
		bankAccount.setBalance(2000);
		bankAccount.setName("Sumit Kawatra");
		
		bankAccountPlus.setBranch("Rohtak");
		bankAccountPlus.setType("PPF");
		
		bankAccount.setBankAccountPlus(bankAccountPlus);		
		bankAccountPlus.setBankAccount(bankAccount);
		
		
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		System.out.println("Saving....");
		session.beginTransaction();
		
		session.save(bankAccountPlus);
		
		session.getTransaction().commit();
		session.close();
		
//		System.out.println("------------ fetching---------------");
//		
//		session =  sessionFactory.openSession();
//		
//		session.beginTransaction();
//		BankAccount ba = (BankAccount) session.get(BankAccount.class, 1);
//		
//		
//		
//		System.out.println(ba);
//		System.out.println(ba.getBankAccountPlus());
		System.out.println("Delete Dteached state");
//		session.delete(ba.getBankAccountPlus());
//		
//		session.getTransaction().commit();
//		session.close();
//		sessionFactory.close();
		
		
		
	}
}