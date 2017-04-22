//Hong
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
import javax.validation.constraints.Size;

@Entity
@Table(name = "relative_privileges")
public class RelativePrivilege {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Size(min = 6, max = 100)
	@Column(name = "rel_name",
			length = 100,
			nullable = false)
	private String relName;
	
	@Size(min = 10, max = 50)
	@Column(name = "rel_url",
			length = 50,
			nullable = false)
	private String relUrl;
	
	@Size(max = 400)
	@Column(name = "rel_note",
			nullable = true,
			length = 400)
	private String relNote;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "privilege_id")
	private Privilege privilege;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRelName() {
		return relName;
	}

	public void setRelName(String relName) {
		this.relName = relName;
	}

	public String getRelUrl() {
		return relUrl;
	}

	public void setRelUrl(String relUrl) {
		this.relUrl = relUrl;
	}

	public String getRelNote() {
		return relNote;
	}

	public void setRelNote(String relNote) {
		this.relNote = relNote;
	}

	public Privilege getPrivilege() {
		return privilege;
	}

	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}

	public RelativePrivilege() {
		super();
	}

	public RelativePrivilege(long id, String relName, String relUrl, String relNote) {
		super();
		this.id = id;
		this.relName = relName;
		this.relUrl = relUrl;
		this.relNote = relNote;
	}

	public RelativePrivilege(long id, String relName, String relUrl, String relNote, Privilege privilege) {
		super();
		this.id = id;
		this.relName = relName;
		this.relUrl = relUrl;
		this.relNote = relNote;
		this.privilege = privilege;
	}
	
}
