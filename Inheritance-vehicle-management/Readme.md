Problem statement
Develop a Vehicle Management System in Java to demonstrate inheritance.
A vehicle showroom manages different types of vehicles, such as cars and motorcycles. Every vehicle has common details, but each type also has its own specific properties.
Your task is to design a parent class and child classes that reuse common properties and methods through inheritance.
Requirements

1. Create a parent class — Vehicle
   It must contain:

- brand — vehicle manufacturer
- model — vehicle model name
- year — manufacturing year
- A constructor to initialize these properties
- A method displayDetails() to display the vehicle's information
- A method start() that prints a general vehicle starting message

2. Create a child class — Car
   It must inherit from Vehicle and contain:

- numberOfDoors
- A method to display car-specific details
- Its own implementation of start()

3. Create a child class — Motorcycle
   It must inherit from Vehicle and contain:

- hasGear — whether the motorcycle has gears
- A method to display motorcycle-specific details
- Its own implementation of start()

4. Create the Main class
   Your program must:

- Create at least one Car object.
- Create at least one Motorcycle object.
- Display their complete details.
- Call the start() method for both objects.
  Expected output format
  Your exact wording can differ, but the output should contain information similar to this:
