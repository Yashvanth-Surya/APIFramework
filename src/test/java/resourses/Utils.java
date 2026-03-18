package resourses;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	public static RequestSpecification reqspec;
	
	//get reqspec if not null
	public RequestSpecification requestSpecification() throws IOException
	{
		if(reqspec == null)
		{
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		
		reqspec = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();
		
		return reqspec;
		}
		return reqspec;
	}
	
	//get base uri
	public static String getGlobalValue(String key) throws IOException
	{
		//Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\yashavanthsurya.p\\eclipse-workspace\\APIFramework\\src\\test\\java\\resourses\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String BaseURI = prop.getProperty(key);
		return BaseURI;
	}
	
	
	//get response as json string
	public String getJsonPath(Response response, String key)
	{
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		return js.get(key).toString();
	}
}
