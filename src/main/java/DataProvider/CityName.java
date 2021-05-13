package DataProvider;
import org.testng.annotations.DataProvider;

public class CityName {

    @DataProvider(name = "GoogleSearchCityDetails")
    public Object[][] getCity()
    {

        return new Object[][]  {{"California"},{"New York"},{"Portland"}};

    }}



