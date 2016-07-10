package my.framework.hibernate.demo;

import my.framework.hibernate.mapping.bean.Customer;
import my.framework.hibernate.mapping.bean.CustomerDetails;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MappingDemo1 {

	public static void main(String[] args) {
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Customer customer = new Customer();
		CustomerDetails customerDetails = new CustomerDetails();
		
		customerDetails.setCompany("Accenture");
		customerDetails.setDesignation("Software Engineer");
		customerDetails.setIncome(12000);
		
		customer.setName("Gupta");
		customer.setCustomerDetails(customerDetails);		
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		session.save(customer);
		
		session.getTransaction().commit();
		session.close();
		
		
		session = null;
		session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		//Customer customer2 = (Customer) session.get(Customer.class, 1);
		
		Customer customer2=null;
		
		CustomerDetails customerDetails2 = (CustomerDetails) session.get(CustomerDetails.class, 2);
		customer2 = customerDetails2.getCustomer();
		
		System.out.println(customer2.getId());
		System.out.println(customer2.getName());
		System.out.println(customer2.getCustomerDetails().getCompany());
		System.out.println(customer2.getCustomerDetails().getDesignation());
		System.out.println(customer2.getCustomerDetails().getIncome());
		
		session.getTransaction().commit();
		
		session.close();
		
		sessionFactory.close();

	}

}
