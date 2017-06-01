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

import com.beust.jcommander.internal.Nullable;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "subjects")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
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
	
	public Subject(long id, Long subId, String subName) {
		super();
		this.id = id;
		this.subName = subName;
	}

	public Subject(long id, Long subId, String subName, Subject parentSub, Collection<Subject> childSubs) {
		super();
		this.id = id;
		this.subName = subName;
		this.parentSub = parentSub;
		this.childSubs = childSubs;
	}


}
