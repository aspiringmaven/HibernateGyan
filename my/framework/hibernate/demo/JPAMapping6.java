package my.framework.hibernate.demo;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.framework.hibernate.mapping.pojo.Author;
import my.framework.hibernate.mapping.pojo.Book;

public class JPAMapping6 {
	
	public static void main(String[] args) {
		Book book1 = new Book(1, "Pro Java", new ArrayList<Author>());
		Book book2 = new Book(2, "Java Spring ", new ArrayList<Author>());
		Book book3 = new Book(3, "Java HIbernate ", new ArrayList<Author>());
		Book book4 = new Book(4, "Database Oracle", new ArrayList<Author>());
		Book book5 = new Book(5, "Database Microsoft", new ArrayList<Author>());
		Book book6 = new Book(6, "Algorithms", new ArrayList<Author>());
		
		Author author1 = new Author(11, "Sumit Kawatra",new ArrayList<Book>());
		Author author2 = new Author(22, "Puneet Noida",new ArrayList<Book>());
		Author author3 = new Author(33, "Prakhar Srivastva",new ArrayList<Book>());
		
		author1.getBook().add(book1);
		author1.getBook().add(book2);
		author1.getBook().add(book3);
		author1.getBook().add(book6);
		
		author2.getBook().add(book3);
		author2.getBook().add(book4);
		author2.getBook().add(book5);
		
		
		author3.getBook().add(book6);
		author3.getBook().add(book2);
		author3.getBook().add(book1);
		
		
		book1.getAuthor().add(author1);
		book1.getAuthor().add(author3);
		
		book2.getAuthor().add(author1);
		book2.getAuthor().add(author3);
		
		book3.getAuthor().add(author1);
		book3.getAuthor().add(author2);
		
		book4.getAuthor().add(author2);
		
		book5.getAuthor().add(author2);
		
		book6.getAuthor().add(author1);
		book6.getAuthor().add(author3);
		

		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();
		System.out.println("Saving....");
		session.beginTransaction();
		
		session.save(book1);
		session.save(book2);
		session.save(book3);
		session.save(book4);
		session.save(book5);
		session.save(book6);
		
		session.getTransaction().commit();
		System.out.println("Closed");
		sessionFactory.close();
		
	}

}
