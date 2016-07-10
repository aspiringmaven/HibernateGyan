package my.framework.hibernate.demo;

import my.framework.hibernate.beans.FourWheeler;
import my.framework.hibernate.beans.TwoWheeler;
import my.framework.hibernate.beans.Vehicle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Demo4 {

	public static void main(String[] args) {
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		try{
			session.beginTransaction();
			Vehicle vehicle = new Vehicle();
			
			TwoWheeler twoWheeler =  new TwoWheeler();
			FourWheeler fourWheeler = new FourWheeler();
			
			vehicle.setVehicleName("Vehicle Name");
			twoWheeler.setVehicleName("BIKE");
			twoWheeler.setSteeringHandle("BIKE Ka Handle");
			fourWheeler.setVehicleName("CAR");
			fourWheeler.setSteeringWheel("Car ka steering");
			 
			session.save(vehicle);
			session.save(twoWheeler);
			session.save(fourWheeler);
			
			
			session.getTransaction().commit();
			System.out.println("Test");
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}