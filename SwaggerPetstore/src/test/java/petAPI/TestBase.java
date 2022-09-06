package petAPI;



import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {
	
	public static RequestSpecification httpRequest;
	public static Response response;
	public String petId="9223372036854261000";
	public String petIdPut="9223372036854262000";
    
}