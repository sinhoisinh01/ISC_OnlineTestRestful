//Nguyên Ngô
package isc.intake2.online_test.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table(name = "parts")
public class Part {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Size(min = 6)
	@Column(name = "parId",
			unique = true,
			nullable = false,
			length = 10)
	private String parId;

	@Size(max=200)
	@Column(name = "name",
			nullable = true,
			length = 200)
	private String parName;
	
	@Size(max=250)
	@Column(name = "direction",
			nullable = true,
			length = 250)
	private String parDirection;
	
	@Column(name = "default_score")
	private int parDefault_score;
	
	@Column(name = "default_column",
			nullable = true)
	private Boolean parDefault_column;
	
	@Column(name = "default_level",
			nullable = true)
	private Boolean parDefault_level;
	
	@Column(name = "[order]")
	private int parOrder;
	
	@Size(max=400)
	@Column(name = "note",
			nullable = true,
			length = 400)
	private String parNote;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "subject_id", nullable = false)
	private Subject subject;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getParId() {
		return parId;
	}

	public void setParId(String parId) {
		this.parId = parId;
	}

	public String getParName() {
		return parName;
	}

	public void setParName(String parName) {
		this.parName = parName;
	}

	public String getParDirection() {
		return parDirection;
	}

	public void setParDirection(String parDirection) {
		this.parDirection = parDirection;
	}

	public int getParDefault_score() {
		return parDefault_score;
	}

	public void setParDefault_score(int parDefault_score) {
		this.parDefault_score = parDefault_score;
	}

	public Boolean getParDefault_column() {
		return parDefault_column;
	}

	public void setParDefault_column(Boolean parDefault_column) {
		this.parDefault_column = parDefault_column;
	}

	public Boolean getParDefault_level() {
		return parDefault_level;
	}

	public void setParDefault_level(Boolean parDefault_level) {
		this.parDefault_level = parDefault_level;
	}

	public int getParOrder() {
		return parOrder;
	}

	public void setParOrder(int parOrder) {
		this.parOrder = parOrder;
	}

	public String getParNote() {
		return parNote;
	}

	public void setParNote(String parNote) {
		this.parNote = parNote;
	}
	
	
	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	public Part() {
		super();
	}

	public Part(long id, String parId, String parName, String parDirection, int parDefault_score,
			Boolean parDefault_column, Boolean parDefault_level, int parOrder, String parNote, Subject subject) {
		super();
		this.id = id;
		this.parId = parId;
		this.parName = parName;
		this.parDirection = parDirection;
		this.parDefault_score = parDefault_score;
		this.parDefault_column = parDefault_column;
		this.parDefault_level = parDefault_level;
		this.parOrder = parOrder;
		this.parNote = parNote;
		this.subject = subject;
	}
	
}
