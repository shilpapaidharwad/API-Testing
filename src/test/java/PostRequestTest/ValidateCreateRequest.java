package PostRequestTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import jdk.internal.jline.internal.TestAccessible;
import org.testng.Assert;
import org.testng.annotations.Test;
public class ValidateCreateRequest {

    @Test
    public void ValidateResponseCode()
    {

        Response response= RestAssured.post("https://reqres.in/api/users");
        //System.out.println(response.getStatusCode());







    }


}




