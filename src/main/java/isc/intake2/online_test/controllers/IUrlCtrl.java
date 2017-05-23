package isc.intake2.online_test.controllers;

public interface IUrlCtrl {
	
	//url user
	
	public String getUser = "/api/user";
	
	public String getUserById = "/api/user/{id}";
	
	public String createUser = "/api/user";
	
	public String updateUser = "/api/user/{id}";
	
	public String deleteUser = "/api/user/{id}";
	
	//subject
	
	public String getSubject = "/api/subject";
	
	public String getSubjectById = "/api/subject/{id}";
	
	public String createSubject = "/api/subject";
	
	public String updateSubject = "/api/subject/{id}";
	
	public String deleteSubject = "/api/subject/{id}";
	
	// question
	
	public String getQuestion = "/api/question";
	
	public String getQuestionById = "/api/question/{id}";
	
	public String createQuestion = "/api/question";
	
	public String updateQuestion = "/api/question/{id}";
	
	public String deleteQuestion = "/api/question/{id}";
	
	// option
	
	public String getOption = "/api/option";
	
	public String getOptionById = "/api/option/{id}";
	
	public String createOption = "/api/option";
	
	public String updateOption = "/api/option/{id}";
	
	public String deleteOption = "/api/option/{id}";
	
	
	// answeartype
	
	public String getAnswearType = "/api/answeartype";
	
	public String getAnswaerTypeById = "/api/answeartype/{id}";
		
}
