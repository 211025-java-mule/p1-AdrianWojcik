package net.Revature.p1.MyWeatherSpring.Weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/MyWeather")
public class WeatherController {


    @Autowired
    WeatherService weatherService;
    @Autowired
    Weather weather;

    @GetMapping("")
    public String index(){
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
        model.addAttribute("history1", weather.getId());
        model.addAttribute("history2", weather.getId());
        model.addAttribute("history3", weather.getId());
        model.addAttribute("history4", weather.getId());

        return "index";
    }

    @PostMapping("")
    public String getCurretWeatherforCity(@RequestParam String cityName){
        weatherService.getCurrentWeather(cityName);

        return "redirect:/MyWeather/currentWeather";
    }



}
