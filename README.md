# Carbon Footprint Tracker

A simple command-line application built in Java that helps users track and manage their daily carbon emissions from various activities like driving and electricity usage. This project serves as a practical demonstration of key Object-Oriented Programming (OOP) principles.

## Features

* **Log Diverse Activities**: Users can log different types of activities, including car trips, bus trips, and electricity consumption.
* **Calculate Emissions**: The system calculates the carbon emissions for each logged activity.
* **Data Persistence**: Activities can be saved to and loaded from a file, allowing users to track their footprint over time.
* **Robust Input Handling**: The application gracefully handles invalid user input, preventing crashes.
* **Interactive Menu**: A user-friendly, menu-driven interface makes the application easy to use.

## OOP Concepts Demonstrated

This project was specifically designed to apply and showcase the following core OOP principles:

* **Inheritance**: The `CarTrip`, `BusTrip`, and `ElectricityUsage` classes **inherit** from a common parent, the `Activity` abstract class. This allows for a clean, hierarchical design and promotes code reuse. 
* **Polymorphism**: The `calculateEmissions()` method is **overridden** in each subclass. The main application uses a single `ArrayList<Activity>` and relies on polymorphism to call the correct calculation method for each specific object at runtime, simplifying the core logic.
* **Abstraction**: The `Activity` class is declared as **abstract**, defining a general blueprint and an abstract `calculateEmissions()` method that must be implemented by its subclasses. This hides the complex implementation details from the main `Tracker` class.
* **Encapsulation**: Critical data, such as a trip's distance or electricity usage, is stored in **private** fields and is only accessible through controlled, **public** getter methods (`getDistance()`, `getKilowattHours()`). This protects the data from unauthorized changes.

## How to Run the Application

This project is a standalone Java application. To run it, follow these steps:

1.  **Navigate to the Source Directory**: Open your terminal or command prompt and go to the `src` folder of the project.
    ```bash
    cd CarbonTracker/src
    ```
2.  **Compile the Code**: Use the Java compiler (`javac`) to compile all source files in the package.
    ```bash
    javac com/tracker/*.java
    ```
3.  **Run the Application**: Execute the main class (`Tracker`) using the Java Virtual Machine.
    ```bash
    java com.tracker.Tracker
    ```

Feel free to explore the code and extend the project with new features!