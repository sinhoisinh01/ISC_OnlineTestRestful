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

@Entity
@Table(name = "permissions")
public class Permission {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "per_is_read_only",
			columnDefinition="tinyint(1) default 0")
	private boolean perIsReadOnly;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "privilege_id")
	private Privilege privilege;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isPerIsReadOnly() {
		return perIsReadOnly;
	}

	public void setPerIsReadOnly(boolean perIsReadOnly) {
		this.perIsReadOnly = perIsReadOnly;
	}

	public Privilege getPrivilege() {
		return privilege;
	}

	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}

	public Permission() {
		super();
	}

	public Permission(long id, boolean perIsReadOnly) {
		super();
		this.id = id;
		this.perIsReadOnly = perIsReadOnly;
	}

	public Permission(long id, boolean perIsReadOnly, Privilege privilege) {
		super();
		this.id = id;
		this.perIsReadOnly = perIsReadOnly;
		this.privilege = privilege;
	}
	
}
