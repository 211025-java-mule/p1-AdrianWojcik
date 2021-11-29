package net.Revature.p1.MyWeatherSpring.Weather;

import net.Revature.p1.MyWeatherSpring.HttpClients.OpenWeather.OpenWeatherClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WeatherServiceTest {

    @Autowired
    WeatherRepository weatherRepository;

    @Autowired
    OpenWeatherClient openWeatherClient;

    @Test
    void SaveWeatherToDB() {

        Weather weather = new Weather();
        weather.setCity("Warsaw");
        weather.setDescription("Test");
        weatherRepository.save(weather);
        long id = weather.getId();

        Assertions.assertEquals(weatherRepository.findById(id).get(), weather);
    }


    @Test
    void deleteEntityFromDB() {
        Weather weather = new Weather();
        weather.setCity("Warsaw");
        weather.setDescription("Test");
        weatherRepository.save(weather);
        long count = weatherRepository.count();
        weatherRepository.delete(weather);

        Assertions.assertEquals(weatherRepository.count(), count-1);
    }

    @Test
    void getCityFormAPIOpenWeather() {
        String weather = openWeatherClient.getWeather("Warsaw");
    Assertions.assertEquals("Warsaw", openWeatherClient.getName());
    }

}