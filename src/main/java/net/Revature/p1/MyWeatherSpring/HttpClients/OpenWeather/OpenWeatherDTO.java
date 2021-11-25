package net.Revature.p1.MyWeatherSpring.HttpClients.OpenWeather;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Data
@Component
public class OpenWeatherDTO {

    private ArrayList<Weather> weather = new ArrayList<>();
    private String description;
    private Main main;
    private Wind wind;
    private String name;
    private float temp;
    private float pressure;
    private float humidity;
    private float speed;
    private float deg;

    @Data
    class Weather {
        private String description;
    }

    @Data
    class Main {
        private float temp;
        private float pressure;
        private float humidity;
    }

    @Data
    class Wind {
        private float speed;
        private float deg;
    }
}