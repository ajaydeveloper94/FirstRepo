package flyaway.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="airlinetable")
public class AirlineTable {
  
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="airlineId")
	int AId;
	
	@Column(name="airlineName")
	String AName;
	
	public AirlineTable() {
		
	}
	public AirlineTable(String aName) {
		
		AName = aName;
	}
	public int getAId() {
		return AId;
	}
	public void setAId(int aId) {
		AId = aId;
	}
	public String getAName() {
		return AName;
	}
	public void setAName(String aName) {
		AName = aName;
	}
	
	
}
