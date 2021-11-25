package net.Revature.p1.MyWeatherSpring.HttpClients;

import org.springframework.stereotype.Component;

@Component
public interface WeatherClient {
    String getWeather(String cityName);
}
