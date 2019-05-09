package GetRequestTest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidateResponseCodeTest {

    /*
      @Test
      public void ValidateResponseCodeSingleUser() {

          Response response = RestAssured.get("https://reqres.in/api/users/2");
          System.out.println(response.getStatusCode());
          String body;

          Assert.assertTrue(response.getStatusCode() == 200);
          System.out.println(response.getStatusCode());

          body = response.getBody().asString();
          System.out.println(body);

          JsonPath jp = new JsonPath(body);
          String firstName = jp.getString("data.first_name");
          System.out.println(firstName);


      }
      */
    /*
    @Test
    public void validateMultipleUser200() {
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println(response.getStatusCode());
        String body;

        Assert.assertTrue(response.getStatusCode() == 200);
        System.out.println(response.getStatusCode());

        body = response.getBody().asString();
        System.out.println(body);

        JsonPath jp = new JsonPath(body);

        String firstName1 = jp.getString("data[0]");
        //System.out.println(firstName1);
        String firstName2 = jp.getString("data[1]");
        // System.out.println(firstName2);

        String firstName3 = jp.getString("data");
        System.out.println(firstName3);

    }   */

    @Test
    public void ValidateResponse() {
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");

        Assert.assertEquals(response.getStatusCode(), 200);
        //System.out.println(response.getBody().prettyPrint());
        Response body = (Response) response.getBody();
        List<Map<String, ?>> ExpectedResult = new ArrayList<>();
        List<Map<String, ?>> actualData = response.jsonPath().getList("data");

        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        Map<String, String> map3 = new HashMap<>();

        map1.put("id", "4");
        map1.put("first_name", "Eve");
        map1.put("last_name", "Holt");

        map2.put("id", "5");
        map2.put("first_name", "Charles");
        map2.put("last_name", "Morris");

        map3.put("id", "6");
        map3.put("first_name", "Tracey");
        map3.put("last_name", "Ramos");

        ExpectedResult.add(map1);
        ExpectedResult.add(map2);
        ExpectedResult.add(map3);

        int datasize = actualData.size();

        System.out.println(datasize);
        for (int i = 0; i < datasize; i++) {
            System.out.println("Id :" + actualData.get(i).get("id").toString());
            System.out.println("First Name :" + actualData.get(i).get("first_name").toString());
              System.out.println("Last Name :" + actualData.get(i).get("last_name").toString());
            Assert.assertEquals(ExpectedResult.get(i).get("id").toString(), actualData.get(i).get("id").toString());

            Assert.assertEquals(ExpectedResult.get(i).get("first_name").toString(), actualData.get(i).get("first_name").toString());
            Assert.assertEquals(ExpectedResult.get(i).get("last_name").toString(), actualData.get(i).get("last_name").toString());

        }
        Assert.assertEquals("Eve", actualData.get(0).get("first_name").toString());

    }
}