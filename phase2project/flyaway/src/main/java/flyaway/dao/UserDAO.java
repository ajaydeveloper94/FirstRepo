package flyaway.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;


import flyaway.entities.UserTable;
import flyaway.helperapp.HibernateUtil;

public class UserDAO {

	
	
	
	public void addUser(String userName, String userEmail, String userPassword, String userPhone, String userAddress,
			String userType)
	{
		try {
		
		HibernateUtil hibernateutil = new HibernateUtil();
		Session session = hibernateutil.buildSessionFactory();
				
		UserTable UT = new UserTable();
        
		
		
		UT.setUserName(userName); 
		UT.setUserPassword(userPassword);
		UT.setUserEmail(userEmail); 
		UT.setUserAddress(userAddress);
		UT.setUserPhone(userPhone); 
		UT.setUserType(userType);
		
		
		session.save(UT);
		session.getTransaction().commit();

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public List<UserTable> getUserByName()
	{
		HibernateUtil hibernateutil = new HibernateUtil();
		Session session = hibernateutil.buildSessionFactory();
		
		Query query = session.createQuery("from UserTable");
		List<UserTable> list = query.list();
		   
		return list;
	}
}
