package steps;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import static io.restassured.RestAssured.given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import petAPI.TestBase;
import io.restassured.module.jsv.JsonSchemaValidator;
public class GET_request extends TestBase {
	
	RequestSpecification httpRequest;
	Response response;
	
	@BeforeClass
	
	 void start() {
		 
		 System.out.println("---------Started GET_request---------");
	 }
	    
	
	@When("Realizo el request GET de una mascota existente")
	public void realizo_el_request_get_de_una_mascota_existente() throws InterruptedException {
		    
		
		System.out.println("---------Started GET_request---------");
		//Specify base URI
		RestAssured.baseURI = "https://petstore.swagger.io/v2/pet/";
		//Request object
		RequestSpecification httpRequest=RestAssured.given();
		//Responce Object
		response = httpRequest.request(Method.GET, petId);
		
		 Thread.sleep(3000);
		
	}
		
	
	@Then("Valido el response body del GET")
	public void valido_el_response_body_del_get() {
		
		System.out.println("---------Check response body---------");
		String responceBody = response.getBody().asString();
		System.out.println("Responce body ==> " + responceBody);
		Assert.assertTrue(responceBody !=null);
		
	}
	
	
	@Then("Valido el Status code esperado del GET")
	public void valido_el_status_code_esperado_del_get() {
		
		System.out.println("---------validate status code---------");
		int statusCode = response.getStatusCode();
		System.out.println("Status code is  ==> " + statusCode);
		Assert.assertEquals(statusCode, 200);
		
	}
	
	    
	 
	 @Then("Valido el Schema del response del GET")
	 public void valido_el_schema_del_response_del_get() {
         
		 System.out.println("---------validate JSON schema---------"); 
		
		 
	     given().
	         get(petId).
	     then().
	     assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemaGet.json"));
	     
	     
	     
	     
	}
	 
	 @After
	 void tearDown() {
		 
		 System.out.println("---------Finished GET_request---------");
	 }
	

}
