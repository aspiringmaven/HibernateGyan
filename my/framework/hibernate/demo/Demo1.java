package my.framework.hibernate.demo;

import my.framework.hibernate.beans.PersonDetails;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Demo1 {

	public static void main(String[] args) {
		
		PersonDetails person = new PersonDetails();
		person.setId(1);
		person.setName("Sumit");
		person.setAge(22);
		
		
//		@SuppressWarnings("deprecation")
//		SessionFactory sessionFactory =  new Configuration().configure().buildSessionFactory();		
		
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		builder.applySettings(configuration.getProperties());
		
		
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		Session session =  sessionFactory.openSession();
		
		try{
			session.beginTransaction();
			
//			session.save(person);
			PersonDetails personDetails = (PersonDetails) session.get(PersonDetails.class, 1);
			System.out.println(personDetails);
		
			
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}finally {
			session.close();
		}

	}

}
