//Nguyên Ngô
package isc.intake2.online_test.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "answer_types")
public class AnswerType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(max = 10)
	@Column(name = "anstId",
			unique = true,
			nullable = false,
			length = 10)
	private String anstId;

	@Size(max=50)
	@Column(name = "name",
			nullable = true,
			length = 50)
	private String anstName;
	
	@Column(name = "[order]")
	private int anstOrder;
	
	@Size(max=400)
	@Column(name = "sample",
			nullable = true,
			length = 400)
	private String anstSample;

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnstId() {
		return anstId;
	}

	public void setAnstId(String anstId) {
		this.anstId = anstId;
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
	
	
	public AnswerType(Long id, String anstId, String anstName, int anstOrder, String anstSample) {
		super();
		this.id = id;
		this.anstId = anstId;
		this.anstName = anstName;
		this.anstOrder = anstOrder;
		this.anstSample = anstSample;
	}

	public AnswerType() {
		super();
	}
}
