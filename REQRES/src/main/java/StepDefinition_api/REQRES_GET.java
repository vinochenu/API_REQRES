package StepDefinition_api;





import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;



public class REQRES_GET {
	
	
	// ****** Scenario: Verify reqres GET request
	@Given("^enter the url$")
	public void enter_the_url() throws Throwable {
		HttpResponse<JsonNode> getrequest= (HttpResponse) Unirest.get("https://reqres.in/api/users?page=2").asJson();
		System.out.println("Status code is "+getrequest.getStatus());
		System.out.println("Status code is "+getrequest.getStatusText());
		System.out.println("Status code is "+getrequest.getBody());
	    
		//Test 1:
		System.out.println("Test 1");
		int status=getrequest.getStatus();
		if(status==200) {
			System.out.println("Status code is expected & test is passed");
		}else {
			System.out.println("Status code is not expected & test is failed");
		}
		
		//Test 2: 
		System.out.println("Test 2");
		String statusmsg=getrequest.getStatusText();
		if(statusmsg.contains("OK")) {
			System.out.println("Status msg is expected & test is passed");
		}else {
			System.out.println("Status msg is not expected & test is failed");
		}
		
		//Test 3:
		System.out.println("Test 3");
		
		
		
	}

	@Then("^Verify the output$")
	public void verify_the_output() throws Throwable {

		System.out.println("Get Request is successful");
}
	
	

//Scenario: Verify reqres GET by USERID request
@Given("^enter the url- GET by USERID$")
public void enter_the_url_GET_by_USERID() throws Throwable {
	HttpResponse<JsonNode> get_id= Unirest.get("https://reqres.in/api/users/2").asJson();
	System.out.println("Status code is "+get_id.getStatus());
	System.out.println("Status code is "+get_id.getStatusText());
	System.out.println("Status code is "+get_id.getBody());
	
	
	
}

@Then("^Verify the output for GET by USERID$")
public void verify_the_output_for_GET_by_USERID() throws Throwable {
	
	System.out.println("Get Request by iD is successful");
}


//Scenario: Verify reqres GET by UNKNOWN USERID request

@Given("^enter the url-UNKNOWN USERID$")
public void enter_the_url_UNKNOWN_USERID() throws Throwable {
	HttpResponse<JsonNode> get_unknownid= Unirest.get("https://reqres.in/api/users/23").asJson();
	System.out.println("Status code is "+get_unknownid.getStatus());
	System.out.println("Status code is "+get_unknownid.getStatusText());
	System.out.println("Status code is "+get_unknownid.getBody());
	
	//Test 4: 
	System.out.println("Test 4");
	int status=get_unknownid.getStatus();
	Assert.assertEquals(404, status);
	System.out.println("Assertion got passed & Test 4 got passed");
}

@Then("^Verify the output for UNKNOWN USERID$")
public void verify_the_output_for_UNKNOWN_USERID() throws Throwable {
   
	System.out.println("Get Request by unknown iD is successful");
}



}
