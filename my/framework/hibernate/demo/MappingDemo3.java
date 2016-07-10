package my.framework.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.framework.hibernate.mapping.bean.Delegate;
import my.framework.hibernate.mapping.bean.Event;

public class MappingDemo3 {
	
	public static void main(String[] args) {
		
		Delegate [] delegates = new Delegate[5];
		
		for(int i=0;i<5;i++){
			
			delegates[i] = new Delegate();
		}
		
		delegates[0].setDelegateName("Sumit_Kawatra");
		delegates[1].setDelegateName("Rahul_Bhayana");
		delegates[2].setDelegateName("Dheeraj_Dhall");
		delegates[3].setDelegateName("Sagar_Katyal");
		
		Event javaEvent = new Event();
		javaEvent.setEventName("javaEvent");
		Event dbEvent = new Event();
		dbEvent.setEventName("dbEvent");
		Event voiceEvent = new Event();
		voiceEvent.setEventName("voiceEvent");
		Event netWorkingEvent = new Event();
		netWorkingEvent.setEventName("netWorkingEvent");
		
		// event to delicate
		javaEvent.getDelegates().add(delegates[0]);
		javaEvent.getDelegates().add(delegates[2]);
		
		dbEvent.getDelegates().add(delegates[0]);
		dbEvent.getDelegates().add(delegates[1]);	
		
		voiceEvent.getDelegates().add(delegates[3]);
		
		netWorkingEvent.getDelegates().add(delegates[0]);
		netWorkingEvent.getDelegates().add(delegates[1]);
		netWorkingEvent.getDelegates().add(delegates[2]);
		
//		//delicate to event
//		
//		delegates[0].getEvents().add(javaEvent);
//		delegates[0].getEvents().add(dbEvent);
//		delegates[0].getEvents().add(netWorkingEvent);
//		
//		
//		delegates[1].getEvents().add(dbEvent);
//		delegates[1].getEvents().add(netWorkingEvent);
//		
//		delegates[2].getEvents().add(javaEvent);
//		delegates[2].getEvents().add(netWorkingEvent);
//		
//		delegates[3].getEvents().add(voiceEvent);		
		
		
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		session.save(delegates[0]);
		session.save(delegates[1]);
		session.save(delegates[2]);
		session.save(delegates[3]);
		
		session.save(javaEvent);
		session.save(dbEvent);
		session.save(netWorkingEvent);
		session.save(voiceEvent);
		
		session.flush();
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		
		
		
	}
}