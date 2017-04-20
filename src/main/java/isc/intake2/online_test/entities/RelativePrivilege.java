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
	@JoinColumn(name = "id", insertable = false, updatable = false)
	private Privilege privilege;
}
