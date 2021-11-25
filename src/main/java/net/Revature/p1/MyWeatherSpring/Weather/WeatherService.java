package net.Revature.p1.MyWeatherSpring.Weather;

import net.Revature.p1.MyWeatherSpring.HttpClients.OpenWeather.OpenWeatherClient;
import net.Revature.p1.MyWeatherSpring.HttpClients.WeatherBitClient.WeatherBitClient;
import net.Revature.p1.MyWeatherSpring.HttpClients.WeatherClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.ArrayList;



@Service
public class WeatherService {


    @Autowired
    @Qualifier("OpenWeather")
    OpenWeatherClient openWeatherClient;

    @Autowired
    @Qualifier("WeatherBit")
    WeatherBitClient weatherBitClient;

    @Autowired
    Weather weather;


/*
   private final OpenWeatherClient openWeatherClient;
   private final WeatherBitClient weatherBitClient;
   private final Weather weather;


    public WeatherService(OpenWeatherClient openWeatherClient, WeatherBitClient weatherBitClient, Weather weather) {
       this.weatherBitClient = weatherBitClient;
       this.openWeatherClient = openWeatherClient;
       this.weather = weather;
    }*/


    public void getCurrentWeather(String cityName) {
        ArrayList<WeatherClient> weatherClients = new ArrayList<>();
        weatherClients.add(openWeatherClient);
        weatherClients.add(weatherBitClient);
        for(WeatherClient weatherClient : weatherClients){
            weatherClient.getWeather(cityName);
        }
        save();
    }

    public void save() {
        weather.setCity(openWeatherClient.getName());
        weather.setDescription(openWeatherClient.getDescription());
        weather.setAVGTemperature(calculateAverageTemperature());
        weather.setAVGHumidity(calculateAverageHumidity());
        weather.setAVGPressure(calculateAveragePressure());
        weather.setAVGWindSpeed(calculateAverageWindSpeed());
        weather.setAVGWindDirection(calculateAverageWindDirection());
        weather.setCloud(weatherBitClient.getClouds());
        weather.setSnow(weatherBitClient.getSnow());
        weather.setRain(weatherBitClient.getRain());
    }

    public float calculateAverageTemperature() {
        int avgCounter = 0;
        if (openWeatherClient.getTemperature() != 0) {
            avgCounter++;
            if (weatherBitClient.getTemperature() != 0) {
                avgCounter++;
            }
        }
        float averageTemperature =
                (openWeatherClient.getTemperature() +
                        weatherBitClient.getTemperature()) / avgCounter;
        return averageTemperature;
    }

    public float calculateAverageHumidity() {
        int avgCounter = 0;
        if (openWeatherClient.getHumidity() != 0) {
            avgCounter++;
            if (weatherBitClient.getHumidity() != 0) {
                avgCounter++;
            }
        }
        float averageHumidity =
                (openWeatherClient.getHumidity() +
                        weatherBitClient.getHumidity()) / avgCounter;
        return averageHumidity;
    }

    public float calculateAveragePressure() {
        int avgCounter = 0;
        if (openWeatherClient.getPressure() != 0) {
            avgCounter++;
            if (weatherBitClient.getPressure() != 0) {
                avgCounter++;
            }
        }
        float averagePressure =
                (openWeatherClient.getPressure() +
                        weatherBitClient.getPressure()) / avgCounter;
        return averagePressure;
    }

    public float calculateAverageWindSpeed() {
        int avgCounter = 0;
        if (openWeatherClient.getWindSpeed() != 0) {
            avgCounter++;
            if (weatherBitClient.getWindSpeed() != 0) {
                avgCounter++;
            }
        }
        float averageWindSpeed =
                (openWeatherClient.getWindSpeed() +
                        weatherBitClient.getWindSpeed()) / avgCounter;
        return averageWindSpeed;
    }

    public float calculateAverageWindDirection() {
        int avgCounter = 0;
        if (openWeatherClient.getWindDirection() != 0) {
            avgCounter++;
            if (weatherBitClient.getWindDirection() != 0) {
                avgCounter++;
            }
        }
        float averageWindDirection =
                (openWeatherClient.getWindDirection() +
                        weatherBitClient.getWindDirection()) / avgCounter;
        return averageWindDirection;
    }
}
