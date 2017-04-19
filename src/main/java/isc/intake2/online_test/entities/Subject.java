package isc.intake2.online_test.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "subject",
uniqueConstraints={@UniqueConstraint(columnNames = {"subId" , "subName"})})
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Size(min = 6, max = 10)
	@Column(name = "subId",
			nullable = false,
			length = 10)
	private String subId;
	
	@Size(min = 3, max = 50)
	@Column(name = "subName",
			nullable = false,
			length = 50)
	private String subName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSubId() {
		return subId;
	}

	public void setSubId(String subId) {
		this.subId = subId;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public Subject() {
		super();
	}

	public Subject(long id, String subId, String subName) {
		super();
		this.id = id;
		this.subId = subId;
		this.subName = subName;
	}
}
