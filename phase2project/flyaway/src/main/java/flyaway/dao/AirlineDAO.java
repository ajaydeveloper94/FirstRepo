package flyaway.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import flyaway.entities.AirlineTable;
import flyaway.helperapp.HibernateUtil;




public class AirlineDAO {

	
	//Save to DB
	public void addAirline(String AirlineName)
	{
		HibernateUtil hibernateutil = new HibernateUtil();
		Session session = hibernateutil.buildSessionFactory();
		AirlineTable AT = new AirlineTable();
		AT.setAName(AirlineName);
		
		session.save(AT);
		session.getTransaction().commit();
        		
	}
	
	
	
	
	public List<AirlineTable> getAirlineByName()
	{
		HibernateUtil hibernateutil = new HibernateUtil();
		Session session = hibernateutil.buildSessionFactory();
		Query query = session.createQuery("from AirlineTable");
		List<AirlineTable> list = query.list();
		   
		return list;
	}
	
}
