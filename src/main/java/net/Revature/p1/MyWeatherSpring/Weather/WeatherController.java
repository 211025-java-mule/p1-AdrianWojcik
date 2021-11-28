package net.Revature.p1.MyWeatherSpring.Weather;

import net.Revature.p1.MyWeatherSpring.HttpClients.GoogleMapsClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.format.DateTimeFormatter;



@Controller
@RequestMapping("/MyWeather")
public class WeatherController {

    Logger logger = LoggerFactory.getLogger(WeatherController.class);


    @Autowired
    WeatherService weatherService;
    @Autowired
    Weather weather;
    @Autowired
    GoogleMapsClient googleMapsClient;

    @GetMapping("")
    public String index() {
        return "index";
    }

    @GetMapping("/currentWeather")
    public String currentWeather(Model model) {
        model.addAttribute("cityName", weather.getCity());
        model.addAttribute("Maps", googleMapsClient.getMap(weather.getCity()));
        model.addAttribute("AVGTemp", weather.getAVGTemperature());
        model.addAttribute("Description", weather.getDescription());
        model.addAttribute("Cloudy", weather.getCloud());
        model.addAttribute("Humidity", weather.getAVGHumidity());
        model.addAttribute("WindSpeed", weather.getAVGWindSpeed());
        model.addAttribute("Rain", weather.getRain());
        model.addAttribute("myPath", "/images/"+weather.getImage()+".png");
        model.addAttribute("TimeDate", weather.getDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        model.addAttribute("history1", weatherService.getHistory().get(0).getCity());
        model.addAttribute("history2", weatherService.getHistory().get(1).getCity());
        model.addAttribute("history3", weatherService.getHistory().get(2).getCity());
        model.addAttribute("history4", weatherService.getHistory().get(3).getCity());

        return "index";
    }

    @PostMapping("")
    public String getCurrentWeatherForCity(@RequestParam String cityName) {
        String valid = cityName.replace(" ", "+");
        if (valid.matches("[a-zA-Z+]+") || valid.length() <= 2) {
            weatherService.getCurrentWeather(valid);
        } else {
            System.out.println(" \nPlease enter a letters only");
            logger.info("Input Mismatch Exception");
        }
        return "redirect:/MyWeather/currentWeather";
    }
    @GetMapping("/history/{city}")
    public String showHistoricalForecast(@PathVariable String city, Model model){
        model.addAttribute("cityName", weatherService.getHistoryByCity(city).listIterator().next().getCity());
        model.addAttribute("Maps", googleMapsClient.getMap(weatherService.getHistoryByCity(city).listIterator().next().getCity()));
        model.addAttribute("AVGTemp", weatherService.getHistoryByCity(city).listIterator().next().getAVGTemperature());
        model.addAttribute("Description", weatherService.getHistoryByCity(city).listIterator().next().getDescription());
        model.addAttribute("Cloudy", weatherService.getHistoryByCity(city).listIterator().next().getCloud());
        model.addAttribute("Humidity", weatherService.getHistoryByCity(city).listIterator().next().getAVGHumidity());
        model.addAttribute("WindSpeed", weatherService.getHistoryByCity(city).listIterator().next().getAVGWindSpeed());
        model.addAttribute("Rain", weatherService.getHistoryByCity(city).listIterator().next().getRain());
        model.addAttribute("myPath", "/images/"+weatherService.getHistoryByCity(city).listIterator().next().getImage()+".png");
        model.addAttribute("TimeDate", weatherService.getHistoryByCity(city).listIterator().next().getDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        model.addAttribute("history1", weatherService.getHistory().get(0).getCity());
        model.addAttribute("history2", weatherService.getHistory().get(1).getCity());
        model.addAttribute("history3", weatherService.getHistory().get(2).getCity());
        model.addAttribute("history4", weatherService.getHistory().get(3).getCity());
        return "index";
    }

    @GetMapping("/currentWeather/{id}")
    public String deleteByCity ( @PathVariable long id){
        weatherService.deleteByCity(id);
        return "redirect:/MyWeather/currentWeather";
    }

}
