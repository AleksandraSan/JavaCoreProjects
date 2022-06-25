package lesson8;

import lesson7.AccuweatherModel;
import lesson7.Period;
import lesson7.WeatherModel;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    private WeatherModel model = new AccuweatherModel();
    private Map<Integer, Period> variants = new HashMap<>();

    public Controller(){
        variants.put(1, Period.NOW);
        variants.put(5, Period.FIVE_DAY);
        variants.put(2, Period.DB);
    }

    public void getWeather(String userInput, String city) throws IOException {
        Integer command = Integer.parseInt(userInput);


        switch (variants.get(command)) {
            case NOW:
                model.getWeather(city, Period.NOW);
                break;

            case FIVE_DAY:
                model.getWeather(city, Period.FIVE_DAY);
                break;

            case DB:
                model.getSavedToDBWeather();
        }
    }
}
