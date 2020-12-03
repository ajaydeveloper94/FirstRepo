package flyaway.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bookingtable")
public class BookingTable {
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bookingTableId")
	int BTId;
	
	@Column(name="airlineName")
	String AName;
	
	@Column(name="flightName")
	String FName;
	
	@Column(name="Date")
	String Date;
	
	@Column(name="Price")
	String Price;
	
	@Column(name="sourceName")
	String SName;
	
	@Column(name="destinationName")
	String DName;
	
	@Column(name="userName")
	String UName;
	
	@Column(name="NumberOfPersons")
	String NumberOfPersons;
	
	@Column(name="totalPrice")
	String totalPrice;
	
	public BookingTable() {
		
	}
    
	
	public String getNumberOfPersons() {
		return NumberOfPersons;
	}


	public void setNumberOfPersons(String numberOfPersons) {
		NumberOfPersons = numberOfPersons;
	}


	public String getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}


	public BookingTable(String aName, String fName, String date, String price, String sName, String dName, String uName,
			String numberOfPersons, String totalPrice) {
		super();
		AName = aName;
		FName = fName;
		Date = date;
		Price = price;
		SName = sName;
		DName = dName;
		UName = uName;
		NumberOfPersons = numberOfPersons;
		this.totalPrice = totalPrice;
	}


	public int getBTId() {
		return BTId;
	}
	public void setBTId(int bTId) {
		BTId = bTId;
	}
	public String getAName() {
		return AName;
	}
	public void setAName(String aName) {
		AName = aName;
	}
	public String getFName() {
		return FName;
	}
	public void setFName(String fName) {
		FName = fName;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public String getSName() {
		return SName;
	}
	public void setSName(String sName) {
		SName = sName;
	}
	public String getDName() {
		return DName;
	}
	public void setDName(String dName) {
		DName = dName;
	}
	public String getUName() {
		return UName;
	}
	public void setUName(String uName) {
		UName = uName;
	}
	
	
}
