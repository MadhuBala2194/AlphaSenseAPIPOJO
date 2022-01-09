# AlphaSenseAPI POJO implementation

## Search Keyword API test(GET REQUEST): 
src/test/java >> APITest >> SearchKeywordTest.java .

### Valid Keyword Search:

This method will create GET call and maps the response to pojo class (KeywordSearchRootDTO.java, KeywordSearchResultsDTO.java,kearchKeywordStatementDTO.java) 
Verifies status code, status line and contents from pojo class 
Query parameters are added to HashMap under getQueryParam() and its object is passed in requestbody
keywords are passed using Data Provider method in TestNG - dataProvider_ValidKeyword()

### InValid Keyword Search:

This method will create GET call and maps the response to pojo KeywordSearchErrorResponseDTO.java
Verifies status code, status line and contents from pojo class 
Query parameters are added to HashMap under getQueryParam() and its object is passed in requestbody
keywords are passed using Data Provider method in TestNG -  dataProvider_InValidKeyword()

## Login API test(POST REQUEST): 

User defined post method(src/test/java >> APITest >>LoginTest.java) 
Payload for post call has been given in json file under src/test/resources >> AuthPayoad.json. The loginTestResponse() method will read the json file and pass as payload directly.
POST Response will be mapped into pojo LoginResponseDTO.java 
Verifies the status code, status line from response and contents of json response will be verified from pojo for postive scenario.

User defined post method(src/test/java >> APITest >>LoginTestWithPojoImplementation.java) 
Payload for post call has been given in json file under src/test/resources >> AuthPayoad.json. 
The loginresponse() method will read the json file and maps the request payload to pojo LoginRequestDTO.java and pass to POST call.
POST Response will be mapped into pojo LoginResponseDTO.java 
Verifies the status code, status line from response and contents of json response will be verified from pojo for postive scenario.

## Manifest json (GET Request): 
User defined method that specify baseURI in src/test/java >> APITest >> ManifestTest.java will create GET call , maps the response to pojo ManifestResponseDTO.java and verifies status code, status line and contents in the response from pojo class.

Reports are created under the project folder 'target'
