//Hong
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
@Table(name="users")
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEncPassword() {
		return userEncPassword;
	}

	public void setUserEncPassword(String userEncPassword) {
		this.userEncPassword = userEncPassword;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public Date getUserDOB() {
		return userDOB;
	}

	public void setUserDOB(Date userDOB) {
		this.userDOB = userDOB;
	}

	public Boolean getUserGender() {
		return userGender;
	}

	public void setUserGender(Boolean userGender) {
		this.userGender = userGender;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public Boolean getUserIsActive() {
		return userIsActive;
	}

	public void setUserIsActive(Boolean userIsActive) {
		this.userIsActive = userIsActive;
	}

	public Date getUserDate() {
		return userDate;
	}

	public void setUserDate(Date userDate) {
		this.userDate = userDate;
	}

	public User() {
		super();
	}

	public User(long id, String userName, String userEncPassword, String userFirstName, String userLastName,
			Date userDOB, Boolean userGender, String userEmail, String userPhone, Boolean userIsActive, Date userDate) {
		super();
		this.id = id;
		this.userName = userName;
		this.userEncPassword = userEncPassword;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userDOB = userDOB;
		this.userGender = userGender;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userIsActive = userIsActive;
		this.userDate = userDate;
	}
}
