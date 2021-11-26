package net.Revature.p1.MyWeatherSpring.Weather;

import lombok.Data;
import org.springframework.stereotype.Component;


import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table
@Component
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;
    private String City;
    private String Description;
    private LocalDateTime DateTime;
    private float AVGTemperature;
    private float AVGHumidity;
    private float AVGPressure;
    private float AVGWindSpeed;
    private float AVGWindDirection;
    private float Cloud;
    private float Snow;
    private float Rain;
}
