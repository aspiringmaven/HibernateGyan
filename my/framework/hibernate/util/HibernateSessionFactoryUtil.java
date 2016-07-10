package my.framework.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {

	public static void main(String[] args) {
		
		//step 1 : Read configuration and convert to OOPS		
		Configuration configuration = new Configuration().configure();
		//step 2 : Builder design Pattern StandardServiceRegistryBuilder
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		//step 3 : Give Builder all CFG details using configuration object
		builder.applySettings(configuration.getProperties());
		//step 4 : build session factory Object and pass builder.build() object as param
		SessionFactory sessionFactory = configuration.configure().buildSessionFactory(builder.build());
		
		if(sessionFactory != null) {
			System.out.println("Craeted Succesfull!");
			sessionFactory.close();			
		} else {
			System.out.println("Not created!");
			
		}
	}
}