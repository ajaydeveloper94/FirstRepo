package flyaway.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import flyaway.dao.UserDAO;


@Entity
@Table(name="userTable")
public class UserTable extends UserDAO {
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="userId")
	int UserId;
	
	@Column(name="userName")
	String UserName;
	
	@Column(name="userEmail")
	String UserEmail;
	
	@Column(name="userPassword")
	String UserPassword;
	
	@Column(name="userPhone")
	String UserPhone;
	
	@Column(name="userAddress")
	String UserAddress;
	
	@Column(name="userType")
	String UserType;
	
	public UserTable() {
		
	}
	public UserTable(String userName, String userEmail, String userPassword, String userPhone, String userAddress,
			String userType) {
		
		UserAddress = userAddress;
		UserEmail = userEmail;
		UserName = userName;
		UserPassword = userPassword;
		UserPhone = userPhone;
		UserType = userType;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getUserAddress() {
		return UserAddress;
	}
	public void setUserAddress(String userAddress) {
		UserAddress = userAddress;
	}
	public String getUserEmail() {
		return UserEmail;
	}
	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserPassword() {
		return UserPassword;
	}
	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}
	public String getUserPhone() {
		return UserPhone;
	}
	public void setUserPhone(String userPhone) {
		UserPhone = userPhone;
	}
	public String getUserType() {
		return UserType;
	}
	public void setUserType(String userType) {
		UserType = userType;
	}
	
	
	
	
}
