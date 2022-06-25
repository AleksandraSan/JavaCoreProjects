package lesson7;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AccuweatherModel implements WeatherModel {
    private static final String PROTOKOL = "http";
    private static final String HOST = "dataservice.accuweather.com";
    private static final String FORECASTS = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String ONE_DAY = "1day";
    private static final String FIVE_DAY = "5day";
    private static final String LOCATIONS = "locations";
    private static final String APIKEY = "zrVKYk6eD2OBukWlkQmgFzIl5dhyykov";
    private static final String APIKEY_QUERY_PARAM = "apikey";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";

    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();


    public void getWeather(String city, Period period) throws IOException {
        switch (period){
            case NOW:
                HttpUrl httpUrl = new HttpUrl.Builder()
                        .scheme(PROTOKOL)
                        .host(HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(ONE_DAY)
                        .addPathSegment(detectSity(city))
                        .addQueryParameter(APIKEY_QUERY_PARAM, APIKEY)
                        .addQueryParameter("metric", "true")
                        .build();

                Request request = new Request.Builder()
                        .url(httpUrl)
                        .build();

                Response oneDayResponse = okHttpClient.newCall(request).execute();
                String oneDayCodeKey = oneDayResponse.body().string();
                String jsonToJava = objectMapper.readTree(oneDayCodeKey).at("/DailyForecasts").get(0).at("/Date").asText();
                System.out.println(jsonToJava);
                String dateNew = jsonToJava.substring(0, jsonToJava.length()-15);
                System.out.println(dateNew);
                String minimalTemperature = objectMapper.readTree(oneDayCodeKey).at("/DailyForecasts").get(0).at("/Temperature/Minimum/Value").asText();
                String maximumTemperature = objectMapper.readTree(oneDayCodeKey).at("/DailyForecasts").get(0).at("/Temperature/Maximum/Value").asText();

                System.out.println("Погода в городе " + city + " на 1 день: " + dateNew + " максимальная температура воздуха " + maximumTemperature + " ,минимальная температура воздуха составляет " + minimalTemperature);
                break;


            case FIVE_DAY:
                HttpUrl httpUrl1 = new HttpUrl.Builder()
                        .scheme(PROTOKOL)
                        .host(HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(FIVE_DAY)
                        .addPathSegment(detectSity(city))
                        .addQueryParameter(APIKEY_QUERY_PARAM, APIKEY)
                        .addQueryParameter("metric", "true")
                        .build();

                Request requestFiveDay = new Request.Builder()
                        .url(httpUrl1)
                        .build();

                Response fiveDayResponce = okHttpClient.newCall(requestFiveDay).execute();
                String jsonString = fiveDayResponce.body().string();
                System.out.println(jsonString);

                for (int i = 0 ; i <= 4; i++ ){
                    String jsonFiveDay = objectMapper.readTree(jsonString).at("/DailyForecasts").get(i).at("/Date").asText();
                    String dateFiveDay = jsonFiveDay.substring(0, jsonFiveDay.length() - 15);
                    String temparatureFiveDayMax = objectMapper.readTree(jsonString).at("/DailyForecasts").get(i).at("/Temperature/Maximum/Value").asText();
                    String temperatureFiveDayMin = objectMapper.readTree(jsonString).at("/DailyForecasts").get(i).at("/Temperature/Minimum/Value").asText();
                    System.out.println( dateFiveDay + " в городе " + city + " максимальная температура воздуха " + temparatureFiveDayMax + " ,минимальная температура воздуха составляет " + temperatureFiveDayMin);
                }
                break;
        }
    }

    private static String detectSity(String cityName) throws IOException {
        //http://dataservice.accuweather.com/locations/v1/cities/search
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOKOL)
                .host(HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(VERSION)
                .addPathSegment(CITIES)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter(APIKEY_QUERY_PARAM, APIKEY)
                .addQueryParameter("q", cityName)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .addHeader("accept", "application/json")
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String responseString = response.body().string();

        String cityKey = objectMapper.readTree(responseString).get(0).at("/Key").asText();
        return cityKey;
    }
}
