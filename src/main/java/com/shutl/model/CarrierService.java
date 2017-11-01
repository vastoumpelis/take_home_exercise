package com.shutl.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// carrier services class
public class CarrierService implements Serializable{

    // each carrier service has a delivery time, a markup to the price and a list of available vehicles
    private int delivery_time;
    private int markup;
    private final List<String> vehicles = new ArrayList<>();

    public CarrierService(int delivery_time, int markup, List<String> vehicles){
        this.delivery_time = delivery_time;
        this.markup = markup;
        if (vehicles != null) {
            this.vehicles.addAll(vehicles);
        }
    }

    // get methods
    public int getDelivery_time(){
        return delivery_time;
    }

    public int getMarkup(){
        return markup;
    }

    public List<String> getVehicles(){
        return vehicles;
    }

    // toString method for better visualisation and debugging
    public String toString(){
      return "Delivery time: " + delivery_time + " Markup: " + markup + " Vehicles: " + vehicles.toString();
    }

}
