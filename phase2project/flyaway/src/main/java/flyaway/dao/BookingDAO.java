package flyaway.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.query.Query;

import flyaway.entities.BookingTable;
import flyaway.helperapp.HibernateUtil;

public class BookingDAO {

	HibernateUtil hibernateutil = new HibernateUtil();
	Session session = hibernateutil.buildSessionFactory();
	
	public void createBooking(String AirlineName, String FlightName, String Date, String Price, String SourceName, String DestinationName, String UserName,String NumberOfPersons, String TotalPrice)
	{
		BookingTable BT = new BookingTable();
		BT.setAName(AirlineName);
		BT.setFName(FlightName);
		BT.setDate(Date);
		BT.setPrice(Price);
		BT.setSName(SourceName);
		BT.setDName(DestinationName);
		BT.setUName(UserName);
		BT.setNumberOfPersons(NumberOfPersons);
		BT.setTotalPrice(TotalPrice);
		
		session.save(BT);
		session.getTransaction().commit();
		
        		
	}
	
	public List<BookingTable> getBookingDetails()
	{
		Query query = session.createQuery("from BookingTable");
		List<BookingTable> list = query.list();
		   
		return list;
	}
	
	public List<BookingTable> getBookingId()
	{
		Query query = session.createQuery("from BookingTable order by BTId DESC" );
		query.setMaxResults(1);
		List<BookingTable> list = query.list();
		return list;
		
	}
}
