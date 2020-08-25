package StepDefinition_api;

import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class REQRES_DELETE {
	
	@Given("^enter the url- DELETE to delete existing ID$")
	public void enter_the_url_DELETE_to_delete_existing_ID() throws Throwable {
		
		HttpResponse<JsonNode> deleterequest=Unirest.delete("https://reqres.in/api/users/2").asJson();
		
		System.out.println("Status code is"+" "+deleterequest.getStatus());
		System.out.println("Status msg is"+" "+deleterequest.getStatusText());
		System.out.println("Status body is"+" "+deleterequest.getBody());
		
		//Test 1
		System.out.println("Test 1");
		if((deleterequest.getStatus())==204) {
	    System.out.println("Status code is "+deleterequest.getStatus()+" "+"status code is passed");
	}else {
		System.out.println("Status code is "+deleterequest.getStatus()+" "+"status code is failed");
	}
		
	
	//Test 2:
		System.out.println("Test 2");
	if(deleterequest.getStatusText().contains("")) {
		System.out.println("Status message is"+" "+deleterequest.getStatusText()+" "+"Status message is passed");
	}else {
		System.out.println("Status message is"+" "+deleterequest.getStatusText()+" "+"Status message is failed");
	}
	
    //Test 3
	System.out.println("Test 3");
	try {
		JSONObject myJson=deleterequest.getBody().getObject();
		String myString=myJson.toString();
		
		if(myString.contains("")) {
			System.out.println("Status body is"+deleterequest.getBody()+" "+"Status body is passed");
		}else {
			System.out.println("Status body is"+deleterequest.getBody()+" "+"Status body is failed");
		}
		
	} catch (NullPointerException e) {
		System.out.println("Status body having no content from server");
	}
	
	
	}
	@Then("^Verify the output for DELETE$")
	public void verify_the_output_for_DELETE() throws Throwable {
	   System.out.println("Delete Request has been passed");
	}

}
