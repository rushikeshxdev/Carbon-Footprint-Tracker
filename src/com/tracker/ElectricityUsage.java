package com.tracker;

public class ElectricityUsage extends Activity {
    private double kilowattHours;

    // Constructor to initialize the object
    public ElectricityUsage(double kilowattHours, double emissionFactor) {
        // Call the parent constructor
        super("Electricity Usage", emissionFactor);
        this.kilowattHours = kilowattHours;
    }

    // Method to calculate emissions.
    // Overrides the abstract method in the parent class.
    @Override
    public double calculateEmissions() {
        return this.kilowattHours * this.emissionFactor;
    }

    // Encapsulation: A public method to get the value of a private field
    public double getKilowattHours() {
        return this.kilowattHours;
    }
}