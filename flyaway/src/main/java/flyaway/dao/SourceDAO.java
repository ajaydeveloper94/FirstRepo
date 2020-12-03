package flyaway.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;


import flyaway.entities.SourceTable;
import flyaway.helperapp.HibernateUtil;

public class SourceDAO {

	
	
	public void addSource(String SourceName)
	{
		HibernateUtil hibernateutil = new HibernateUtil();
		Session session = hibernateutil.buildSessionFactory();
		SourceTable ST = new SourceTable();
		ST.setSName(SourceName);
		
		session.save(ST);
		session.getTransaction().commit();
        		
	}
	
	
	public List<SourceTable> getSourceByName()
	{
		HibernateUtil hibernateutil = new HibernateUtil();
		Session session = hibernateutil.buildSessionFactory();
		Query query = session.createQuery("from SourceTable");
		List<SourceTable> list = query.list();
		return list;
	}
}
