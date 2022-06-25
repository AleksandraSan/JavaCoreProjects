package lesson8;

import lesson8.entity.Weather;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseRepository {
    private static final String DB_PATH = "jdbc:sqlite:geekbrains_gb";
    private String insertWeather = "insert into weather (city, localdate, minTemperature, maxTemperature ) values (?, ?,?, ?)";
    private String getWeather = "select * from weather";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    //где один день будет вызываться вот этот метод
    public boolean saveWeatherToDataBase(Weather weather) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            PreparedStatement saveWeather = connection.prepareStatement(insertWeather);
            saveWeather.setString(1, weather.getCity());
            saveWeather.setString(2, weather.getLocaldate());
            saveWeather.setString(3, weather.getMinTemperature());
            saveWeather.setString(4, weather.getMaxTemperature());

            return saveWeather.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new SQLException("Сохранение в базу завершилось с ошибкой");
    }

    //сделать метод boolean
    public void saveWeatherToDataBase1 (List<Weather> weatherList) throws SQLException {
        try {
            Connection connection = DriverManager.getConnection(DB_PATH);
            PreparedStatement saveWeatherFiveDay = connection.prepareStatement(insertWeather);
            for (Weather weather : weatherList){
                saveWeatherFiveDay.setString(1, weather.getCity());
                saveWeatherFiveDay.setString(2, weather.getLocaldate());
                saveWeatherFiveDay.setString(3, weather.getMinTemperature());
                saveWeatherFiveDay.setString(4, weather.getMaxTemperature());
                saveWeatherFiveDay.addBatch();
            }
            saveWeatherFiveDay.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Weather> getSavedToDBWeather() {
        List<Weather> weatherList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getWeather);

            while (resultSet.next()){
                System.out.print(resultSet.getString("city"));
                System.out.print( " ");
                System.out.print(resultSet.getString("localdate"));
                System.out.print( " ");
                System.out.print(resultSet.getString("minTemperature"));
                System.out.print( " ");
                System.out.print(resultSet.getString("maxTemperature"));
                System.out.print( " ");
            }

            while ((resultSet.next())){
                weatherList.add(new Weather(
                        resultSet.getString("city"),
                        resultSet.getString("localdate"),
                        resultSet.getString("minTemperature"),
                        resultSet.getString("maxTemperature")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return weatherList;
    }

}
