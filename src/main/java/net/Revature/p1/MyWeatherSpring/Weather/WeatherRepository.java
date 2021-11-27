package net.Revature.p1.MyWeatherSpring.Weather;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {

    public List<Weather> findTop4ByOrderByIdDesc();

  //  public List<Weather> findTop4ByOrderByCityDesc(String city);

}
