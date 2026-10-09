
class Vehicle {
  private String brand;
  private String model;
  private int year;

  public Vehicle(String brand, String model, int year) {
    this.brand = brand;
    this.model = model;
    this.year = year;
  }

  public String getBrand() {
    return brand;
  }

  public String getModel() {
    return model;
  }

  public int getYear() {
    return year;
  }

  // Common method inherited by child classes
  public void displayDetails() {
    System.out.println("Brand: " + brand);
    System.out.println("Model: " + model);
    System.out.println("Year: " + year);
  }

  // Parent class method
  public void start() {
    System.out.println("Vehicle is starting...");
  }
}

class Car extends Vehicle {
  private int numberOfDoors;

  public Car(String brand, String model, int year,
      int numberOfDoors) {
    super(brand, model, year);
    this.numberOfDoors = numberOfDoors;
  }

  public int getNumberOfDoors() {
    return numberOfDoors;
  }

  @Override
  public void displayDetails() {
    System.out.println("=== Car Details ===");
    super.displayDetails();
    System.out.println("Number of Doors: " + numberOfDoors);
  }

  @Override
  public void start() {
    System.out.println("Car is starting...");
  }
}

class Motorcycle extends Vehicle {
  private boolean hasGears;

  public Motorcycle(String brand, String model, int year,
      boolean hasGears) {
    super(brand, model, year);
    this.hasGears = hasGears;
  }

  public boolean hasGears() {
    return hasGears;
  }

  @Override
  public void displayDetails() {
    System.out.println("=== Motorcycle Details ===");
    super.displayDetails();
    System.out.println("Has Gears: " + hasGears);
  }

  @Override
  public void start() {
    System.out.println("Motorcycle is starting...");
  }
}

public class Main {
  public static void main(String[] args) {

    Car car = new Car("Toyota", "Innova", 2026, 4);

    Motorcycle motorcycle = new Motorcycle("Harley-Davidson", "Street 750",
        2023, true);

    car.displayDetails();
    car.start();

    System.out.println();

    motorcycle.displayDetails();
    motorcycle.start();
  }
}
