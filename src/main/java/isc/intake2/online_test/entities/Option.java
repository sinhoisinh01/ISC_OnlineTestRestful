package isc.intake2.online_test.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "options")
public class Option {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="content",
			nullable = false,
			length = 255)
	private String optContent;
	
	@Column(name="isCorrect",
			nullable = false)
	private Boolean optIsCorrect;
	
	@Column(name="[order]",
			nullable = false)
	private int optOrder;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "option_question_id", nullable = false)
	private Question question;
	
	
	
	public Option(long id, String optContent, Boolean optIsCorrect, int optOrder, Question question) {
		super();
		this.id = id;
		this.optContent = optContent;
		this.optIsCorrect = optIsCorrect;
		this.optOrder = optOrder;
		this.question = question;
	}


	public Question getQuestion() {
		return question;
	}


	public void setQuestion(Question question) {
		this.question = question;
	}


	public long getId() {
		return id;
	}
	
	
	public void setId(long id) {
		this.id = id;
	}
	public String getOptContent() {
		return optContent;
	}
	public void setOptContent(String optContent) {
		this.optContent = optContent;
	}
	public Boolean getOptIsCorrect() {
		return optIsCorrect;
	}
	public void setOptIsCorrect(Boolean optIsCorrect) {
		this.optIsCorrect = optIsCorrect;
	}
	public int getOptOrder() {
		return optOrder;
	}
	public void setOptOrder(int optOrder) {
		this.optOrder = optOrder;
	}
	public Option(long id, String optContent, Boolean optIsCorrect, int optOrder) {
		super();
		this.id = id;
		this.optContent = optContent;
		this.optIsCorrect = optIsCorrect;
		this.optOrder = optOrder;
	}
	public Option() {
		super();
	}
	
	
	
}
