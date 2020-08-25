package StepDefinition_api;

import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class REQRES_PUT {
	
	@Given("^enter the url- POST to update existing ID$")
	public void enter_the_url_POST_to_update_existing_ID() throws Throwable {
		
		HttpResponse<JsonNode> putrequest=Unirest.put("https://reqres.in/api/users/2").body("{\r\n" + 
				"    \"name\": \"morpheus\",\r\n" + 
				"    \"job\": \"zion resident\"\r\n" + 
				"}").asJson();
		
		//PATCH REQUEST
//		HttpResponse<JsonNode> patchrequest=Unirest.patch("https://reqres.in/api/users/2").body("{\r\n" + 
//				"    \"name\": \"morpheus\",\r\n" + 
//				"    \"job\": \"zion resident\"\r\n" + 
//				"}").asJson();
	    
		System.out.println("Status code is "+putrequest.getStatus());
		System.out.println("Status message is "+putrequest.getStatusText());
		System.out.println("Status message is "+putrequest.getBody());
	
		//Test 1:
				System.out.println("Test 1");
				int status=putrequest.getStatus();
				if (status==200) {
					System.out.println("Put response code is expected & working fine");
				}else {
					System.out.println("Put response code is not expected & pdation  got failed");
				}

				//Test 2:
				System.out.println("Test 2");
				String statusmsg=putrequest.getStatusText();
				if (statusmsg.contains("OK")) {
					System.out.println(" Put message is expected & working fine");
				}else {
					System.out.println("Put message is not expected & pdation  got failed");
				}
				
				//Test 3:
				System.out.println("Test 3");
				
				JSONObject myJSON=putrequest.getBody().getObject();
				String myString=myJSON.toString();
				
				if(myString.contains("updated")) {
					System.out.println("Put response body is expected & working fine");
				}else {
					System.out.println("Put message body is not expected & updation  got failed");
				}
		
	}

	@Then("^Verify the output for PUT_UPDATE$")
	public void verify_the_output_for_PUT_UPDATE() throws Throwable {
	 
	}


}
