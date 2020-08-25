package StepDefinition_api;


import java.io.DataInput;
import java.io.File;

import javax.swing.text.html.parser.Entity;

import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MappingJsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.body.Body;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class REQRES_POST {

	@Given("^enter the url- POST to create new ID$")
	public  void enter_the_url_POST_to_create_new_ID() throws Throwable {

		HttpResponse<JsonNode> postrequest=Unirest.post("https://reqres.in/api/users").body("{\r\n" + 
				"    \"name\": \"morpheus\",\r\n" + 
				"    \"job\": \"leader\"\r\n" + 
				"}").asJson();
		
		 JSONObject myJSON = postrequest.getBody().getObject();//this is to store the output body into JSONObject class
		 String myString=myJSON.toString();// this is to convert the json object into string
		 System.out.println("json output is "+myJSON);
		 System.out.println("String output is "+myString);

		System.out.println("Status code is "+postrequest.getStatus());
		System.out.println("Status message is "+postrequest.getStatusText());
		System.out.println("Status message is "+postrequest.getBody());

		//Test 1:
		System.out.println("Test 1");
		int status=postrequest.getStatus();
		if (status==201) {
			System.out.println("Post response code is expected & working fine");
		}else {
			System.out.println("Post response code is not expected & new ID creation got failed");
		}

		//Test 2:
		System.out.println("Test 2");
		String statusmsg=postrequest.getStatusText();
		if (statusmsg.contains("Created")) {
			System.out.println("Post response message is expected & working fine");
		}else {
			System.out.println("Post response message is not expected & new ID creation got failed");
		}
		
		//Test 3:
		System.out.println("Test 3");
		 if(myString.contains("createdAt")) {
          System.out.println("Post response body is expected & working fine");  
		 }else {
			 System.out.println("Post response body is not expected & new ID creation got failed"); 
		 }
	}

	@Then("^Verify the output for POST-CREATE$")
	public void verify_the_output_for_POST_CREATE() throws Throwable {
		System.out.println("Post creation is successful with new id ");
	}

}
