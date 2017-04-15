package isc.intake2.online_test.entities;

import java.util.Date;

public class User {
	private long id;
	private String account;
	private String password;
	private String firstname;
	private String lastname;
	private String DOB;
	private boolean gender;
	private String mail;
	private String phone;
	private boolean isActive;
	private Date date;
	
	public User() {
		super();
	}

	/**
	 * @param id
	 * @param account
	 * @param password
	 * @param firstname
	 * @param lastname
	 * @param dOB
	 * @param gender
	 * @param mail
	 * @param phone
	 * @param isActive
	 */
	@SuppressWarnings("deprecation")
	public User(long id, String account, String password, String firstname, String lastname, String dOB, boolean gender,
			String mail, String phone, boolean isActive) {
		super();
		this.id = id;
		this.account = account;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.DOB = dOB;
		this.gender = gender;
		this.mail = mail;
		this.phone = phone;
		this.isActive = isActive;
		this.date = new Date(2017,4,15);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public boolean getGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
