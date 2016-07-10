package my.framework.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.framework.hibernate.beans.Module;
import my.framework.hibernate.beans.Project;
import my.framework.hibernate.beans.Task;

public class Demo4Revised {
	
	public static void main(String[] args) {
		
		Project project = new Project();
		Module module = new Module();
		Task task = new Task();
		
		project.setProjectName("Java Tutorials");
		
		module.setProjectName("Multithreding");
		module.setModuleName("Executor framework");
		
		task.setProjectName("JavaVids");
		task.setModuleName("collection");
		task.setTaskName("concurrent collection");
		
		
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(project);
		session.save(module);
		session.save(task);
		
		session.getTransaction().commit();		
		session.close();
		sessionFactory.close();		
	}
}