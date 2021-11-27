package net.Revature.p1.MyWeatherSpring.Weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;

import static java.time.format.DateTimeFormatter.ofLocalizedDateTime;
import static java.time.format.DateTimeFormatter.ofPattern;


@Controller
@RequestMapping("/MyWeather")
public class WeatherController {


    @Autowired
    WeatherService weatherService;
    @Autowired
    Weather weather;
    @Autowired
    WeatherRepository weatherRepository;

    @GetMapping("")
    public String index() {
        return "index";
    }

    @GetMapping("/currentWeather")
    public String currentWeather(Model model) {
        model.addAttribute("cityName", weather.getCity());
        model.addAttribute("AVGTemp", weather.getAVGTemperature());
        model.addAttribute("Description", weather.getDescription());
        model.addAttribute("Cloudy", weather.getCloud());
        model.addAttribute("Humidity", weather.getAVGHumidity());
        model.addAttribute("WindSpeed", weather.getAVGWindSpeed());
        model.addAttribute("Rain", weather.getRain());
        model.addAttribute("TimeDate", weather.getDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        model.addAttribute("history1", weatherService.getHistory().get(0).getCity());
        model.addAttribute("history2", weatherService.getHistory().get(1).getCity());
        model.addAttribute("history3", weatherService.getHistory().get(2).getCity());
        model.addAttribute("history4", weatherService.getHistory().get(3).getCity());

        return "index";
    }

    @PostMapping("")
    public String getCurrentWeatherForCity(@RequestParam String cityName) {
        weatherService.getCurrentWeather(cityName);

        return "redirect:/MyWeather/currentWeather";
    }
    @GetMapping("/history/{city}")
    public String showHistoricalForecast(@PathVariable String city, Model model){
        weatherService.getString(city);
        System.out.println(weatherService.getString(city));
        model.addAttribute("cityName", weatherService.getString(city).getCity());
        model.addAttribute("AVGTemp", weatherService.getString(city).getAVGTemperature());
        model.addAttribute("Description", weatherService.getString(city).getDescription());
        model.addAttribute("Cloudy", weatherService.getString(city).getCloud());
        model.addAttribute("Humidity", weatherService.getString(city).getAVGHumidity());
        model.addAttribute("WindSpeed", weatherService.getString(city).getAVGWindSpeed());
        model.addAttribute("Rain", weatherService.getString(city).getRain());
        model.addAttribute("TimeDate", weatherService.getString(city).getDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        model.addAttribute("history1", weatherService.getHistory().get(0).getCity());

        return "index";
    }


}
