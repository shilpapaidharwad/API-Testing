package PostRequestTest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
public class ValidateCreateRequest {

   @Test(priority = 0)
    public void validateRegisterInvalidUser() {

        // Response resrequest= RestAssured.post("https://reqres.in/api/users");
        //request.header("Content - Type", "Application/json");
        RequestSpecification request = RestAssured.given();
        request.header("Content Type", "Application/json");
        JSONObject requestJson = new JSONObject();
        try {
            requestJson.put("email", "smp@gmail.com");
            requestJson.put("password", "pistol");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        request.body(request.toString());
        Response responseRegister = request.post("https://reqres.in/api/users");
        System.out.println("Response Body" + responseRegister.getBody().asString());
        Assert.assertEquals(responseRegister.getStatusCode(), 201);


    }



    @Test(priority = 1)
    public void validateRegistervalidUser() {

        // Response resrequest= RestAssured.post("https://reqres.in/api/users");
        //request.header("Content - Type", "Application/json");
        RequestSpecification request = RestAssured.given();
        request.header("Content Type", "Application/json");
        JSONObject requestJson = new JSONObject();
        try {
            requestJson.put("email", "");
            requestJson.put("password", "");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        request.body(request.toString());
        Response responseRegister = request.post("https://reqres.in/api/users");
        System.out.println("Response Body" + responseRegister.getBody().asString());
        Assert.assertEquals(responseRegister.getStatusCode(), 201);


    }

    @Test(priority = 2)
    public void LoginSuccessful() {

        RequestSpecification request = RestAssured.given();
        request.header("Content Type", "Application/json");
        JSONObject requestJson = new JSONObject();
        try {
            requestJson.put("email", "peter@klaven");
            requestJson.put("password", "cityslicka");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        request.contentType("Application/json").body(requestJson.toString());

        Response responseRegister = request.post("https://reqres.in/api/login");
        System.out.println("Response Body" + responseRegister.getBody().asString());
        Assert.assertEquals(responseRegister.getStatusCode(), 200);
        if (responseRegister.getBody().asString() != null) {

            System.out.println("LOGIN SUCCESSFUL !!!");
        }

    }
        @Test(priority = 3)
        public void LoginUnSuccessful(){

            RequestSpecification request = RestAssured.given();
            request.header("Content Type", "Application/json");
            JSONObject requestJson = new JSONObject();
            try {
                requestJson.put("email", "peter@klaven");
                //requestJson.put("password", "cityslicka");

            } catch (JSONException e) {
                e.printStackTrace();
            }
            request.contentType("Application/json").body(requestJson.toString());

            Response responseRegister = request.post("https://reqres.in/api/login");
            System.out.println("Response Body" + responseRegister.getBody().asString());
            String body=responseRegister.getBody().asString();
            JsonPath jp = new JsonPath(body);
            String errorMessage=jp.getString("error");
            if(errorMessage.equals("Missing password")){
                System.out.println("LOGIN UNSUCCESSFUL !!!");
            }
            Assert.assertEquals(responseRegister.getStatusCode(), 400);



    }


}







