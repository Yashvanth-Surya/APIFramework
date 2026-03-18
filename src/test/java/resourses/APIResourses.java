package resourses;


public enum APIResourses {
	ADD_PLACE("/maps/api/place/add/json"),
	GET_PLACE("/maps/api/place/get/json"),
	DELETE_PLACE("/maps/api/place/delete/json");
	private String resource;

	APIResourses(String resource) 
	{
		this.resource = resource;
	}
	
	public String getResource()
	{
		return resource;
	}
}
