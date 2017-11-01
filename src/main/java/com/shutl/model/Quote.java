package com.shutl.model;

import java.util.*;

public class Quote {
    private String pickupPostcode;
    private String deliveryPostcode;
    // vehicle variable
    private String vehicle;
    // list of carriers
    List<Carrier> carriers = new ArrayList<>();
    private Long price;

    // map to store vehicle - markup entries
    private static final Map<String, Long> vehicleMap = Collections.unmodifiableMap(
            new HashMap<String, Long>() {{
                put("bicycle", (long) 0.10);
                put("motorbike", (long) 0.15);
                put("parcel_car", (long) 0.20);
                put("small_van", (long) 0.30);
                put("large_van", (long) 0.40);
            }});

    public Quote() {}

    // added vehicle attribute to both constructors
    public Quote(String pickupPostcode, String deliveryPostcode, String vehicle) {
        this.pickupPostcode = pickupPostcode;
        this.deliveryPostcode = deliveryPostcode;
        this.vehicle = vehicle;
    }

    public Quote(String pickupPostcode, String deliveryPostcode, String vehicle, Long price, List<Carrier> carriers) {
        this.pickupPostcode = pickupPostcode;
        this.deliveryPostcode = deliveryPostcode;
        this.vehicle = vehicle;
        this.price = price;
        this.carriers = carriers;
    }

    // get method vehicle attribute
    public String getVehicle(){
        return vehicle;
    }

    // set method for vehicle attribute
    public void setVehicle(String vehicle){
        this.vehicle = vehicle;
    }

    // method takes vehicle (String) and returns price markup
    public Long getVehicleMarkup(String vehicle){
        // if the vehicle's name is valid return the appropriate markup, else return 0
        if (vehicleMap.containsKey(vehicle)){
            return vehicleMap.get(vehicle);
        }
        else return 0L;
    }

    public String getPickupPostcode() {
        return pickupPostcode;
    }

    public void setPickupPostcode(String pickupPostcode) {
        this.pickupPostcode = pickupPostcode;
    }

    public String getDeliveryPostcode() {
        return deliveryPostcode;
    }

    public void setDeliveryPostcode(String deliveryPostcode) {
        this.deliveryPostcode = deliveryPostcode;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
