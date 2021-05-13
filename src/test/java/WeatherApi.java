import DataProvider.CityName;
import Pojo.Root;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WeatherApi {

    @Test(dataProvider = "GoogleSearchCityDetails",dataProviderClass = CityName.class)
    public  void getCityName(String city)
    {
        RestAssured.baseURI="https://api.openweathermap.org/data/2.5/weather";
        Root response=given().queryParam("q", city).queryParam("appid",
                "692bbaff8d7d4449f933a3913fbc4297")
                .expect().defaultParser(Parser.JSON)
                .when()
                .get("https://api.openweathermap.org/data/2.5/weather").as(Root.class);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getName(),city);
        softAssert.assertAll();
        System.out.println("Validation success : " +
                "Expected city name : "+ response.getName() + "  Actual City name  " + city);

    }

    @Test
    public void getLatandLon()
    {
        double lat = 55.5 , lon = 37.5;
        int expected_cod =200;
        RestAssured.baseURI="https://api.openweathermap.org/data/2.5/weather";
        Response response=given().queryParam("lat", lat).queryParam("lon",lon)
                .queryParam("appid",
                "692bbaff8d7d4449f933a3913fbc4297")
                .expect().defaultParser(Parser.JSON)
                .when()
                .get("https://api.openweathermap.org/data/2.5/weather").then().extract().response();

        String str = response.asString();
        System.out.println(str);
        JsonPath js = new JsonPath(str);
        SoftAssert softAssert = new SoftAssert();
        double Actual_cod = js.get("cod");
        softAssert.assertEquals(Actual_cod,expected_cod);
        softAssert.assertAll();
        System.out.println(" ***  Validation success ***" );
        System.out.println( " Actual cod : " + Actual_cod +
                " Expected cod: " + expected_cod);


    }

    @Test
    public  void getZip()
    {
        String expected_city= "San Jose";
        RestAssured.baseURI="https://api.openweathermap.org/data/2.5/weather";
        Response res=given().queryParam("zip", 95134).queryParam("appid",
                "692bbaff8d7d4449f933a3913fbc4297")
                .expect().defaultParser(Parser.JSON)
                .when()
                .get("https://api.openweathermap.org/data/2.5/weather").then().extract().response();

        String str = res.asString();
        JsonPath js = new JsonPath(str);
        SoftAssert softAssert = new SoftAssert();
        String Actual_city = js.get("name");
        softAssert.assertEquals(Actual_city,expected_city);
        softAssert.assertAll();
        System.out.println(" ***  Validation success ***" );
        System.out.println( " Actual city : " + Actual_city +
                " Expected city: " + expected_city);

    }


}
