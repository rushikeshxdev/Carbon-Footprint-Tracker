package com.tracker;
/**
 * Represents a single activity that contributes to a carbon footprint.
 * This is an abstract class, serving as a blueprint for concrete activities.
 */
//An abstract class can't be instantiated on its own; it's a blueprint.
public abstract class Activity{
    protected String description;
    protected double emissionFactor;
/**
 * Constructs an Activity object.
 * * @param description A brief description of the activity (e.g., "Car Trip").
 * @param emissionFactor The emissions factor specific to this type of activity.
 */
    public Activity(String description, double emissionFactor){
        this.description = description;
        this.emissionFactor = emissionFactor;
    }
/**
 * Calculates the carbon emissions for this activity.
 * * @return The calculated emissions in kg of CO2.
 */
    public abstract double calculateEmissions();

    //Getter method --> To get description from user.
    public String getDescription(){
        return description;
    }
}