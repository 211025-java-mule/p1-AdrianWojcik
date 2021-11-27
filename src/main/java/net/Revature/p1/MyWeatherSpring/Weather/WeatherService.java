package net.Revature.p1.MyWeatherSpring.Weather;

import net.Revature.p1.MyWeatherSpring.HttpClients.OpenWeather.OpenWeatherClient;
import net.Revature.p1.MyWeatherSpring.HttpClients.WeatherBitClient.WeatherBitClient;
import net.Revature.p1.MyWeatherSpring.HttpClients.WeatherClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


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

    @Autowired
    AVGWeatherCalculator avgWeatherCalculator;

    @Autowired
    WeatherRepository weatherRepository;


    public Weather getCurrentWeather(String cityName) {
        ArrayList<WeatherClient> weatherClients = new ArrayList<>();
        weatherClients.add(openWeatherClient);
        weatherClients.add(weatherBitClient);
        for(WeatherClient weatherClient : weatherClients){
            weatherClient.getWeather(cityName);
        }
        avgWeatherCalculator.calculateAVGWeatherParams();
        weatherRepository.save(weather);
        return weather;
    }

    public List<Weather> getHistory() {
       return weatherRepository.findTop4ByOrderByIdDesc();

    }

    public List<Weather> getString(String city){

        //TODO

        return null;
    }

}
