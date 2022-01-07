package APITest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import org.testng.Assert;
import org.testng.annotations.Test;

import APIDTO.LoginResponseDTO;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;


public class LoginTest {
	
	RequestSpecification request;
	Response response;
	ResponseBody responseBody;
	boolean status = false;
	String errorStatusLine = "HTTP/1.1 401 ";
	
	@Test
	public void LoginTestResponse() throws IOException {		
	
	byte[] inputFile=Files.readAllBytes(Paths.get("src/test/resources/AuthPayload.json"));
	
	String file = new String(inputFile);
	
	RestAssured.baseURI="https://rc.alpha-sense.com/services/auth-ws-v3";
	
	request = RestAssured.given();
	
	request.body(file);
	
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
