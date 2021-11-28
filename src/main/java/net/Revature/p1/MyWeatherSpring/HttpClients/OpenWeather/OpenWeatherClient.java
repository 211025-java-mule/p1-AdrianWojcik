package net.Revature.p1.MyWeatherSpring.HttpClients.OpenWeather;


import com.google.gson.Gson;
import net.Revature.p1.MyWeatherSpring.HttpClients.HttpClientConnector;
import net.Revature.p1.MyWeatherSpring.HttpClients.HttpClientConnectorImpl;
import net.Revature.p1.MyWeatherSpring.HttpClients.WeatherClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;



@Component
@Qualifier("OpenWeather")
public class OpenWeatherClient implements WeatherClient {

    Logger logger = LoggerFactory.getLogger(OpenWeatherClient.class);

    private  final Gson gson = new Gson();
    private final String apiKey = "d2523d4ce5199ce659dcad17ce29e5ed";
    private String name;
    private float temperature;
    private float pressure;
    private float humidity;
    private float windSpeed;
    private float windDirection;
    private String description;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public float getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(float windDirection) {
        this.windDirection = windDirection;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getWeather(String cityName) {

        HttpClientConnector httpClientConnector = new HttpClientConnectorImpl();


        String URL = String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&units=metric&appid=%s", cityName, apiKey);
        String responseBody = httpClientConnector.initializeHttpConnection(URL);

        OpenWeatherDTO openWeatherDTO = gson.fromJson(responseBody, OpenWeatherDTO.class);

        String name = openWeatherDTO.getName();
        float temperature = openWeatherDTO.getMain().getTemp();
        float pressure = openWeatherDTO.getMain().getPressure();
        float humidity = openWeatherDTO.getMain().getHumidity();
        float windSpeed = openWeatherDTO.getWind().getSpeed();
        float windDirection = openWeatherDTO.getWind().getDeg();
        String description = openWeatherDTO.getWeather().get(0).getDescription();

        this.name = name;
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.description = description;

        if(name == null){
            logger.info("Cannot connect to OpenWeather API");
        }else if (name != null){
            logger.info("Downloaded Data from Open Weather API");
        }

        return null;
    }
}
