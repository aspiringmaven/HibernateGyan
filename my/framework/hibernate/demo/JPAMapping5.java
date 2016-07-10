package my.framework.hibernate.demo;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.framework.hibernate.mapping.pojo.Engineer;
import my.framework.hibernate.mapping.pojo.Skill;

public class JPAMapping5 {

	public static void main(String[] args) {
		Skill java = new Skill();
		Skill c = new Skill();
		Skill cpp = new Skill();
		Skill php = new Skill();
		Skill sql = new Skill();

		java.setSkillName("Java");
		c.setSkillName("C");
		cpp.setSkillName("CPP");
		php.setSkillName("PHP");
		sql.setSkillName("SQL");

		Engineer sumit = new Engineer();
		Engineer rahul = new Engineer();
		Engineer punu = new Engineer();

		sumit.setName("Sumit");
		rahul.setName("Rahul");
		punu.setName("Punu");

		ArrayList<Skill> skills = new ArrayList<Skill>();

		skills.add(sql);
		skills.add(java);
		skills.add(c);

		sumit.setSkills(skills);

		skills = new ArrayList<Skill>();

		skills.add(sql);
		skills.add(php);

		punu.setSkills(skills);

		skills = new ArrayList<Skill>();
		skills.add(php);

		rahul.setSkills(skills);

		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();
		System.out.println("Saving....");
		session.beginTransaction();

		session.save(sumit);
		session.save(rahul);
		session.save(punu);

		session.getTransaction().commit();
		session.close();

		System.out.println("Done!!");
		sessionFactory.close();

	}

}
