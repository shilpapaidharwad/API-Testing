package GetRequestTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import jdk.internal.jline.internal.TestAccessible;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidateResponseCodeTest {


    @Test
    public void ValidateResponseCode()
    {

        Response response= RestAssured.get("https://reqres.in/api/users?page=4");
        System.out.println(response.getStatusCode());

        Assert.assertTrue(response.getStatusCode()==200);
        System.out.println(response.getStatusCode());
        //validateData(response);
        response.prettyPrint();
        // System.out.println("Header :");
        System.out.println("Headers are : "+response.headers());
        System.out.println("JsonPath : "+response.jsonPath());
        System.out.println("StatusLine :" +response.getStatusLine());
        //Assert
        List<Map<String, ?>>actualData= response.jsonPath().getList("data");
        List<Map<String, ?>>expectedDataList;
        /*Map map= new HashMap();
        map.put("id",4);
        map.put("first_name","Eve");
        map.put("last_name",  "Holt");*/




        int dataSize= actualData.size();
        System.out.println("Number of records: +dataSize");
        for(int i=0;i<dataSize;i++)
        {
            System.out.println("Id is:" +actualData.get(i).get("id").toString());
            System.out.println("Name : " +actualData.get(i).get("first_name").toString());

        }

        Assert.assertEquals("10" , actualData.get(0).get("id").toString());
        System.out.println(" DIplaying");




            //System.out.println(" Number of Records: "+)




        //Assert.assertTrue();



    }


}
