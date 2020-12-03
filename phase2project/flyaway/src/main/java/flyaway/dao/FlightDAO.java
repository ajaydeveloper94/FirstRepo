package flyaway.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import flyaway.entities.AirlineTable;
import flyaway.entities.FlightTable;
import flyaway.helperapp.HibernateUtil;



public class FlightDAO {

	
	
	
	
	public void addFlight(String FlightName)
	{
		HibernateUtil hibernateutil = new HibernateUtil();
		Session session = hibernateutil.buildSessionFactory();
		FlightTable FT = new FlightTable();
		FT.setFName(FlightName);

		session.save(FT);
		session.getTransaction().commit();
        		
	}
	
	public List<FlightTable> getFlightByName()
	{
		HibernateUtil hibernateutil = new HibernateUtil();
		Session session = hibernateutil.buildSessionFactory();
		Query query = session.createQuery("from FlightTable");
		List<FlightTable> list = query.list();
		   
		return list;
	}
}
