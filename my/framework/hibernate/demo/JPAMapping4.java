package my.framework.hibernate.demo;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.framework.hibernate.mapping.pojo.Department;
import my.framework.hibernate.mapping.pojo.Employee;

public class JPAMapping4 {

	public static void main(String[] args) {
		Set<Employee> employees = new HashSet<Employee>();
		
		Department department = new Department();
		
		department.setEmployees(employees);
		department.setLocation("Delhi NCR");
		department.setName("Computer Science");
		
		Set<Employee> employees2 = new HashSet<Employee>();
		Department department2 = new Department();
		department.setEmployees(employees2);
		department2.setLocation("Pakistan");
		department2.setName("Terrorist");
		
		
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		System.out.println("Saving....");
		session.beginTransaction();
		
		
		for(int i=1;i<=15;i++) {
			Employee emp = new Employee();
			Employee emp2 = new Employee();
			emp.setDesignation("SDE "+i);
			emp.setName("Java Developer "+i);
			emp.setSalary(1000*i);
			emp.setDept(department);
			emp2.setDept(department2);
			emp2.setSalary(500);
			emp2.setName("Tatte "+i);
			emp2.setDesignation("Sleeper Cell");
			session.save(emp);
			session.save(emp2);
			employees2.add(emp2);
			employees.add(emp);
		}
		

		
	
		session.save(department);
		session.save(department2);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();		
	}
}