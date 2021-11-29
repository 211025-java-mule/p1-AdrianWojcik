package net.Revature.p1.MyWeatherSpring.Weather;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class WeatherControllerTest {

    @Autowired
    WeatherController weatherController;

    @Autowired
    MockMvc mockMvc;

    @Test
    void currentWeather() {
    }

    @Test
    void getCurrentWeatherForCity() {
    }

    @Test
    void showHistoricalForecast() {

    }
}