package resourses;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.location;

public class TestDataBuild {
	
	public AddPlace addPlacePayload(String name, String language, String address)
	{
		List<String> myList = new ArrayList<String>(); //set list data
		myList.add("shoe park");
		myList.add("shop");
		
		location l = new location(); //set location lat.lng
		l.setLat(-38.383494);
		l.setLng(33.427362);
		
		AddPlace p = new AddPlace(); //set payload
		p.setTypes(myList);
		p.setLocation(l);
		p.setAccuracy(50);
		p.setAddress(address);
		p.setName(name);
		p.setPhone_number("(+91) 9337665351");
		p.setWebsite("http://google.com");
		p.setLanguage(language);
		
		return p;
	}
	
	public String deletePlacePayload(String placeId)
	{
		return "{\"place_id\":\""+placeId+"\"}";
	}


}
