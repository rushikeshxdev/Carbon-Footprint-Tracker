package com.tracker;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Tracker {
    // Correctly placed inside the Tracker class
    public static void saveActivities(ArrayList<Activity> activities, String filename) {
        try (java.io.FileWriter writer = new java.io.FileWriter(filename)) {
            for (Activity activity : activities) {
                if (activity instanceof CarTrip) {
                    CarTrip trip = (CarTrip) activity;
                    writer.write("CarTrip," + trip.getDistance() + "\n");
                } else if (activity instanceof BusTrip) {
                    BusTrip trip = (BusTrip) activity;
                    writer.write("BusTrip," + trip.getDistance() + "\n");
                } else if (activity instanceof ElectricityUsage) {
                    ElectricityUsage usage = (ElectricityUsage) activity;
                    writer.write("ElectricityUsage," + usage.getKilowattHours() + "\n");
                }
            }
            System.out.println("Activities saved to " + filename);
        } catch (java.io.IOException e) {
            System.out.println("An error occurred while saving activities: " + e.getMessage());
        }
    }

    // Correctly placed inside the Tracker class
    public static ArrayList<Activity> loadActivities(String filename) {
        ArrayList<Activity> activities = new ArrayList<>();
        final double CAR_EMISSION_FACTOR = 0.2;
        final double BUS_EMISSION_FACTOR = 0.05;
        final double ELECTRICITY_EMISSION_FACTOR = 0.5;

        try (java.util.Scanner fileScanner = new java.util.Scanner(new java.io.File(filename))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                String type = parts[0];
                double value = Double.parseDouble(parts[1]);

                switch (type) {
                    case "CarTrip":
                        activities.add(new CarTrip(value, CAR_EMISSION_FACTOR));
                        break;
                    case "BusTrip":
                        activities.add(new BusTrip(value, BUS_EMISSION_FACTOR));
                        break;
                    case "ElectricityUsage":
                        activities.add(new ElectricityUsage(value, ELECTRICITY_EMISSION_FACTOR));
                        break;
                }
            }
            System.out.println("Activities loaded from " + filename);
        } catch (java.io.IOException | NumberFormatException e) {
            System.out.println("An error occurred while loading activities: " + e.getMessage());
        }
        return activities;
    }

    public static void main(String[] args) {
        ArrayList<Activity> activities = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Define fixed emission factors
        final double CAR_EMISSION_FACTOR = 0.2;
        final double BUS_EMISSION_FACTOR = 0.05;
        final double ELECTRICITY_EMISSION_FACTOR = 0.5; // kg CO2 per kWh

        System.out.println("Welcome to the Carbon Footprint Tracker!");
        int choice;
        
        // Declare totalEmissions outside the loop so it can be accessed later
        double totalEmissions = 0.0;
        
        do {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Log a Car Trip");
            System.out.println("2. Log a Bus Trip");
            System.out.println("3. Log Electricity Usage");
            System.out.println("4. View Total Emissions");
            System.out.println("5. Save Activities");
            System.out.println("6. Load Activities");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline left-over

                switch (choice) {
                    case 1:
                        System.out.print("Enter distance (km): ");
                        try {
                            double carDistance = scanner.nextDouble();
                            activities.add(new CarTrip(carDistance, CAR_EMISSION_FACTOR));
                            System.out.println("Car trip logged successfully!");
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number for the distance.");
                            scanner.nextLine(); // Clear the invalid input from the scanner
                        }
                        break;
                    case 2:
                        System.out.print("Enter distance (km): ");
                        try {
                            double busDistance = scanner.nextDouble();
                            activities.add(new BusTrip(busDistance, BUS_EMISSION_FACTOR));
                            System.out.println("Bus trip logged successfully!");
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number for the distance.");
                            scanner.nextLine(); // Clear the invalid input
                        }
                        break;
                    case 3:
                        System.out.print("Enter kWh used: ");
                        try {
                            double kwh = scanner.nextDouble();
                            activities.add(new ElectricityUsage(kwh, ELECTRICITY_EMISSION_FACTOR));
                            System.out.println("Electricity usage logged successfully!");
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a number for kWh.");
                            scanner.nextLine(); // Clear the invalid input
                        }
                        break;
                    case 4:
                        totalEmissions = 0.0;
                        System.out.println("\n--- Your Daily Summary ---");
                        for (Activity activity : activities) {
                            double emissions = activity.calculateEmissions();
                            totalEmissions += emissions;
                            System.out.println(activity.getDescription() + " Emissions: " + emissions + " kg CO2");
                        }
                        System.out.println("--------------------------");
                        System.out.println("Total Carbon Emissions: " + totalEmissions + " kg CO2");
                        System.out.println("--------------------------");
                        break;
                    case 5:
                        saveActivities(activities, "activities.txt");
                        break;
                    case 6:
                        activities = loadActivities("activities.txt");
                        break;
                    case 0:
                        System.out.println("Exiting application. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice. Please enter a number from the menu.");
                scanner.nextLine(); // Clear the invalid input from the scanner
                choice = -1; // Set choice to an invalid value to continue the loop
            }

        } while (choice != 0);
        
        scanner.close();
    }
}