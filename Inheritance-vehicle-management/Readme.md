# Java OOP Project 02: Inheritance — Vehicle Management System

A beginner-friendly Java project that demonstrates **Inheritance, Encapsulation, Constructor Chaining, Method Overriding, and Code Reusability** through a practical Vehicle Management System.

This project is part of my `java-oops-capstone-projects` repository, where I practise Object-Oriented Programming (OOP) concepts through hands-on Java projects.

---

## Table of Contents

1. [Problem Statement](#1-problem-statement)
2. [Project Requirements](#2-project-requirements)
3. [What Is Inheritance?](#3-what-is-inheritance)
4. [Understanding the Class Structure](#4-understanding-the-class-structure)
5. [Understanding the Code](#5-understanding-the-code)
6. [Important Java Concepts](#6-important-java-concepts)
7. [Expected Output](#7-expected-output)
8. [How to Run the Project](#8-how-to-run-the-project)
9. [What I Learned](#9-what-i-learned)
10. [Practice Challenges](#10-practice-challenges)

---

## 1. Problem Statement

Imagine a vehicle showroom that manages different types of vehicles, including cars and motorcycles.

Every vehicle has common information, such as its brand, model, and manufacturing year. However, each type of vehicle also has its own specific properties. For example, a car has a certain number of doors, while a motorcycle may have gears.

If we create separate classes for each vehicle type without inheritance, we may need to duplicate common properties and methods. This makes the code repetitive and harder to maintain.

**Your task is to develop a Vehicle Management System in Java using inheritance.**

Design a parent class called `Vehicle` and two child classes called `Car` and `Motorcycle`. The child classes must reuse the common properties and methods of the parent class while adding their own specific properties and behaviours.

### Functional Requirements

**1. Create a parent class — `Vehicle`**

The class must contain:

- `brand` — vehicle manufacturer.
- `model` — vehicle model name.
- `year` — manufacturing year.
- A constructor to initialize these properties.
- A `displayDetails()` method to display common vehicle information.
- A `start()` method that prints a general vehicle starting message.

**2. Create a child class — `Car`**

The class must:

- Extend the `Vehicle` class.
- Include a `numberOfDoors` property.
- Use `super()` to initialize common vehicle properties.
- Display common vehicle details and car-specific information.
- Override `start()` with a car-specific message.

**3. Create a child class — `Motorcycle`**

The class must:

- Extend the `Vehicle` class.
- Include a `hasGears` property indicating whether the motorcycle has gears.
- Use `super()` to initialize common vehicle properties.
- Display common vehicle details and motorcycle-specific information.
- Override `start()` with a motorcycle-specific message.

**4. Create the `Main` class**

The program must:

- Create at least one `Car` object.
- Create at least one `Motorcycle` object.
- Display the complete details of both vehicles.
- Call the `start()` method for both objects.

### Implementation Rules

- Use `extends` to establish inheritance.
- Use `super()` to call the parent constructor.
- Keep common vehicle properties in `Vehicle`.
- Keep specific properties in their respective child classes.
- Use `@Override` when redefining inherited instance methods.
- Use private fields and appropriate public getter methods.
- Write clean, readable, reusable code.

---

## 2. Project Requirements

### Technologies Used

- **Language:** Java
- **Concept:** Object-Oriented Programming
- **Tools:** JDK and a Java code editor or terminal

### Project Structure

This beginner version keeps all four classes in one file.

```text
02-inheritance-vehicle-management/
├── Main.java
└── README.md
```

`Main.java` contains the `Vehicle`, `Car`, `Motorcycle`, and `Main` classes. Only `Main` is declared `public`.

---

## 3. What Is Inheritance?

**Inheritance is an Object-Oriented Programming concept in which a child class acquires accessible members of a parent class and can extend or customize its functionality.**

In Java, the `extends` keyword establishes inheritance between classes.

### Basic Example

```java
class Parent {
    void display() {
        System.out.println("Parent class");
    }
}

class Child extends Parent {
}
```

We can now write:

```java
Child obj = new Child();
obj.display();
```

Output:

```text
Parent class
```

The `Child` class does not define `display()`, but it inherits the accessible method from `Parent`.

### Why Do We Need Inheritance?

Without inheritance, we might have to write the same brand, model, year, and common display logic separately in both `Car` and `Motorcycle`.

With inheritance, these shared members are defined once in `Vehicle` and reused by its child classes.

**Main benefit:** Code reusability, less duplication, and easier maintenance.

---

## 4. Understanding the Class Structure

Our project represents the following relationship:

```text
                  Vehicle
                 /       \
               Car     Motorcycle
```

- `Vehicle` is the parent class.
- `Car` is a child class of `Vehicle`.
- `Motorcycle` is another child class of `Vehicle`.

This is an example of **hierarchical inheritance**, in which multiple child classes inherit from one parent class.

### Common and Specific Properties

| Vehicle            | Car                          | Motorcycle                    |
| ------------------ | ---------------------------- | ----------------------------- |
| `brand`            | `numberOfDoors`              | `hasGears`                    |
| `model`            | Car-specific `start()`       | Motorcycle-specific `start()` |
| `year`             | Car details                  | Motorcycle details            |
| `displayDetails()` | Overrides `displayDetails()` | Overrides `displayDetails()`  |
| `start()`          | Overrides `start()`          | Overrides `start()`           |

The child classes do not redeclare the common fields. They inherit the accessible methods from `Vehicle` and add their own functionality.

This relationship is also called an **is-a relationship**: a car is a vehicle, and a motorcycle is a vehicle.

---

## 5. Understanding the Code

### A. Parent Class — `Vehicle`

```java
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

    public void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
    }

    public void start() {
        System.out.println("Vehicle is starting...");
    }
}
```

The `Vehicle` class contains the common properties and methods shared by all vehicles in this project.

**Private fields**

```java
private String brand;
private String model;
private int year;
```

These fields store the vehicle's information. The `private` access modifier prevents direct access to these fields from other classes.

**Constructor**

```java
public Vehicle(String brand, String model, int year) {
    this.brand = brand;
    this.model = model;
    this.year = year;
}
```

The constructor initializes the fields when an object is created.

The `this` keyword refers to the current object. For example, `this.brand` refers to the object's field, while `brand` refers to the constructor parameter.

**Getter methods**

```java
public String getBrand() {
    return brand;
}
```

The getters provide controlled read access to the private fields. This is an example of encapsulation.

**Common methods**

- `displayDetails()` displays the common vehicle information.
- `start()` provides a general starting message that child classes can customize.

### B. Child Class — `Car`

```java
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
```

**1. Using `extends`**

```java
class Car extends Vehicle
```

This establishes the inheritance relationship. `Car` inherits accessible methods such as `getBrand()`, `getModel()`, `getYear()`, and `start()`.

**2. Adding a specific property**

```java
private int numberOfDoors;
```

This property belongs specifically to a car, so it is defined in `Car` rather than the general `Vehicle` class.

**3. Using `super()`**

```java
super(brand, model, year);
```

This invokes the parent constructor to initialize the common fields.

For example:

```java
Car car = new Car("Toyota", "Innova", 2026, 4);
```

The first three arguments are passed to the `Vehicle` constructor through `super()`. The fourth argument initializes `numberOfDoors`.

An explicit `super(...)` constructor call must be the first statement in the constructor.

**4. Overriding `displayDetails()`**

```java
@Override
public void displayDetails() {
    System.out.println("=== Car Details ===");
    super.displayDetails();
    System.out.println("Number of Doors: " + numberOfDoors);
}
```

The child class provides its own implementation of the inherited method.

`super.displayDetails()` calls the parent implementation, so we can reuse the common display logic and then add the number of doors.

**5. Overriding `start()`**

```java
@Override
public void start() {
    System.out.println("Car is starting...");
}
```

The car customizes the starting behaviour it inherits from `Vehicle`.

The `@Override` annotation helps the compiler verify that the method correctly overrides an inherited method.

### C. Child Class — `Motorcycle`

```java
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
```

The `Motorcycle` class follows the same inheritance pattern as `Car`, but it has its own specific property.

- `extends Vehicle` establishes inheritance.
- `super(...)` initializes the common vehicle properties.
- `hasGears` stores motorcycle-specific information.
- `displayDetails()` reuses the parent implementation and adds the motorcycle-specific property.
- `start()` overrides the parent's method with a motorcycle-specific message.

Notice that `brand`, `model`, and `year` are not redeclared in `Motorcycle`. They are already defined in `Vehicle`.

### D. Main Class

```java
public class Main {
    public static void main(String[] args) {

        Car car = new Car("Toyota", "Innova", 2026, 4);

        Motorcycle motorcycle =
                new Motorcycle("Harley-Davidson", "Street 750",
                               2023, true);

        car.displayDetails();
        car.start();

        System.out.println();

        motorcycle.displayDetails();
        motorcycle.start();
    }
}
```

The `main()` method is the program's entry point.

First, it creates a `Car` object and a `Motorcycle` object. Then it calls the methods on each object.

Both objects share the common functionality inherited from `Vehicle`, but their overridden methods display different details and starting messages.

---

## 6. Important Java Concepts

### 6.1 Inheritance vs. Encapsulation

These concepts work together, but they have different purposes.

| Concept              | Purpose                                         | Example                     |
| -------------------- | ----------------------------------------------- | --------------------------- |
| Inheritance          | Reuse and extend class functionality            | `Car extends Vehicle`       |
| Encapsulation        | Restrict direct access to fields                | `private String brand`      |
| Constructor chaining | Initialize the parent portion of a child object | `super(brand, model, year)` |
| Method overriding    | Customize inherited instance methods            | `Car.start()`               |
| Code reusability     | Avoid repeating common code                     | `Vehicle.displayDetails()`  |

### 6.2 What Does `super` Mean?

In this project, `super` is used in two different ways.

**Calling the parent constructor:**

```java
super(brand, model, year);
```

This initializes the parent-class fields.

**Calling a parent method:**

```java
super.displayDetails();
```

This executes the parent class's implementation of `displayDetails()`.

Both use `super`, but they perform different tasks.

### 6.3 What Is Method Overriding?

Method overriding occurs when a child class provides its own implementation of an inherited instance method with a compatible method signature.

For example:

```java
class Vehicle {
    public void start() {
        System.out.println("Vehicle is starting...");
    }
}

class Car extends Vehicle {
    @Override
    public void start() {
        System.out.println("Car is starting...");
    }
}
```

When we call `start()` on a `Car` object, the car-specific implementation executes.

### 6.4 What Is Runtime Polymorphism?

Consider:

```java
Vehicle vehicle = new Car("Toyota", "Innova", 2026, 4);
vehicle.start();
```

Output:

```text
Car is starting...
```

Although the reference type is `Vehicle`, the actual object is a `Car`. Java selects the overridden instance method at runtime.

This behaviour is called **runtime polymorphism**.

The reference type still determines which methods are accessible at compile time. For example, `vehicle.getNumberOfDoors()` will not compile because `getNumberOfDoors()` is declared only in `Car`, not in `Vehicle`.

### 6.5 Can a Child Class Directly Access a Private Parent Field?

No. A child class cannot directly access a private field declared in its parent class.

For example, `Car` cannot directly use `brand` because it is private in `Vehicle`.

Instead, the child can call an accessible getter such as `getBrand()` or use an inherited method such as `super.displayDetails()`.

The private field remains part of the parent-class portion of the object, but direct access is restricted.

---

## 7. Expected Output

```text
=== Car Details ===
Brand: Toyota
Model: Innova
Year: 2026
Number of Doors: 4
Car is starting...

=== Motorcycle Details ===
Brand: Harley-Davidson
Model: Street 750
Year: 2023
Has Gears: true
Motorcycle is starting...
```

The output demonstrates that both objects share the common vehicle details while displaying their own specific properties and starting messages.

---

## 8. How to Run the Project

### Prerequisites

- Java Development Kit (JDK) installed.
- A code editor or terminal.

### Step 1: Open the project folder

Navigate to the folder containing `Main.java`.

### Step 2: Compile the program

```bash
javac Main.java
```

If compilation succeeds, Java generates the required `.class` files.

### Step 3: Run the program

```bash
java Main
```

The expected output should appear in your terminal.

---

## 9. What I Learned

By completing this project, I practised:

- Creating parent and child classes.
- Using `extends` to implement inheritance.
- Reusing common properties and methods.
- Using `super()` for constructor chaining.
- Using `super.methodName()` to call a parent method.
- Overriding inherited methods with `@Override`.
- Combining inheritance with encapsulation.
- Understanding hierarchical inheritance.
- Understanding runtime polymorphism.

---

## 10. Practice Challenges

Try these exercises after understanding the implementation.

### Beginner

1. Create a `Truck` class that extends `Vehicle`.
2. Add a `loadCapacity` property to `Truck`.
3. Create a truck object and display its details.

### Intermediate

4. Add a `stop()` method to `Vehicle` and override it in `Car` and `Motorcycle`.
5. Create a `Vehicle` reference that points to a `Car` object and call `start()`.
6. Explain why the car-specific implementation executes even when the reference type is `Vehicle`.

### Advanced

7. Store multiple vehicle objects in a `Vehicle[]` array and loop through them, calling `displayDetails()` and `start()`.
8. Add constructor validation, such as rejecting a negative number of doors or an invalid manufacturing year.
9. Refactor the classes into separate Java files.

---

## Conclusion

The Vehicle Management System demonstrates how inheritance helps organize related classes and reuse common functionality.

Instead of implementing the same fields and methods repeatedly, we define them once in `Vehicle`. The `Car` and `Motorcycle` classes inherit the shared functionality and extend it with their own properties and behaviours.

**Key takeaway:** Inheritance represents an _is-a_ relationship. A car is a vehicle, and a motorcycle is a vehicle. This relationship allows us to reuse existing code while creating specialized classes.

This project is part of my journey to strengthen Java fundamentals before progressing to backend development with Spring Boot.
