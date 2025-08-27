package com.tracker;

public class CarTrip extends Activity{
    private double distance;

    public CarTrip(double distance, double emissionFactor){
        super("Car Trip", emissionFactor);
        this.distance = distance;
    }

    //This override the abstract method in the parent class.
    @Override
    public double calculateEmissions(){
        return this.distance * this.emissionFactor;
    }

    //Getter --> get value of distance in km.
    public double getDistance(){
        return distance;
    }
}
