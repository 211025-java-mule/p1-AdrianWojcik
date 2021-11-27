package net.Revature.p1.MyWeatherSpring.Weather;


import net.Revature.p1.MyWeatherSpring.HttpClients.OpenWeather.OpenWeatherClient;
import net.Revature.p1.MyWeatherSpring.HttpClients.WeatherBitClient.WeatherBitClient;
import org.decimal4j.util.DoubleRounder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.time.LocalDateTime;


@Component
public class AVGWeatherCalculator {

    @Autowired
    OpenWeatherClient openWeatherClient;

    @Autowired
    WeatherBitClient weatherBitClient;

    @Autowired
    Weather weather;


    public Weather calculateAVGWeatherParams() {
        weather.setId(null);
        weather.setCity(openWeatherClient.getName());
        weather.setDescription(openWeatherClient.getDescription());
        weather.setAVGTemperature(calculateAverageTemperature());
        weather.setAVGHumidity(calculateAverageHumidity());
        weather.setAVGPressure(calculateAveragePressure());
        weather.setAVGWindSpeed(calculateAverageWindSpeed());
        weather.setAVGWindDirection(calculateAverageWindDirection());
        weather.setDateTime(LocalDateTime.now());
        weather.setCloud(weatherBitClient.getClouds());
        weather.setSnow(weatherBitClient.getSnow());
        weather.setRain(weatherBitClient.getRain());
        return weather;
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
        return (float) DoubleRounder.round(averageTemperature, 1);
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
        return (float) DoubleRounder.round(averageHumidity, 1);
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
        return (float) DoubleRounder.round(averagePressure, 1);
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
        return (float) DoubleRounder.round(averageWindSpeed, 1);
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
        return (float) DoubleRounder.round(averageWindDirection, 1);
    }



}
