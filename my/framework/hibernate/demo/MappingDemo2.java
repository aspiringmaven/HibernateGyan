package my.framework.hibernate.demo;

import java.util.ArrayList;
import java.util.List;

import my.framework.hibernate.mapping.bean.School;
import my.framework.hibernate.mapping.bean.Teacher;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MappingDemo2 {

	public static void main(String[] args) {
		
	School school = new School();
		
		List<Teacher> teachers = new ArrayList<Teacher>();		
		
		for( int i =1 ; i<=10; i++) {
			Teacher  t = new Teacher();
			t.setName("Teacher "+i);
			t.setSchool(school);
			teachers.add(t);			
		}		
		
		school.setTeachers(teachers);
		school.setName("Tagore International School");
		
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session  session =  sessionFactory.openSession();		
		session.beginTransaction();
		
		session.save(school);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
