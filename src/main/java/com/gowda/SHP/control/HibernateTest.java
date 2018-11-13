package com.gowda.SHP.control;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.gowda.SHP.dto.Address;
import com.gowda.SHP.dto.User;

public class HibernateTest {
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		User user[] = new User[5];
		for (int i = 0; i < 5; i++) {
			user[i] = new User();
			user[i].setUsername("User " + i);
			Address address[] = new Address[5];
			for (int j = 0; j < address.length; j++) {
				address[j] = new Address();
				address[j].setDoorNo("#00" + i + j);
				address[j].setStreet("street 00 " + i + j);
				address[j].setCity("city 00" + i + j);
				address[j].setState("state " + i + j);
				user[i].getListOfAddress().add(address[j]);
			}
			session.save(user[i]);
		}
		session.getTransaction().commit();
		session.close();
	}
}
