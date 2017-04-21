package isc.intake2.online_test.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "user_types")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name",
			length = 100,
			nullable = true)
	private String userTypeName;
	
	@Column(name = "is_admin")
	private Boolean userTypeIsAdmin;
	
	@Column(name = "note",
			length = 400,
			nullable = true)
	private String userTypeNote;
	
	@JsonBackReference
	@OneToMany(mappedBy = "userType",fetch = FetchType.LAZY)
	private Set<User> users = new HashSet<User>(0);
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserTypeName() {
		return userTypeName;
	}

	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}

	public Boolean getUserTypeIsAdmin() {
		return userTypeIsAdmin;
	}

	public void setUserTypeIsAdmin(Boolean userTypeIsAdmin) {
		this.userTypeIsAdmin = userTypeIsAdmin;
	}

	public String getUserTypeNote() {
		return userTypeNote;
	}

	public void setUserTypeNote(String userTypeNote) {
		this.userTypeNote = userTypeNote;
	}
	
	
	public Set<User> getUsers(){
		return this.users;
	}
	
	public void setUsers(Set<User> users){
		this.users = users;
	}
}
