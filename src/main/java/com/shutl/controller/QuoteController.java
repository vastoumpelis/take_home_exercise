package com.shutl.controller;

import com.shutl.model.Carrier;
import com.shutl.model.JsonReader;
import com.shutl.model.Quote;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class QuoteController {

    @RequestMapping(value = "/quote", method = POST)
    public @ResponseBody Quote quote(@RequestBody Quote quote) {
        // reader to read file and create a carriers list
        JsonReader jsonReader = new JsonReader();

        Long price = Math.abs((Long.valueOf(quote.getDeliveryPostcode(), 36) - Long.valueOf(quote.getPickupPostcode(), 36))/100000000);
        // add vehicle markup to the price
        price += price * quote.getVehicleMarkup(quote.getVehicle());

        return new Quote(quote.getPickupPostcode(), quote.getDeliveryPostcode(), quote.getVehicle(),
                price, jsonReader.readCarriers("data/carrier_data.json", quote.getVehicle()));
    }
}
