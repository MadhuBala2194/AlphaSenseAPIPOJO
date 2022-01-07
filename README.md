# AlphaSenseAPI POJO implementation

## Search Keyword API test(GET REQUEST): 
src/test/java >> APITest >> SearchKeywordTest.java .
This method will create GET call and verifies status code, status line and contents in the response for valid and invalid keyword
Query parameters are added to HashMap and its object is passed in requestbody
keywords are passed using Data Provider method in TestNG

## Login API test(POST REQUEST): 
Payload for post call has been given in json file under src/test/resources >> AuthPayoad.json.User defined post method(src/test/java >> APITest >>LoginTest.java) 
Reads the json file and pass payload to PoST request and verifies the status code, status line and response content for postive scenario.

## Manifest json (GET Request): 
User defined method that specify baseURI in src/test/java >> APITest >> ManifestTest.java will create GET call and verifies status code, status line and contents in the response.

Reports are created under the project folder 'target'
