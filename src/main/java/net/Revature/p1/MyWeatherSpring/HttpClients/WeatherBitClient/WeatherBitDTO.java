package net.Revature.p1.MyWeatherSpring.HttpClients.WeatherBitClient;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Component
public class WeatherBitDTO {
    private ArrayList<Data> data = new ArrayList<>();

    @AllArgsConstructor
    @Getter
    @Setter
    @NoArgsConstructor
    class Data{
        private String city_name;
        private String valid_date;
        private float temp;
        private float wind_spd;
        private float wind_dir;
        private float slp;
        private float rh;
        private float snow;
        private float clouds;
        private float precip;
        private Weather weather;

    }
    @AllArgsConstructor
    @Getter
    @Setter
    @NoArgsConstructor
    class Weather{
        private String icon;
    }
}
