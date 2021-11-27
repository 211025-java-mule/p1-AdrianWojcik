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
    private Long id;
    private String city;
    private String description;
    private LocalDateTime dateTime;
    private float aVGTemperature;
    private float aVGHumidity;
    private float aVGPressure;
    private float aVGWindSpeed;
    private float aVGWindDirection;
    private float cloud;
    private float snow;
    private float rain;
    private String image;
}
