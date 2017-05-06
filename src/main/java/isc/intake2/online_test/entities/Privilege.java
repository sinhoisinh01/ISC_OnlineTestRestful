//Hong
package isc.intake2.online_test.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "privileges")
public class Privilege {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Size(min = 6, max = 200)
	@Column(name = "name",
			nullable = false,
			length = 200)
	private String priName;
	
	@Size(min = 6, max = 100)
	@Column(name = "url",
			nullable = false,
			length = 100)
	private String priUrl;
	
	@Column(name = "parent",
			nullable = false)
	private Integer priParent;
	
	@Column(name = "[order]")
	private Integer priOrder;
	
	@Size(min = 0, max = 400)
	@Column(name = "note",
			length = 400)
	private String priNote;
	
	@OneToMany(mappedBy="privilege", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Collection<Permission> permissions;
	
	@OneToMany(mappedBy="privilege", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Collection<RelativePrivilege> relativePriveleges;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPriName() {
		return priName;
	}

	public void setPriName(String priName) {
		this.priName = priName;
	}

	public String getPriUrl() {
		return priUrl;
	}

	public void setPriUrl(String priUrl) {
		this.priUrl = priUrl;
	}

	public Integer getPriParent() {
		return priParent;
	}

	public void setPriParent(Integer priParent) {
		this.priParent = priParent;
	}

	public Integer getPriOrder() {
		return priOrder;
	}

	public void setPriOrder(Integer priOrder) {
		this.priOrder = priOrder;
	}

	public String getPriNote() {
		return priNote;
	}

	public void setPriNote(String priNote) {
		this.priNote = priNote;
	}

	public Collection<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Collection<Permission> permissions) {
		this.permissions = permissions;
	}

	public Collection<RelativePrivilege> getRelativePriveleges() {
		return relativePriveleges;
	}

	public void setRelativePriveleges(Collection<RelativePrivilege> relativePriveleges) {
		this.relativePriveleges = relativePriveleges;
	}

	public Privilege() {
		super();
	}

	public Privilege(long id, String priName, String priUrl, Integer priParent, Integer priOrder, String priNote) {
		super();
		this.id = id;
		this.priName = priName;
		this.priUrl = priUrl;
		this.priParent = priParent;
		this.priOrder = priOrder;
		this.priNote = priNote;
	}

	public Privilege(long id, String priName, String priUrl, Integer priParent, Integer priOrder, String priNote,
			Collection<Permission> permissions) {
		super();
		this.id = id;
		this.priName = priName;
		this.priUrl = priUrl;
		this.priParent = priParent;
		this.priOrder = priOrder;
		this.priNote = priNote;
		this.permissions = permissions;
	}

	public Privilege(long id, String priName, String priUrl, Integer priParent, Integer priOrder, String priNote,
			Collection<Permission> permissions, Collection<RelativePrivilege> relativePriveleges) {
		super();
		this.id = id;
		this.priName = priName;
		this.priUrl = priUrl;
		this.priParent = priParent;
		this.priOrder = priOrder;
		this.priNote = priNote;
		this.permissions = permissions;
		this.relativePriveleges = relativePriveleges;
	}
	
	
}
