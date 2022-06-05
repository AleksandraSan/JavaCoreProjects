package lesson6;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class BookingHome {
    public static void main(String[] args) throws IOException {
        OkHttpClient OkHttpClient = new OkHttpClient();
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("locations")
                .addPathSegment("v1")
                .addPathSegment("cities")
                .addPathSegment("search")
                .addQueryParameter("apikey", "zrVKYk6eD2OBukWlkQmgFzIl5dhyykov")
                .addQueryParameter("q", "Moscow")
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .addHeader("Accept", "application/json")
                .get()
                .build();

        Response response = OkHttpClient.newCall(request).execute();
        String responce = response.body().string();
        String responceKey = responce.split(",")[1];
        responceKey = responceKey.split(":")[1];
        responceKey = responceKey.replace("\"", "");
        System.out.println(responceKey);



        HttpUrl httpUrl1 =  new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment("")
                .addPathSegment(String.format(responceKey))
                .addQueryParameter("apikey", "zrVKYk6eD2OBukWlkQmgFzIl5dhyykov")
                .addQueryParameter("metric","true")
                .build();

        Request request1 = new Request.Builder()
                .url(httpUrl1)
                .addHeader("accept", "application/json")
                .get()
                .build();


        Response response1 = OkHttpClient.newCall(request1).execute();
        String responce1 = response1.body().string();
        System.out.println(responce1);
    }

}
