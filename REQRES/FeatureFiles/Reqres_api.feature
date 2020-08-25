@reqres_API
Feature: Verify GET request

@reqres_API @GETUSERS
Scenario: Verify reqres GET request
	Given enter the url
	Then Verify the output 
	
	@reqres_API @GET_ID
	Scenario: Verify reqres GET by USERID request
	Given enter the url- GET by USERID
	Then Verify the output for GET by USERID
	
	@reqres_API @GET_UNKNOWNID
	Scenario: Verify reqres GET by UNKNOWN USERID request
	Given enter the url-UNKNOWN USERID
	Then Verify the output for UNKNOWN USERID
	
	@reqes_API @POST_CREATE
	Scenario: Verify reqres POST to create 
	Given enter the url- POST to create new ID
	Then Verify the output for POST-CREATE
	
	@reqres_API @PUT_UPDATE
	Scenario: Verify reqres PUT to update
	Given enter the url- POST to update existing ID
	Then Verify the output for PUT_UPDATE
	
    @reqres_API @PUT_DELETE
    Scenario: Verify reqres DELETE
	Given enter the url- DELETE to delete existing ID
	Then Verify the output for DELETE
	@reqres_API @REGISTER_SUCCESS
	 Scenario: Verify reqres REGISTER -Successfil
	Given enter the url- REGISTER
	Then Verify the output for REGISTER