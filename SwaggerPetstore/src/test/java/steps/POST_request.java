package steps;
import petAPI.TestBase;
import static io.restassured.RestAssured.given;


import org.json.simple.JSONObject;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POST_request extends TestBase {
	
	RequestSpecification httpRequest;
	Response response;
	
	@BeforeClass
	
	 void start() {
		 
		System.out.println("---------Started POST_request---------");
	 }
	
	
	@When("Realizo el request POST de una nueva mascota")
	public void ealizo_el_request_post_de_una_nueva_mascota() throws InterruptedException {
		
		
		//Specify base URI
		RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";
	
		//Request object
	    httpRequest = RestAssured.given();
		//Request Object
		
		@SuppressWarnings("unused")
		JSONObject requestParams = new JSONObject();
		String infoBody = "{\"id\":9223372036854261000,"
				+ "\"category\":{\"id\":0,"
				+ "\"name\":\"string\"},"
				+ "\"name\":\"Salchi\","
				+ "\"photoUrls\":[\"https://www.purina-latam.com/sites/g/files/auxxlc391/files/styles/social_share_large/public/purina-conoce%20todo-acerca-del-dachshund-perro-salchicha.jpg?itok=gtpvnLfv\"],"
				+ "\"tags\":[{\"id\":0,\"name\":"
				+ "\"string\"}],\"status\":"
				+ "\"available\"}";
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.header("accept", "application/json");
		httpRequest.body(infoBody);
		
		
		//Responce object
		response = httpRequest.request(Method.POST);
		Thread.sleep(5000);
		
	}
	
		
	
	
	@Then("Valido el response body del POST")
	public void valido_el_response_body_del_post() {	
		
		System.out.println("---------Check response body---------");
		String responceBody = response.getBody().asString();
		System.out.println("Responce body ==> " + responceBody);
		Assert.assertTrue(responceBody !=null);
		
	}
	
	@Then("Valido el Status code esperado del POST")
	public void valido_el_status_code_esperado_del_post() {
		
		System.out.println("---------validate status code---------");
		int statusCode = response.getStatusCode();
		System.out.println("Status code is  ==> " + statusCode);
		Assert.assertEquals(statusCode, 200);
	}
	
	    
	
	 @Then("Valido el Schema del response del POST")
	 public void valido_el_schema_del_response_del_post() {
       
		 System.out.println("---------validate JSON schema---------"); 
		 int statusCode = response.getStatusCode();
	
	     given().
	         get().
	     then().
	     assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemaPost.json"));
	     Assert.assertEquals(statusCode, 200);
	     
	}
	 
	 @AfterClass
	 void tearDown() {
		 
		 System.out.println("---------Finished POST_request---------");
	 }



}
