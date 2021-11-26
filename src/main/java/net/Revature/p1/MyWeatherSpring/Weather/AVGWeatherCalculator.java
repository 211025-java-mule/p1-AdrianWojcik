package net.Revature.p1.MyWeatherSpring.Weather;


import net.Revature.p1.MyWeatherSpring.HttpClients.OpenWeather.OpenWeatherClient;
import net.Revature.p1.MyWeatherSpring.HttpClients.WeatherBitClient.WeatherBitClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AVGWeatherCalculator {

    @Autowired
    OpenWeatherClient openWeatherClient;

    @Autowired
    WeatherBitClient weatherBitClient;

    @Autowired
    Weather weather;

    @Autowired
    WeatherRepository weatherRepository;


    public Weather save() {
        weather.setCity(openWeatherClient.getName());
        weather.setDescription(openWeatherClient.getDescription());
        weather.setAVGTemperature(Math.round(calculateAverageTemperature()));
        weather.setAVGHumidity(Math.round(calculateAverageHumidity()));
        weather.setAVGPressure(Math.round(calculateAveragePressure()));
        weather.setAVGWindSpeed(Math.round(calculateAverageWindSpeed()));
        weather.setAVGWindDirection(Math.round(calculateAverageWindDirection()));
        weather.setCloud(Math.round(weatherBitClient.getClouds()));
        weather.setSnow(Math.round(weatherBitClient.getSnow()));
        weather.setRain(Math.round(weatherBitClient.getRain()));
        weatherRepository.save(weather);
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
