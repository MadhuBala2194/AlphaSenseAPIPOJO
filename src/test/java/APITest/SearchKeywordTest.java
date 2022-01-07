package APITest;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import APIDTO.LoginRequestDTO;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class SearchKeywordTest {
	
	RequestSpecification request;
	Response response;
	ResponseBody responseBody;
	LoginRequestDTO loginRequestDTO;
	boolean status = false;
	String errorStatusline = "HTTP/1.1 500 Internal Server Error";
	String successStatusLine = "HTTP/1.1 200 OK";
	String json = null;

	public Map<String, String> getQueryParam() {
		
		Map<String,String> queryParamMap = new HashMap<String, String>();
		
		queryParamMap.put("slop", "15");
		queryParamMap.put("positiveOnly", "false");
		queryParamMap.put("negativeOnly", "false");
		queryParamMap.put("released", "1633003200000");
		
		return queryParamMap;
		
	}
	
	@DataProvider(name= "Valid_Keyword")
	public Object[] dataProvider_ValidKeyword() {
		return new Object[] {"Alpha"};
		
	}
	@DataProvider(name= "InValid_Keyword")
	public Object[] dataProvider_InValidKeyword() {
		return new Object[] {"..."};
		
	}
	
	@Test(dataProvider = "Valid_Keyword")
	public void searchWithValidKeyword(String keyword) {
		
		RestAssured.baseURI="https://rc.alpha-sense.com/services/i/public-document-data/document/PR-386ea743f2a90399fb0e4300ddf37d0697abc743";
		
		request = RestAssured.given();
		
		response = (Response) request.queryParams(getQueryParam())
				.queryParam("keyword", keyword).get("/keyword-search");
		
		 json = response.asString();
		 
		 if(response.getStatusCode()==200 && response.getStatusLine()== successStatusLine) {			 
		 
		  json.contains("www.alpha-sense.com");  
		  
		  status = true;
		 }
		 
		 if(status) {
			 
		  Assert.assertTrue(status);
		 }
	}

	@Test(dataProvider = "InValid_Keyword")
	public void searchWithInValidKeyword(String keyword) {
		
		RestAssured.baseURI="https://rc.alpha-sense.com/services/i/public-document-data/document/PR-386ea743f2a90399fb0e4300ddf37d0697abc743";
		
		request = RestAssured.given();
		
		response = (Response) request.queryParams(getQueryParam())
				.queryParam("keyword", keyword).get("/keyword-search");
		
		 json = response.asString();
		
		if(response.getStatusCode()==500 && response.getStatusLine()== errorStatusline) {
		
		json.contains("Request failed with status code 400");
		
		status = true;
	}
		 
		 if(status) {
			 
		  Assert.assertTrue(status);
		 }
	}
}
