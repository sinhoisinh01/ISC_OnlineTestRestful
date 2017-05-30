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
		

	
	
	//part
	public static final String getPart = "/api/subject/{subjectId}/parts";
	
	public static final String getPartById = "/api/subject/{id}/part";
	
	public static final String createPart = "/api/subject/{subjectId}/part";
	
	public static final String updatePart = "/api/subject/{subjectId}/part/{id}";
	
	public static final String deletePart = "/api/part/{id}";
	
	//image gallery
	public static final String getImage = "/api/part/{partId}/image";
	
	public static final String getImageById = "/api/part/{partId}/image/{id}";
	
	public static final String createImage = "/api/part/{partId}/image";
	
	public static final String updateImage = "/api/part/{partId}/image/{id}";
	
	public static final String deleteImage = "/api/image/{id}";

}
