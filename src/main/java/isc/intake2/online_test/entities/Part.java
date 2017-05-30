//Nguyên Ngô
package isc.intake2.online_test.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	private float parDefault_score;
	
	@Column(name = "default_column",
			nullable = true)
	private byte parDefault_column;
	
	@Column(name = "default_level",
			nullable = true)
	private byte parDefault_level;
	
	@Column(name = "[order]",
			nullable = true)
	private int parOrder;
	
	public Part(long id, String parId, String parName, String parDirection, float parDefault_score,
			byte parDefault_column, byte parDefault_level, int parOrder, String parNote, Subject subject,
			Collection<ImageGallery> imageGallery) {
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
		this.imageGallery = imageGallery;
	}

	@Size(max=400)
	@Column(name = "note",
			nullable = true,
			length = 400)
	private String parNote;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "subject_id", nullable = false, updatable = false)
	private Subject subject;

	@OneToMany(mappedBy="part", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	private Collection<ImageGallery> imageGallery;
	
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

	public float getParDefault_score() {
		return parDefault_score;
	}

	public void setParDefault_score(float parDefault_score) {
		this.parDefault_score = parDefault_score;
	}

	public byte getParDefault_column() {
		return parDefault_column;
	}

	public void setParDefault_column(byte parDefault_column) {
		this.parDefault_column = parDefault_column;
	}

	public byte getParDefault_level() {
		return parDefault_level;
	}

	public void setParDefault_level(byte parDefault_level) {
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

	public Collection<ImageGallery> getImageGallery() {
		return imageGallery;
	}

	public void setImageGallery(Collection<ImageGallery> imageGallery) {
		this.imageGallery = imageGallery;
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

	public Part(long id, String parId, String parName, String parDirection, float parDefault_score,
			byte parDefault_column, byte parDefault_level, int parOrder, String parNote, Subject subject) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + parDefault_column;
		result = prime * result + parDefault_level;
		result = prime * result + Float.floatToIntBits(parDefault_score);
		result = prime * result + ((parDirection == null) ? 0 : parDirection.hashCode());
		result = prime * result + ((parId == null) ? 0 : parId.hashCode());
		result = prime * result + ((parName == null) ? 0 : parName.hashCode());
		result = prime * result + ((parNote == null) ? 0 : parNote.hashCode());
		result = prime * result + parOrder;
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Part other = (Part) obj;
		if (id != other.id)
			return false;
		if (parDefault_column != other.parDefault_column)
			return false;
		if (parDefault_level != other.parDefault_level)
			return false;
		if (Float.floatToIntBits(parDefault_score) != Float.floatToIntBits(other.parDefault_score))
			return false;
		if (parDirection == null) {
			if (other.parDirection != null)
				return false;
		} else if (!parDirection.equals(other.parDirection))
			return false;
		if (parId == null) {
			if (other.parId != null)
				return false;
		} else if (!parId.equals(other.parId))
			return false;
		if (parName == null) {
			if (other.parName != null)
				return false;
		} else if (!parName.equals(other.parName))
			return false;
		if (parNote == null) {
			if (other.parNote != null)
				return false;
		} else if (!parNote.equals(other.parNote))
			return false;
		if (parOrder != other.parOrder)
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Part [id=" + id + ", parId=" + parId + ", parName=" + parName + ", parDirection=" + parDirection
				+ ", parDefault_score=" + parDefault_score + ", parDefault_column=" + parDefault_column
				+ ", parDefault_level=" + parDefault_level + ", parOrder=" + parOrder + ", parNote=" + parNote
				+ ", subject=" + subject + "]";
	}

		
}

	