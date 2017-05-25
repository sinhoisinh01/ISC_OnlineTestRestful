package isc.intake2.online_test.controllers;

public interface IUrlCtrl {
	
	//url user
	
	public final String getUser = "/api/user";
	
	public final String getUserById = "/api/user/{id}";
	
	public final String createUser = "/api/user";
	
	public final String updateUser = "/api/user/{id}";
	
	public final String deleteUser = "/api/user/{id}";
	
	//subject
	
	public final String getSubject = "/api/subject";
	
	public final String getSubjectById = "/api/subject/{id}";
	
	public final String createSubject = "/api/subject";
	
	public final String updateSubject = "/api/subject/{id}";
	
	public final String deleteSubject = "/api/subject/{id}";
}
