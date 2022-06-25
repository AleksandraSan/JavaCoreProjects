package lesson7;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class WeatherResponce {
    private String Date;
    private String Temperature;


    public WeatherResponce( String Date, String Temperature){
        this.Date = Date;
        this.Temperature = Temperature;
    }

    public WeatherResponce()
    {

    }


    public String getTemperature() {
        return Temperature;
    }

    public void setTemperature(String temperature) {
        this.Temperature = temperature;
    }

    public String getDate() {
        return Date ;
    }

    public void setDate(String date) {
        this.Date = date;
    }

    @Override
    public String toString() {
        return "WeatherResponse{" +
                "date='" + Date + '\'' +
                ", temperature=" + Temperature +
                '}';
    }
}
