//Nguyên Ngô
package isc.intake2.online_test.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "question_formats")
public class QuestionFormat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "[order]",
			nullable = true)
	private byte quefOrder;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "part_id", nullable = false)
	private Part part;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "answer_type_id", nullable = false)
	private AnswerType answerType;

	public AnswerType getAnswerType() {
		return answerType;
	}

	public void setAnswerType(AnswerType answerType) {
		this.answerType = answerType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Boolean getQuefOrder() {
		return quefOrder;
	}

	public void setQuefOrder(Boolean quefOrder) {
		this.quefOrder = quefOrder;
	}

	public Part getPart() {
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
	}

	public QuestionFormat() {
		super();
	}

	public QuestionFormat(long id, Boolean quefOrder, Part part, AnswerType answerType) {
		super();
		this.id = id;
		this.quefOrder = quefOrder;
		this.part = part;
		this.answerType = answerType;
	}
	
}
