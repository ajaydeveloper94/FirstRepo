package flyaway.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="createflighttable")
public class CreateFlightTable {
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="createFlightId")
	int CFId;
	
	@Column(name="airlineName")
	String ACFName;
	
	@Column(name="destinationName")
	String DCFName;
	
	@Column(name="Date")
	String Date;
	
	@Column(name="flightName")
	String FCFName;
	
	@Column(name="sourceName")
	String SCFName;
	
	@Column(name="Price")
	String Price;
	
	public CreateFlightTable() {
		
	}
	public CreateFlightTable(String aCFName, String fCFName, String date, String sCFName, String dCFName,
			String price) {
		
		ACFName = aCFName;
		DCFName = dCFName;
		Date = date;
		FCFName = fCFName;
		SCFName = sCFName;
		Price = price;
	}
	public int getCFId() {
		return CFId;
	}
	public void setCFId(int cFId) {
		CFId = cFId;
	}
	public String getACFName() {
		return ACFName;
	}
	public void setACFName(String aCFName) {
		ACFName = aCFName;
	}
	public String getDCFName() {
		return DCFName;
	}
	public void setDCFName(String dFCName) {
		DCFName = dFCName;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getFCFName() {
		return FCFName;
	}
	public void setFCFName(String fCFName) {
		FCFName = fCFName;
	}
	public String getSCFName() {
		return SCFName;
	}
	public void setSCFName(String sCFName) {
		SCFName = sCFName;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	
	
	
	
	
}
