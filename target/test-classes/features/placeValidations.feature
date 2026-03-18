Feature: Validating Place API's
@AddPlace @Regression
Scenario Outline: Verify if Place is being successfully added using AddPlaceAPI
	Given Add Place Payload with "<name>" "<language>" "<address>"
	When user calls "ADD_PLACE" with "PoSt" http request
	Then the API call got success with status code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	And verify place_id created maps to "<name>" using "GET_PLACE"
	
	
Examples:
	|	name  		|	language	| 			address 		  		 	    |
	|	Yashvanth	|	Kannada 	|	Athiguppe, Vijayanagar, Banglore		|
#	|	Surya		|	Telugu  	|	Kadubaseenahalil Marathahalli, Banglore	|

@DeletePlace @Regression	
Scenario: Verify id Delete Place functionality is working
	Given DeletePlace Payload
	When user calls "DELETE_PLACE" with "POst" http request
	Then the API call got success with status code 200
	And "status" in response body is "OK"