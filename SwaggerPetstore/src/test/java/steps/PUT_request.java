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

public class PUT_request extends TestBase {
	
	RequestSpecification httpRequest;
	Response response;
	
	@BeforeClass
	
	 void start() {
		 
		System.out.println("---------Started PUT_request---------");
	 }
	
	@When("Realizo el request PUT para modificar una mascota existente")
	public void realizo_el_request_put_para_modificar_una_mascota_existente() throws InterruptedException {
		
		
		//Specify base URI
		RestAssured.baseURI = "https://petstore.swagger.io/v2/pet/";
		//Request object
	    httpRequest = RestAssured.given();
		//Request Object
		@SuppressWarnings("unused")
		JSONObject requestParams = new JSONObject();
		
		String infoBodyPut = "{\"id\":9223372036854262000,"
				+ "\"category\":{\"id\":0,"
				+ "\"name\":\"string\"},"
				+ "\"name\":\"Harry\","
				+ "\"photoUrls\":[\"https://t1.uc.ltmcdn.com/es/posts/8/3/9/como_saber_si_un_cachorro_de_golden_retriever_es_puro_50938_3_600.webp\"],"
				+ "\"tags\":[{\"id\":0,\"name\":"
				+ "\"string\"}],\"status\":"
				+ "\"available\"}";
		
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.header("accept", "application/json");
		httpRequest.body(infoBodyPut);
				 
		
		
		//Responce object
		response = httpRequest.request(Method.PUT);
		Thread.sleep(5000);
		
	}
		

	@Then("Valido el response body del PUT")
	public void valido_el_response_body_del_put() {	
		
		System.out.println("---------Check response body---------");
		String responceBody = response.getBody().asString();
		System.out.println("Responce body ==> " + responceBody);
		Assert.assertTrue(responceBody !=null);
		
	}

	@Then("Valido el Status code esperado del PUT")
	public void valido_el_status_code_esperado_del_put() {
		
		System.out.println("---------validate status code---------");
		int statusCode = response.getStatusCode();
		System.out.println("Status code is  ==> " + statusCode);
		Assert.assertEquals(statusCode, 200);
	}
	
	    
	
	 @Then("Valido el Schema del response del PUT")
	 public void valido_el_schema_del_response_del_put() {
    
		 System.out.println("---------validate JSON schema---------"); 
		 
		
	     given().
	         get(petIdPut).
	     then().
	     assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemaPut.json"));
	     
	     
	}
	 
	 
	 @AfterClass
	 void tearDown() {
		 
		 System.out.println("---------Finished PUT_request---------");
	 }
	 
	 
	
}
