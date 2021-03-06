# WeatherDataAPI_Carta
**
**Approach : **
- Automated the open source weather API using rest assured DSL . 
- Passed the mandatory param to build the request .
- Used data provider to run for different data combinations.
- Used De-serialization approach( JSON - Object) to validate the response 
- Created object for JsonPath and validated the response fields .
- Used enums to store the final values. 


**Required in Framwork**

- JDK 8
- Android SDK 29
- Use OpenWeatherMap API
- Rest Assured
- TestNg
- POJO class
- Json path
- Data Provider 
- Enums 


API Calls :
--------------
**Test 1:**

API : api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key} 

**Mandatory Fields**
1) q	required	City name, state code and country code divided by comma, Please, refer to ISO 3166 for the state codes or country codes.
  You can specify the parameter not only in English. In this case, the API response should be returned in the same language as the language of requested location name if   location is in our predefined list of more than 200,000 locations.

2) appid	required	Your unique API key (you can always find it on your account page under the "API key" tab)

**Test 2:**

API : api.openweathermap.org/data/2.5/find?lat={lat}&lon={lon}&cnt={cnt}&appid={API key}

**Mandatory Fields**
1) lat, lon	required	Geographical coordinates (latitude, longitude)
2) appid	required	Your unique API key (you can always find it on your account page under the "API key" tab)

**Test 3:**

API  : api.openweathermap.org/data/2.5/weather?zip={zip code},{country code}&appid={API key}

**Mandatory Fields**
1) zip	required	Zip code
2) appid	required	Your unique API key (you can always find it on your account page under the "API key" tab)




