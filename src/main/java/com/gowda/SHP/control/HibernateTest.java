package com.gowda.SHP.control;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.gowda.SHP.dto.Address;
import com.gowda.SHP.dto.User;

public class HibernateTest {
	public static void main(String[] args) {
		User user = new User();
		Address homeAddress = new Address();
		Address officeAddress = new Address();

		user.setUsername("First user");

		homeAddress.setDoorNo("#8");
		homeAddress.setStreet("1st");
		homeAddress.setCity("Blore");
		homeAddress.setState("Karnataka");

		officeAddress.setDoorNo("9");
		officeAddress.setStreet("2nd street");
		officeAddress.setCity("Mandya");
		officeAddress.setState("Karanataka");

		user.setHomeAddress(homeAddress);
		user.setOfficeAddress(officeAddress);

		User user1 = new User();
		Address homeAddress1 = new Address();
		Address officeAddress1 = new Address();

		user1.setUsername("Second user");

		homeAddress1.setDoorNo("#8");
		homeAddress1.setStreet("1st");
		homeAddress1.setCity("Blore");
		homeAddress1.setState("Karnataka");

		officeAddress1.setDoorNo("9");
		officeAddress1.setStreet("2nd street");
		officeAddress1.setCity("Mandya");
		officeAddress1.setState("Karanataka");

		user1.setHomeAddress(homeAddress1);
		user1.setOfficeAddress(officeAddress1);
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(user1);
		session.getTransaction().commit();
		session.close();
	}
}
