package net.Revature.p1.MyWeatherSpring.HttpClients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class GoogleMapsClient {

    Logger logger = LoggerFactory.getLogger(GoogleMapsClient.class);

    private final String apiKey = "xxx";

    public String getMap(String city){

        logger.info("Connected to Google API for image = " + city);
        return "https://maps.googleapis.com/maps/api/staticmap?center=" + city + "&zoom=13&size=600x300&maptype=roadmap&markers=color:blue%7Clabel:S%7C40.702147,-74.015794&markers=color:green%7Clabel:G%7C40.711614,-74.012318&markers=color:red%7Clabel:C%7C40.718217,-73.998284&key="+ apiKey;
    }
}
