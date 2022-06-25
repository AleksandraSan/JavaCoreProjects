package lesson8.entity;

public class Weather {
    private String city;
    private String localdate;
    private String minTemperature;
    private String maxTemperature;

    public Weather(String city, String localdate, String maxTemperature, String minTemperature) {
        this.city = city;
        this.localdate = localdate;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;

    }

    public String getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(String maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public String getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(String minTemperature) {
        this.minTemperature = minTemperature;
    }

    public String getLocaldate() {
        return localdate;
    }

    public void setLocaldate(String localdate) {
        this.localdate = localdate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "city='" + city + '\'' +
                ", localdate='" + localdate + '\'' +
                ", minTemperature=" + minTemperature +
                ", maxTemperature=" + maxTemperature +
                '}';
    }
}
