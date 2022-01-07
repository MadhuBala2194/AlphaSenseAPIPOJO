package APITest;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import APIDTO.LoginRequestDTO;
import APIDTO.LoginResponseDTO;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class LoginTestWithPojoImplementation {
	
	RequestSpecification request;
	Response response;
	ResponseBody responseBody;
	LoginRequestDTO loginRequestDTO;
	boolean status = false;
	String errorStatusLine = "HTTP/1.1 401 ";
	
	public LoginRequestDTO loginTestResponse() throws IOException {
		
		loginRequestDTO = new LoginRequestDTO();
		
		JSONParser parser = new JSONParser();
		
		try {
			
			Object obj = parser.parse(new FileReader("src/test/resources/AuthPayload.json")); 
			
			JSONObject jsonObject = (JSONObject) obj;	
	
			loginRequestDTO.setUsername(jsonObject.get("username").toString());
			
			loginRequestDTO.setPassword(jsonObject.get("password").toString());
			
			loginRequestDTO.setGrant_type(jsonObject.get("grant_type").toString());
			 
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return loginRequestDTO;
	}
	
	@Test	
	public void loginresponse() throws IOException {
		
		RestAssured.baseURI="https://rc.alpha-sense.com/services/auth-ws-v3";
		
		request = RestAssured.given();
		
		request.body(loginTestResponse());
		
		response = request.post("/oauth/token");
		
		responseBody = response.getBody();
		
		LoginResponseDTO loginResponseDTO =  responseBody.as(LoginResponseDTO.class);
		
		if(response.getStatusCode() == 401 && response.getStatusLine() == errorStatusLine) {
		
			loginResponseDTO.getMessage().contains("Unauthorized");
		
			loginResponseDTO.getError().contains("Unauthorized");
			
			loginResponseDTO.getStatus().equals(401);
				
			status = true;
	}
		if(status) {
			
			Assert.assertTrue(status);
		}
	}
}

