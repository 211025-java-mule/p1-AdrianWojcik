package net.Revature.p1.MyWeatherSpring.Weather;

import net.Revature.p1.MyWeatherSpring.HttpClients.OpenWeather.OpenWeatherClient;
import net.Revature.p1.MyWeatherSpring.HttpClients.WeatherBitClient.WeatherBitClient;
import net.Revature.p1.MyWeatherSpring.HttpClients.WeatherClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class WeatherService {

    Logger logger = LoggerFactory.getLogger(WeatherService.class);


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
        logger.info("Saved Weather to DataBase");
        return weather;
    }

    public List<Weather> getHistory() {
        logger.info("Revived history from DataBase");
       return weatherRepository.findTop4ByOrderByIdDesc();

    }

    public List<Weather> getHistoryByCity(String city){
    logger.info("Revived history from Data base of City = " + city);

        return weatherRepository.findTop4ByOrderByIdDesc().stream()
                .filter(weather1 -> weather1.getCity().startsWith(city))
                .collect(Collectors.toList());

    }

    public String deleteByCity(long id){
        weatherRepository.deleteById(id);
        logger.info("Deleted item from DB of ID =" + id);
        return "OK";
    }

}
