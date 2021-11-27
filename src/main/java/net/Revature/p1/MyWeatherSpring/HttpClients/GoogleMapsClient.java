package net.Revature.p1.MyWeatherSpring.HttpClients;

import org.springframework.stereotype.Component;

@Component
public class GoogleMapsClient {

    private final String apiKey = "AIzaSyBJ-vazF391IBggyLT3gNZwF9336oZuc-c";

    public String getMap(String city){
        return "https://maps.googleapis.com/maps/api/staticmap?center=" + city + "&zoom=13&size=600x300&maptype=roadmap&markers=color:blue%7Clabel:S%7C40.702147,-74.015794&markers=color:green%7Clabel:G%7C40.711614,-74.012318&markers=color:red%7Clabel:C%7C40.718217,-73.998284&key="+ apiKey;
    }
}
