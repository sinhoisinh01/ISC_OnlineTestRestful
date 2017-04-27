package isc.intake2.online_test.controllers;

public interface IUrlCtrl {
	
	//url user
	
	public String getUser = "/api/user/";
	
	public String getUserById = "/api/user/{id}";
	
	public String createUser = "/api/user/";
	
	public String updateUser = "/api/user/{id}";
	
	public String deleteUser = "/api/user/{id}";
	
	//subject
	
	public String getSubject = "/api/subject/";
	
	public String getSubjectById = "/api/subject/{id}";
	
	public String createSubject = "/api/subject/";
	
	public String updateSubject = "/api/subject/{id}";
	
	public String deleteSubject = "/api/subject/{id}";
}
