//Hong
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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "subjects")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Size(max = 20)
	@Column(name = "sub_id",
			nullable = true,
			length = 20)
	private String subId;
	
	@Size(min = 3, max = 100)
	@Column(name = "name",
			nullable = false,
			length = 100)
	private String subName;
	
	/*--------------------Recursive relation mapping----------------*/
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name = "sub_id", insertable = false, updatable = false)
	private Subject parentSub;
	
	@OneToMany(mappedBy="parentSub", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	private Collection<Subject> childSubs;
	
	/*End------------------Recursive relation mapping----------------*/
	
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

	public Subject getParentSub() {
		return parentSub;
	}

	public void setParentSub(Subject parentSub) {
		this.parentSub = parentSub;
	}

	public Collection<Subject> getChildSubs() {
		return childSubs;
	}

	public void setChildSubs(Collection<Subject> childSubs) {
		this.childSubs = childSubs;
	}

	/*-------------------Contructor---------------*/
	public Subject() {
		super();
	}
	
	public Subject(long id, String subId, String subName) {
		super();
		this.id = id;
		this.subId = subId;
		this.subName = subName;
	}

	public Subject(long id, String subId, String subName, Subject parentSub, Collection<Subject> childSubs) {
		super();
		this.id = id;
		this.subId = subId;
		this.subName = subName;
		this.parentSub = parentSub;
		this.childSubs = childSubs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((subId == null) ? 0 : subId.hashCode());
		result = prime * result + ((subName == null) ? 0 : subName.hashCode());
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
		Subject other = (Subject) obj;
		if (id != other.id)
			return false;
		if (subId == null) {
			if (other.subId != null)
				return false;
		} else if (!subId.equals(other.subId))
			return false;
		if (subName == null) {
			if (other.subName != null)
				return false;
		} else if (!subName.equals(other.subName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", subId=" + subId + ", subName=" + subName + "]";
	}

}
