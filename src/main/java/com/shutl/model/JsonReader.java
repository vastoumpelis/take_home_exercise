package com.shutl.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader {

    // method requires a filename and the quote's vehicle and returns a List of Carriers (that can deliver with that vehicle)
    public List<Carrier> readCarriers(String filename, String vehicle){

        // arraylist to store and return carriers
        List<Carrier> carrierList = new ArrayList<>();
        // parser
        JSONParser parser = new JSONParser();

        try {
            JSONArray carriersArray = (JSONArray) parser.parse(new FileReader(filename));

            // iterate over carriers
            for (Object c : carriersArray)
            {
                // carrier's services list
                List<CarrierService> servicesList = new ArrayList<>();
                // carrier object
                JSONObject carrier = (JSONObject) c;

                // get carrier name
                String carrier_name = (String) carrier.get("carrier_name");
                // get base price
                int base_price = Integer.parseInt((String) carrier.get("base_price"));
                // get vehicles array
                JSONArray services = (JSONArray) carrier.get("services");

                // iterate over services of each carrier
                for (Object s : services)
                {
                    // service object
                    JSONObject service = (JSONObject) s;

                    // get delivery time
                    int delivery_time = Integer.parseInt((String) service.get("delivery_time"));
                    // get markup
                    int markup = Integer.parseInt((String) service.get("markup"));
                    // get List of vehicles
                    List<String> vehicles = Arrays.asList(service.get("vehicles").toString().split("\\s*,\\s*"));

                    //check if service's vehicle list contains the specified vehicle, if true add the service
                    if (vehicles.contains(vehicle)){
                        // add service to services list of current carrier
                        servicesList.add(new CarrierService(delivery_time, markup, vehicles));
                    }
                }

                // add the carrier to the carrier list
                carrierList.add(new Carrier(carrier_name, base_price, servicesList));
            }

        }catch (ParseException | IOException e) {
            e.printStackTrace();
        }

        return carrierList;
    }

}
