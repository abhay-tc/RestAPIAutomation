package api.testcases;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endPojnts.userEndPoints;
import api.payload.user;
import io.restassured.response.Response;



public class userTest {

	Faker faker;
	user userPayload;
	public static Logger logger;
	
	@BeforeClass
	public void generateTestData() {
		faker = new Faker();
		userPayload = new user();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setFirstName(faker.name().lastName());
		userPayload.setFirstName(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		//obtain logger
		logger = LogManager.getLogger("RestAssuredAutomationFramework");
	}
	
	
	@Test(priority=1)
	public void testCreateUser()
	{
		Response response = userEndPoints.createUser(userPayload);
		
		System.out.println("User create succesfully!");		
		//log response
		response.then().log().all();
		
		//validation
		org.testng.Assert.assertEquals(response.getStatusCode(),200);
		
		//log
		logger.info("Create User executed");
	}
	
	@Test(priority=2)
	public void testGetUserData()
	{
		Response response = userEndPoints.GetUser(this.userPayload.getUsername());
		
		System.out.println("User get succesfully!");
		//log response
		response.then().log().all();
		
		//validation
		org.testng.Assert.assertEquals(response.getStatusCode(),200);
		
		//log
		logger.info("Get User executed");
	}
	
	@Test(priority=3)
	public void testUpdateUserData()
	{
		userPayload.setFirstName(faker.name().firstName());
		Response response = userEndPoints.UpdateUser(this.userPayload.getUsername(),userPayload);
		
		System.out.println("User update succesfully!");
		//log response
		response.then().log().all();
		
		//validation
		org.testng.Assert.assertEquals(response.getStatusCode(),200);
		
		//log
		logger.info("Update User executed");
	}
	
	@Test(priority=4)
	public void testDeleteUserData()
	{
		Response response = userEndPoints.DeleteUser(this.userPayload.getUsername());
		
		System.out.println("User delete succesfully!");
		//log response
		response.then().log().all();
		
		//validation
		org.testng.Assert.assertEquals(response.getStatusCode(),200);
		
		//log
		logger.info("Delete User executed");
	}
}
