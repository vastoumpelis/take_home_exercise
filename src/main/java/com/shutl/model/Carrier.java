package com.shutl.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// Carrier class
public class Carrier implements Serializable {

    // a carrier has a name, a base price and a list of services
    private String name;
    private int base_price;
    private final List<CarrierService> services = new ArrayList<>();

    //constructor
    public Carrier(String name, int base_price, List<CarrierService> services){
        this.name = name;
        this.base_price = base_price;
        if (services != null) {
            this.services.addAll(services);
        }
    }

    // get methods
    public String getName(){
        return name;
    }

    public int getBase_price(){
        return base_price;
    }

    public List<CarrierService> getServices(){
        return services;
    }

    // toString method for better visualisation and debugging
    public String toString() {
        String servicesString = "";
        for (CarrierService cs : services){
            servicesString += "\n" + cs.toString();
        }

        return "Carrier: "+ name + " Base price: " + base_price + "Services: " +services.toString() ;
    }
}
