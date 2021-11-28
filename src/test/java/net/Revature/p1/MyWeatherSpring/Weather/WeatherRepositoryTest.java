package net.Revature.p1.MyWeatherSpring.Weather;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class WeatherRepositoryTest {

    @Autowired
    private WeatherRepository underTest;

    @Test
    void itShouldReturnTop4EntitiesByOrderByIdDesc() {
        //given

        //when
        //then
    }
}