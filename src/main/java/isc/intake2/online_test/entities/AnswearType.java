package isc.intake2.online_test.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="answear_types")
public class AnswearType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="anstID",
			unique = true,
			nullable = false,
			length = 10)
	private String anstID;
	
	@Column(name="name",
			nullable = false,
			length = 50)
	private String anstName;
	
	@Column(name="[order]",
			nullable = false)
	private int anstOrder;
	
	@Column(name = "sample",
			nullable = false,
			length = 255)
	private String anstSample;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAnstID() {
		return anstID;
	}
	public void setAnstID(String anstID) {
		this.anstID = anstID;
	}
	public String getAnstName() {
		return anstName;
	}
	public void setAnstName(String anstName) {
		this.anstName = anstName;
	}
	public int getAnstOrder() {
		return anstOrder;
	}
	public void setAnstOrder(int anstOrder) {
		this.anstOrder = anstOrder;
	}
	public String getAnstSample() {
		return anstSample;
	}
	public void setAnstSample(String anstSample) {
		this.anstSample = anstSample;
	}
	public AnswearType(long id, String anstID, String anstName, int anstOrder, String anstSample) {
		super();
		this.id = id;
		this.anstID = anstID;
		this.anstName = anstName;
		this.anstOrder = anstOrder;
		this.anstSample = anstSample;
	}
	public AnswearType() {
		super();
	}
	
	
	
}
