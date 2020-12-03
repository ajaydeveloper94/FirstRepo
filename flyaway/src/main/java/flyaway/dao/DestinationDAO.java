package flyaway.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import flyaway.entities.AirlineTable;
import flyaway.entities.DestinationTable;
import flyaway.helperapp.HibernateUtil;

public class DestinationDAO {

	HibernateUtil hibernateutil = new HibernateUtil();
	Session session = hibernateutil.buildSessionFactory();
	
	public void addDestination(String DestinationName)
	{
		DestinationTable DT = new DestinationTable();
		DT.setDName(DestinationName);
		
		
		session.save(DT);
		session.getTransaction().commit();
        		
	}
	
	public List<DestinationTable> getDestinationByName()
	{
		Query query = session.createQuery("from DestinationTable");
		List<DestinationTable> list = query.list();
		   
		return list;
	}
}
