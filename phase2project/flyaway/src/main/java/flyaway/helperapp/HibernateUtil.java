package flyaway.helperapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public Session buildSessionFactory() {
		Session session = null;
		try {
			SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return session;
	}
}
