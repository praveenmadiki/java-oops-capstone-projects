# Java OOP Project 02: Inheritance — Vehicle Management System

A beginner-friendly Java project demonstrating **Inheritance, Encapsulation, Constructor Chaining, Method Overriding, and Code Reusability** through a vehicle management system.

This project is part of my `java-oops-capstone-projects` repository, where I practise Object-Oriented Programming concepts through practical projects.

---

## Table of Contents

1. [Project Overview](#project-overview)
2. [Problem Statement](#problem-statement)
3. [Project Requirements](#project-requirements)
4. [What Is Inheritance?](#what-is-inheritance)
5. [Real-World Example](#real-world-example)
6. [Project Structure](#project-structure)
7. [Understanding the Code](#understanding-the-code)
8. [Important Java Concepts](#important-java-concepts)
9. [Expected Output](#expected-output)
10. [How to Run the Project](#how-to-run-the-project)
11. [What I Learned](#what-i-learned)
12. [Practice Challenges](#practice-challenges)

---

## 1. Project Overview

The Vehicle Management System is a simple Java application that represents different types of vehicles using classes and inheritance.

A vehicle has common properties, such as its brand, model, and manufacturing year. However, specific vehicle types have their own properties and behaviours.

This project uses a parent class, `Vehicle`, and two child classes, `Car` and `Motorcycle`, to demonstrate how inheritance allows us to reuse common functionality while adding specialized features.

**Main objective:** Understand how inheritance works in Java by implementing a practical, real-world example.

---

## 2. Problem Statement

Imagine a vehicle showroom that manages different types of vehicles, including cars and motorcycles.

Every vehicle has common information, such as its brand, model, and manufacturing year. However, each type of vehicle also has its own specific properties. For example, a car has a certain number of doors, while a motorcycle may have gears.

If we create separate classes for each vehicle type without inheritance, we may need to duplicate common properties and methods. This makes the code repetitive and harder to maintain.

**Your task is to develop a Vehicle Management System in Java using inheritance.**

Design a common parent class called `Vehicle` and create two child classes, `Car` and `Motorcycle`, that inherit from it.

The child classes must reuse the common properties and methods of the parent class while defining their own specific properties and behaviours.

### Functional Requirements

**1. Create a parent class — `Vehicle`**

The class must contain:

- `brand` — the vehicle manufacturer.
- `model` — the vehicle model name.
- `year` — the manufacturing year.
- A constructor to initialize these properties.
- A `displayDetails()` method to display common vehicle information.
- A `start()` method that prints a general vehicle starting message.

**2. Create a child class — `Car`**

The class must:

- Extend the `Vehicle` class.
- Include a `numberOfDoors` property.
- Use `super()` to initialize the common vehicle properties.
- Display both common vehicle information and car-specific details.
- Override the `start()` method with a car-specific message.

**3. Create a child class — `Motorcycle`**

The class must:

- Extend the `Vehicle` class.
- Include a `hasGears` property to indicate whether the motorcycle has gears.
- Use `super()` to initialize the common vehicle properties.
- Display both common vehicle information and motorcycle-specific details.
- Override the `start()` method with a motorcycle-specific message.

**4. Create the `Main` class**

The main program must:

- Create at least one `Car` object.
- Create at least one `Motorcycle` object.
- Display the complete details of both vehicles.
- Call the `start()` method for both objects.

### Expected Behaviour

The program should display the common details of each vehicle along with its specific properties. It should also display different starting messages for cars and motorcycles.

For example:

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

### Implementation Rules

- Use `extends` to establish inheritance.
- Use `super()` to call the parent constructor.
- Keep the common vehicle properties in the `Vehicle` class.
- Keep vehicle-specific properties in their respective child classes.
- Use `@Override` when redefining inherited instance methods.
- Use private fields and suitable public getter methods.
- Write clean, readable, and reusable code.

---

## 3. Project Requirements

By completing this project, you should be able to explain:

- What inheritance is and why it is useful.
- How parent and child classes are related.
- How `extends` and `super()` work.
- How method overriding allows child classes to customize behaviour.
- How inheritance reduces unnecessary code duplication.
- How inheritance and encapsulation can be used together.

---

_The remaining sections explain the inheritance concept, the project structure, the implementation, the expected output, and how to run the program._
