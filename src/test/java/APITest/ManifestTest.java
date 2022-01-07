package APITest;

import org.testng.Assert;
import org.testng.annotations.Test;

import APIDTO.ManifestResponseDTO;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

@Test
public class ManifestTest {
	
	RequestSpecification request;
	Response response;
	ResponseBody responseBody;
	
	public void testManifestJson() {

	RestAssured.baseURI = "https://rc.alpha-sense.com/document-viewer";
	
	request = RestAssured.given();
	
	response = request.get("/manifest-rc.json");
	
	responseBody = response.getBody();
	
	ManifestResponseDTO manifestResponsePojo =  responseBody.as(ManifestResponseDTO.class);
	
	Assert.assertEquals(response.getStatusCode(), 200);
	
	Assert.assertEquals("v2.17.0", manifestResponsePojo.getRelease());
	
	String contentType = response.header("Content-Type");
	
	Assert.assertEquals(contentType , "application/json");
	
	}
}
