package isc.intake2.online_test.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Entity
@Table(name="questions")

public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
		
	@Column(name="content", 
			nullable = false, 
			length = 255 )
	private String queContent;
	
	@Column(name="isshuffle",
			nullable = false)
	private Boolean queIsshuffle;
	
	@Column(name = "score",
			nullable = false)
	private Float queScore;
	
	@Column(name="opt_column",
			nullable = false)
	private int queOpt_Column;
	
	@Column(name="isbank", 
			nullable = false)
	private Boolean queIsBank;
	
	@Column(name="level",
			nullable = false)
	private int queLevel;
	
	@Column(name="media",
			nullable=false,
			length = 50)
	private String queMedia;
	
	@Column(name="reference",
			nullable = false,
			length = 100)
	private String queReference;
	
	@Column(name="[order]",
			nullable = false)
	private int queOrder;
	
	
	public Question(long id, String queContent, Boolean queIsshuffle, Float queScore, int queOpt_Column,
			Boolean queIsBank, int queLevel, String queMedia, String queReference, int queOrder,
			AnswearType answearType) {
		super();
		this.id = id;
		this.queContent = queContent;
		this.queIsshuffle = queIsshuffle;
		this.queScore = queScore;
		this.queOpt_Column = queOpt_Column;
		this.queIsBank = queIsBank;
		this.queLevel = queLevel;
		this.queMedia = queMedia;
		this.queReference = queReference;
		this.queOrder = queOrder;
		this.answearType = answearType;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "question_answear_type_id", nullable = false)
	private AnswearType answearType;

	
	
	public AnswearType getAnswearType() {
		return answearType;
	}
	public void setAnswearType(AnswearType answearType) {
		this.answearType = answearType;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getQueContent() {
		return queContent;
	}
	public void setQueContent(String queContent) {
		this.queContent = queContent;
	}
	public Boolean getQueIsshuffle() {
		return queIsshuffle;
	}
	public void setQueIsshuffle(Boolean queIsshuffle) {
		this.queIsshuffle = queIsshuffle;
	}
	public Float getQueScore() {
		return queScore;
	}
	public void setQueScore(Float queScore) {
		this.queScore = queScore;
	}
	public int getQueOpt_Column() {
		return queOpt_Column;
	}
	public void setQueOpt_Column(int queOpt_Column) {
		this.queOpt_Column = queOpt_Column;
	}
	public Boolean getQueIsBank() {
		return queIsBank;
	}
	public void setQueIsBank(Boolean queIsBank) {
		this.queIsBank = queIsBank;
	}
	public int getQueLevel() {
		return queLevel;
	}
	public void setQueLevel(int queLevel) {
		this.queLevel = queLevel;
	}
	public String getQueMedia() {
		return queMedia;
	}
	public void setQueMedia(String queMedia) {
		this.queMedia = queMedia;
	}
	public String getQueReference() {
		return queReference;
	}
	public void setQueReference(String queReference) {
		this.queReference = queReference;
	}
	public int getQueOrder() {
		return queOrder;
	}
	public void setQueOrder(int queOrder) {
		this.queOrder = queOrder;
	}
	
	public Question() {
		super();
	}
	
	
	
}
