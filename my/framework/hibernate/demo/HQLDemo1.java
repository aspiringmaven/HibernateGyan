package my.framework.hibernate.demo;



import java.sql.Date;



import my.framework.hibernate.mapping.pojo.Discipline;
import my.framework.hibernate.mapping.pojo.EBook;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HQLDemo1 {
	
	private static SessionFactory sessionFactory;
	
	static {
		Configuration configuration = new Configuration().configure();		
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();		
		builder.applySettings(configuration.getProperties());		
		sessionFactory = configuration.configure().buildSessionFactory(builder.build());
		}	

	public static void main(String[] args) {		
		Session session =  sessionFactory.openSession();
		
		EBook eBook = new EBook();
		eBook.setBookTitle("Java Do it by class");		
		eBook.setAuthor("Sumit Kawatra");
		eBook.setDiscipline(Discipline.PROGRAMMING);
		eBook.setBookISBN("6790436578");
		eBook.setPublishingYear(new Date(19700*10020));
		eBook.setCost(1500);
		
		session.beginTransaction();
		session.save(eBook);
		session.getTransaction().commit();		
		
		session.close();
		
		sessionFactory.close();
		
		
		
		
	}
}