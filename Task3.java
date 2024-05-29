import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

// Problem Statement

// Travel Itinerary Planner
// Create a travel itinerary planner that allows users to
// input destinations, dates, and preferences to generate
// a detailed travel plan. Include features like maps,
// weather information, and budget calculations.

class Destination {
    private String name;
    private Date arrivalDate;
    private Date departureDate;
    private double budget;

    public Destination(String name, Date arrivalDate, Date departureDate, double budget) {
        this.name = name;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.budget = budget;
    }

    public String getName() {
        return name;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public double getBudget() {
        return budget;
    }
}

class Itinerary {
    private List<Destination> destinations;

    public Itinerary() {
        this.destinations = new ArrayList<>();
    }

    public void addDestination(Destination destination) {
        destinations.add(destination);
    }

    public List<Destination> getDestinations() {
        return destinations;
    }
}

class WeatherService {
    public String getWeather(String location) {
        // Simulate fetching weather data
        return "Sunny, 25°C";
    }
}

class BudgetCalculator {
    public double calculateTotalBudget(Itinerary itinerary) {
        return itinerary.getDestinations().stream().mapToDouble(Destination::getBudget).sum();
    }
}

class MapService {
    public String getMap(String location) {
        // Simulate fetching map data
        return "Map data for " + location;
    }
}

public class Task3 {
    public static void main(String[] args) {
        Itinerary itinerary = new Itinerary();
        WeatherService weatherService = new WeatherService();
        BudgetCalculator budgetCalculator = new BudgetCalculator();
        MapService mapService = new MapService();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        while (true) {
            System.out.println("Enter destination name (or type 'done' to finish): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done")) {
                break;
            }

            System.out.println("Enter arrival date (yyyy-MM-dd): ");
            String arrivalDateString = scanner.nextLine();
            Date arrivalDate;
            try {
                arrivalDate = dateFormat.parse(arrivalDateString);
            } catch (Exception e) {
                System.out.println("Invalid date format. Please try again.");
                continue;
            }

            System.out.println("Enter departure date (yyyy-MM-dd): ");
            String departureDateString = scanner.nextLine();
            Date departureDate;
            try {
                departureDate = dateFormat.parse(departureDateString);
            } catch (Exception e) {
                System.out.println("Invalid date format. Please try again.");
                continue;
            }

            System.out.println("Enter budget for this destination: ");
            double budget;
            try {
                budget = Double.parseDouble(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid budget format. Please enter a number.");
                continue;
            }

            Destination destination = new Destination(name, arrivalDate, departureDate, budget);
            itinerary.addDestination(destination);
        }

        System.out.println("\nYour Travel Itinerary:");
        for (Destination destination : itinerary.getDestinations()) {
            System.out.println("Destination: " + destination.getName());
            System.out.println("Arrival Date: " + dateFormat.format(destination.getArrivalDate()));
            System.out.println("Departure Date: " + dateFormat.format(destination.getDepartureDate()));
            System.out.println("Weather: " + weatherService.getWeather(destination.getName()));
            System.out.println("Map: " + mapService.getMap(destination.getName()));
            System.out.println("Budget: $" + destination.getBudget());
            System.out.println();
        }

        double totalBudget = budgetCalculator.calculateTotalBudget(itinerary);
        System.out.println("Total Budget: $" + totalBudget);
    }
}

