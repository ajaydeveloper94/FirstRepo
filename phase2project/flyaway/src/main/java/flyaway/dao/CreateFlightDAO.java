package flyaway.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.query.Query;


import flyaway.entities.CreateFlightTable;
import flyaway.helperapp.HibernateUtil;

public class CreateFlightDAO {

	
	
	public void createFlight(String AirlineName, String FlightName, String Date, String SourceName, String DestinationName, String Price)
	{
		HibernateUtil hibernateutil = new HibernateUtil();
		Session session = hibernateutil.buildSessionFactory();
		
		CreateFlightTable CFT = new CreateFlightTable();
		CFT.setACFName(AirlineName);
		CFT.setFCFName(FlightName);
		CFT.setDate(Date);
		CFT.setSCFName(SourceName);
		CFT.setDCFName(DestinationName);
		CFT.setPrice(Price);
		
		session.save(CFT);
		session.getTransaction().commit();
        		
	}
	
	public List<CreateFlightTable> getCreateFlightList()
	{
		HibernateUtil hibernateutil = new HibernateUtil();
		Session session = hibernateutil.buildSessionFactory();
		
		Query query = session.createQuery("from CreateFlightTable");
		List<CreateFlightTable> list = query.list();
		   
		return list;
	}
}
