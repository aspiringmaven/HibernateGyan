package my.framework.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.framework.hibernate.mapping.pojo.ATM;
import my.framework.hibernate.mapping.pojo.Account;


// One to one uni-directional mapping using primary Key  sharing  
public class JPAMapping1 {

	public static void main(String[] args) {
		Account account = new Account();
		ATM atm = new ATM();
		
		
		atm.setCardNumber(1111);
		atm.setCardType("Debit card");
		
		account.setBalance(2000);
		account.setOwner("Sumit Kawatra");
		account.setAtm(atm);
		
		Account account2 = new Account();
		ATM atm2 = new ATM();
		
		atm2.setCardNumber(2222);
		atm2.setCardType("Debit--card");
		
		account2.setBalance(3000);
		account2.setOwner("Rahul Bhayana");
		account2.setAtm(atm2);
		
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		System.out.println("Saving....");
		session.beginTransaction();
		
		session.save(account);
		session.save(account2);
		
		session.getTransaction().commit();		
		session.close();
		System.out.println("Saved");
		System.out.println("Fetching....");
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		Account ac = (Account) session.get(Account.class, 1);
		Account ac2 = (Account) session.get(Account.class, 2);
		
		System.out.println("********* Lazy Loading...****");
		System.out.println(ac.getAtm());
		
		Integer.parseInt("jb");
		
		System.out.println(ac);
		System.out.println(ac2);
		
		session.getTransaction().commit();
		session.close();
		System.out.println("Done..");
		
		sessionFactory.close();
	}
}