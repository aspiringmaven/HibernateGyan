package my.framework.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import my.framework.hibernate.beans.FBUser;

public class FBUserDemo {

	public static void main(String[] args) {
		FBUser sumit = new FBUser("sumit");
		FBUser rahul = new FBUser("rahul");
		FBUser punu = new FBUser("puneet");
		
		for(int i =1;i<=10;i++) {
			sumit.getFriendList().add(new FBUser("FB User"+1));
			rahul.getFriendList().add(new FBUser("FB User"+(5+i)));
			punu.getFriendList().add(new FBUser("FB User"+(8+i)));
		}
		
		Configuration configuration =  new Configuration().configure();
		
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		builder.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		session.save(rahul);
		session.save(sumit);
		session.save(punu);
		
		session.getTransaction().commit();
		
		session.close();
		sessionFactory.close();
	}

}
