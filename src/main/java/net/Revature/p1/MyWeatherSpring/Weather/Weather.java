package net.Revature.p1.MyWeatherSpring.Weather;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class Weather {

    private Long Id;
    private String City;
    private String Description;
  //we  private String Date;
    private float AVGTemperature;
    private float AVGHumidity;
    private float AVGPressure;
    private float AVGWindSpeed;
    private float AVGWindDirection;
    private float Cloud;
    private float Snow;
    private float Rain;
}
