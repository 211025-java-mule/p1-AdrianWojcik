package net.Revature.p1.MyWeatherSpring.HttpClients.WeatherBitClient;

import com.google.gson.*;
import net.Revature.p1.MyWeatherSpring.HttpClients.HttpClientConnector;
import net.Revature.p1.MyWeatherSpring.HttpClients.HttpClientConnectorImpl;
import net.Revature.p1.MyWeatherSpring.HttpClients.WeatherClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.ArrayList;

@Component
@Qualifier("WeatherBit")
public class WeatherBitClient implements WeatherClient {

    private final Gson gson = new Gson();
    private final String apiKey = "9943b74d5df149679b49dec61891605a";
    private String name;
    private float temperature;
    private float pressure;
    private float humidity;
    private float snow;
    private float clouds;
    private float rain;

    public float getSnow() {
        return snow;
    }

    public void setSnow(float snow) {
        this.snow = snow;
    }

    public float getClouds() {
        return clouds;
    }

    public void setClouds(float clouds) {
        this.clouds = clouds;
    }

    public float getRain() {
        return rain;
    }

    public void setRain(float rain) {
        this.rain = rain;
    }

    private float windSpeed;
    private float windDirection;


    public String getName() {
        return name;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public float getWindDirection() {
        return windDirection;
    }

    @Override
    public String getWeather(String cityName) {
        HttpClientConnector httpClientConnector = new HttpClientConnectorImpl();
        String URL = String.format("https://api.weatherbit.io/v2.0/current?&city=%s&key=%s", cityName, apiKey);
        String responseBody = httpClientConnector.initializeHttpConnection(URL);
        System.out.println(responseBody);

        WeatherBitDTO weatherBitDTO = gson.fromJson(responseBody, WeatherBitDTO.class);
        String name = weatherBitDTO.getData().get(0).getCity_name();
        float temperature = weatherBitDTO.getData().get(0).getTemp();
        float pressure = weatherBitDTO.getData().get(0).getSlp();
        float humidity = weatherBitDTO.getData().get(0).getRh();
        float windSpeed = weatherBitDTO.getData().get(0).getWind_spd();
        float windDirection = weatherBitDTO.getData().get(0).getWind_dir();
        float snow = weatherBitDTO.getData().get(0).getSnow();
        float clouds = weatherBitDTO.getData().get(0).getClouds();
        float rain = weatherBitDTO.getData().get(0).getPrecip();


        /*JsonParser jsonParser = new JsonParser();
        JsonObject jo = (JsonObject) jsonParser.parse(responseBody);
        JsonArray jsonArray = jo.getAsJsonArray("data");
        ArrayList weather = gson.fromJson(jsonArray, ArrayList.class);*/


        this.name = name;
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.clouds = clouds;
        this.snow = snow;
        this.rain = rain;


        if (name == null) {
            System.err.println("Cannot connect to WeatherBit API");
        } else if (name != null) {
            System.err.println("Downloaded Data from WeatherBit API");
        }


        return null;
    }

}
