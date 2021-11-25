package net.Revature.p1.MyWeatherSpring.Weather;

import com.fasterxml.jackson.core.JsonProcessingException;
import net.Revature.p1.MyWeatherSpring.HttpClients.OpenWeather.OpenWeatherClient;
import net.Revature.p1.MyWeatherSpring.HttpClients.WeatherBitClient.WeatherBitClient;
import net.Revature.p1.MyWeatherSpring.HttpClients.WeatherClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/MyWeather")
public class WeatherController {


    @Autowired
    Weather weather;

    @Autowired
    WeatherService weatherService;


    @GetMapping("/")
    public String hello() {
        weatherService.getCurrentWeather("warsaw");
        System.out.println(weather.getCity());
        System.out.println(weather.getDescription());
        System.out.println(weather.getRain());
        System.out.println(weather.getAVGTemperature());
        String a = weather.getCity();
        String b = weather.getDescription();
        float c = weather.getRain();
        float d = weather.getAVGTemperature();



        return a + b + c + d;
    }
}
