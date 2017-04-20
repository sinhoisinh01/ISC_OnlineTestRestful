package isc.intake2.online_test.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "privileges")
public class Privilege {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Size(min = 6, max = 200)
	@Column(name = "pri_name",
			nullable = false,
			length = 200)
	private String priName;
	
	@Size(min = 6, max = 100)
	@Column(name = "pri_url",
			nullable = false,
			length = 100)
	private String priUrl;
	
	@Column(name = "pri_parent",
			nullable = false)
	private Integer priParent;
	
	@Column(name = "pri_order")
	private Integer priOrder;
	
	@Size(min = 0, max = 400)
	@Column(name = "pri_note",
			length = 400)
	private String priNote;
}
