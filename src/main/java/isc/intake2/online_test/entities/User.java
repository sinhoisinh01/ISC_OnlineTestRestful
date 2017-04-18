package isc.intake2.online_test.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Size(min = 3, max = 50)
	@Column(name = "user_name",
			unique = true,
			nullable = false,
			length = 50)
	private String userName;
	
	@Size(min = 6, max = 50)
	@Column(name = "enc_password",
			nullable = false,
			length = 50)
	private String userEncPassword;
	
	@Column(columnDefinition="nvarchar(50)",
			name = "first_name",
			nullable = true)
	private String userFirstName;
	
	@Column(columnDefinition="nvarchar(100)",
			name = "last_name",
			nullable = true)
	private String userLastName;
	
	@Column(name = "dob",
			nullable = true)
	private Date userDOB;
	
	@Column(name = "gender",
			nullable = true)
	private Boolean userGender;
	
	@Column(name = "email",
			nullable = true,
			length = 50)
	private String userEmail;
	
	@Column(name = "phone",
			nullable = true,
			length = 50)
	private String userPhone;
	
	@Column(name = "is_active",
			nullable = true)
	private Boolean userIsActive;
	
	@Column(name = "date",
			nullable = true)
	private Date userDate;
}
