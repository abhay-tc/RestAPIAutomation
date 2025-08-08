package api.testcases;

import org.testng.annotations.Test;

import api.endPojnts.userEndPoints;
import api.payload.user;
import io.restassured.response.Response;



public class UserTestDataDiven {
@Test(dataProvider = "AllData", dataProviderClass = api.utilities.DataProviders.class)
public void testCreateUser(
    String userId,
    String userName,
    String fName,
    String lName,
    String email,
    String psw,
    String phone)
{
    user userPayload = new user();

    // Parse userId
    try {
        userPayload.setId(Integer.parseInt(userId));
    } catch (NumberFormatException e) {
        System.out.println("Invalid userId in Excel: " + userId);
        userPayload.setId(0); // fallback
    }

    userPayload.setUsername(userName);
    userPayload.setFirstName(fName);
    userPayload.setLastName(lName);
    userPayload.setEmail(email);
    userPayload.setPassword(psw);
    userPayload.setPhone(phone);  // keep phone as string

    Response response = userEndPoints.createUser(userPayload);

    System.out.println("User created successfully!");

    // log response
    response.then().log().all();

    // validation
    org.testng.Assert.assertEquals(response.getStatusCode(), 200);
}
}