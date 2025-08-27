package com.tracker;

public class BusTrip extends Activity {
    private double distance; // in kilometers

    // Constructor
    public BusTrip(double distance, double emissionFactor) {
        // Call the parent class (Activity) constructor
        super("Bus Trip", emissionFactor);
        this.distance = distance;
    }

    // Override the abstract method from the parent class
    @Override
    public double calculateEmissions() {
        // Bus emissions are typically lower per person than a car.
        return this.distance * this.emissionFactor;
    }

    // Getter method for distance
    public double getDistance() {
        return distance;
    }
}