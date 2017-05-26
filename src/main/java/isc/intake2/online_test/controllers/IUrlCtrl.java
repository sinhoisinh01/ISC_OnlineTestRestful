package isc.intake2.online_test.controllers;

public interface IUrlCtrl {
	
	//url user
	
	public static final String getUser = "/api/user";
	
	public static final String getUserById = "/api/user/{id}";
	
	public static final String createUser = "/api/user";
	
	public static final String updateUser = "/api/user/{id}";
	
	public static final String deleteUser = "/api/user/{id}";
	
	//subject
	
	public static final String getSubject = "/api/subject";
	
	public static final String getSubjectById = "/api/subject/{id}";
	
	public static final String createSubject = "/api/subject";
	
	public static final String updateSubject = "/api/subject/{id}";
	
	public static final String deleteSubject = "/api/subject/{id}";
	
	//part
	public static final String getPart = "/api/subject/part/{subjectId}";
	
	public static final String getPartById = "/api/part/{id}";
	
	public static final String createPart = "/api/part";
	
	public static final String updatePart = "/api/part/{id}";
	
	public static final String deletePart = "/api/part/{id}";
	
	//image gallery
	public static final String getImage = "/api/part/{partId}/image";
	
	public static final String getImageById = "/api/part/{partId}/image/{id}";
	
	public static final String createImage = "/api/part/{partId}/image";
	
	public static final String updateImage = "/api/part/{partId}/image/{id}";
	
	public static final String deleteImage = "/api/image/{id}";
}
