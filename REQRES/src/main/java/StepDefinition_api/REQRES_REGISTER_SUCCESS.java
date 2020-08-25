package StepDefinition_api;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

import cucumber.api.Format;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class REQRES_REGISTER_SUCCESS {
	
	@Given("^enter the url- REGISTER$")
	public void enter_the_url_REGISTER() throws Throwable {
		
		
		//Suppose if it raw body
		/*HttpResponse<JsonNode> Registersucess=Unirest.post("https://reqres.in/api/register").body("{\r\n" + 
				"    \"email\": \"eve.holt@reqres.in\",\r\n" + 
				"    \"password\": \"pistol\"\r\n" + 
				"}").asJson();*/
		
		//Suppose if it is form encoder (Here we can give generic as String or JsonNode as well
		HttpResponse<String> Registersucess=Unirest.
				post("https://reqres.in/api/register").
				field("email", "eve.holt@reqres.in").
				field("password", "").
				asString();
				
		
		System.out.println("Status code is "+Registersucess.getStatus());
		System.out.println("Status msg is "+Registersucess.getStatusText());
		System.out.println("Status msg is "+Registersucess.getBody());
		
		//Test 1:
		System.out.println("Test 1");
		if(Registersucess.getStatus()==200) {
			if(Registersucess.getStatusText().contains("OK")) {
				if(Registersucess.getBody().contains("token")) {
					System.out.println("Register is successful & Token got generated");
				}}}
	else {
					System.out.println("Status code is "+Registersucess.getStatus()+"\n"+
						"Status message is "+Registersucess.getStatusText()+"\n"+
						"Status body is "+Registersucess.getBody()
		);
				
	}
		}

	@Then("^Verify the output for REGISTER$")
	public void verify_the_output_for_REGISTER() throws Throwable {
	    System.out.println("Register is successful ");
	}

}
