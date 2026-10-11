# Java OOP Project 03: Polymorphism — Payment Processing System

A beginner-friendly Java project that demonstrates **Method Overriding and Runtime Polymorphism** through a payment processing system.

This project is part of my `java-oops-capstone-projects` repository, where I practise Object-Oriented Programming concepts through real-world examples.

**Concepts covered:** Inheritance, Constructors, `super()`, Method Overriding, Runtime Polymorphism, Parent-Class References, and User Input using `Scanner`.

> **Note:** This project focuses on runtime polymorphism. Abstract classes and interfaces are not used because they are covered in the Abstraction topic.

---

## Table of Contents

1. [Problem Statement](#1-problem-statement)
2. [Project Requirements](#2-project-requirements)
3. [What Is Polymorphism?](#3-what-is-polymorphism)
4. [Understanding Reference and Object](#4-understanding-reference-and-object)
5. [Project Structure](#5-project-structure)
6. [Complete Source Code](#6-complete-source-code)
7. [Understanding the Code](#7-understanding-the-code)
8. [How Runtime Polymorphism Works](#8-how-runtime-polymorphism-works)
9. [Why Use a Parent-Class Reference?](#9-why-use-a-parent-class-reference)
10. [Can We Use Child Objects Directly?](#10-can-we-use-child-objects-directly)
11. [Switch Statement vs Polymorphism](#11-switch-statement-vs-polymorphism)
12. [Compile-Time vs Runtime Polymorphism](#12-compile-time-vs-runtime-polymorphism)
13. [Expected Output](#13-expected-output)
14. [How to Run the Project](#14-how-to-run-the-project)
15. [Practice Challenges](#15-practice-challenges)
16. [Key Takeaways](#16-key-takeaways)

---

## 1. Problem Statement

Imagine you are developing an online shopping application where customers can pay using different payment methods, such as UPI, credit cards, and net banking.

All payment methods perform the same general operation — processing a payment — but each method has its own implementation and may require different information.

Your task is to develop a **Payment Processing System in Java** that allows users to select a payment method, enter the payment amount, provide the required details, and see a payment-specific message.

Create a parent class named `Payment` and three child classes named `UpiPayment`, `CreditCardPayment`, and `NetBankingPayment`.

Each child class must override the parent's `processPayment()` method to provide its own implementation.

The program must use a parent-class reference to handle different child objects and demonstrate how the same method call can execute different implementations depending on the actual object.

### Functional Requirements

**1. Create the parent class `Payment`**

- Declare a `protected` field named `amount` of type `double`.
- Create a constructor to initialize the amount.
- Create a general `processPayment()` method.

**2. Create the child class `UpiPayment`**

- Extend the `Payment` class.
- Add a private field named `upiId`.
- Use `super(amount)` to initialize the inherited amount.
- Override `processPayment()` to display UPI-specific information.

**3. Create the child class `CreditCardPayment`**

- Extend the `Payment` class.
- Add a private field named `cardNumber`.
- Use `super(amount)` to initialize the inherited amount.
- Override `processPayment()` to display credit-card-specific information.

**4. Create the child class `NetBankingPayment`**

- Extend the `Payment` class.
- Add a private field named `bankName`.
- Use `super(amount)` to initialize the inherited amount.
- Override `processPayment()` to display net-banking-specific information.

**5. Create the `Main` class**

- Display a menu of available payment methods.
- Allow the user to select a payment method.
- Read the payment amount.
- Request the details required for the selected method.
- Create the appropriate child object.
- Store that object in a `Payment` reference.
- Call `payment.processPayment()` to execute the selected implementation.

### Rules

- Use `extends` for inheritance.
- Use `super()` in child constructors.
- Use `@Override` for overridden methods.
- Do not use abstract classes or interfaces in this version.
- Do not use a `switch` statement to decide which payment implementation executes after the object has been created.

---

## 2. Project Requirements

### Technologies Used

- **Language:** Java
- **Concept:** Object-Oriented Programming
- **Input:** Java `Scanner`
- **Tools:** JDK and a Java IDE or terminal

### Project Structure

```text
03-polymorphism-payment-system/
├── src/
│   └── Main.java
└── README.md
```

For simplicity, all classes are placed in `Main.java`. Only the `Main` class is declared `public`.

---

## 3. What Is Polymorphism?

**Polymorphism means "many forms."**

In Java, polymorphism allows the same operation or method call to behave differently depending on the object or arguments involved.

In this project, all payment classes have a method named `processPayment()`, but each class provides a different implementation.

- `UpiPayment` processes a UPI payment.
- `CreditCardPayment` processes a credit card payment.
- `NetBankingPayment` processes a net banking payment.

### Class Relationship

```text
                    Payment
                       |
          processPayment() method
                       |
          ┌────────────┼────────────┐
          |            |            |
     UpiPayment   CreditCardPayment   NetBankingPayment
          |            |            |
      UPI logic     Card logic     Bank logic
```

All three child classes inherit from `Payment` and override its `processPayment()` method.

This is an example of **runtime polymorphism**, which works through method overriding.

### Why Is Polymorphism Useful?

Suppose your application supports ten payment methods.

Without a common design, you may end up writing separate processing methods for each payment type.

With polymorphism, you can create one common method that accepts a `Payment` reference and works with different payment objects.

This reduces repeated calling logic and makes it easier to extend the application.

---

## 4. Understanding Reference and Object

This is one of the most important concepts in this project.

Consider:

```java
Payment payment = new UpiPayment(500, "user@upi");
```

This statement has two important parts.

### Left side: `Payment payment`

This declares a reference variable named `payment` whose declared type is `Payment`.

### Right side: `new UpiPayment(500, "user@upi")`

This creates an actual object of the `UpiPayment` class.

The reference points to the newly created object.

```text
Reference Variable                 Actual Object
+-------------------+             +-------------------+
| Payment payment   | ----------> | UpiPayment        |
| Reference type:   |             | Object type:      |
| Payment           |             | UpiPayment        |
+-------------------+             +-------------------+
```

**Important:** The object created is `UpiPayment`, not `Payment`.

The `Payment` type is used for the reference. It does not cause a separate parent object to be created.

### What Does the Reference Type Control?

The reference type determines which methods are accessible through that reference at compile time.

Because `processPayment()` is declared in `Payment`, this is valid:

```java
payment.processPayment();
```

But if a method is declared only inside `UpiPayment` and is not available through `Payment`, you cannot call it directly through a `Payment` reference.

### What Determines Which Overridden Method Runs?

For an overridden instance method, Java uses the actual object's class at runtime.

```java
Payment payment = new UpiPayment(500, "user@upi");
payment.processPayment();
```

Java executes `UpiPayment`'s implementation of `processPayment()`.

The reference type is `Payment`, but the actual object is `UpiPayment`.

---

## 5. Project Structure

The project contains four classes in one source file.

```text
03-polymorphism-payment-system/
├── src/
│   └── Main.java
└── README.md
```

The classes are:

- `Payment` — parent class.
- `UpiPayment` — UPI payment implementation.
- `CreditCardPayment` — credit card payment implementation.
- `NetBankingPayment` — net banking payment implementation.
- `Main` — handles user input and starts payment processing.

---

## 6. Complete Source Code

Save the following code in `src/Main.java`.

```java
import java.util.Scanner;

class Payment {

    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public void processPayment() {
        System.out.println(
            "Processing payment of amount: ₹" + amount
        );
    }
}

class UpiPayment extends Payment {

    private String upiId;

    public UpiPayment(double amount, String upiId) {
        super(amount);
        this.upiId = upiId;
    }

    @Override
    public void processPayment() {
        System.out.println("\nProcessing UPI payment...");
        System.out.println("Amount: ₹" + amount);
        System.out.println("UPI ID: " + upiId);
        System.out.println("UPI payment successful!");
    }
}

class CreditCardPayment extends Payment {

    private String cardNumber;

    public CreditCardPayment(
        double amount,
        String cardNumber
    ) {
        super(amount);
        this.cardNumber = cardNumber;
    }

    @Override
    public void processPayment() {
        System.out.println(
            "\nProcessing credit card payment..."
        );
        System.out.println("Amount: ₹" + amount);

        System.out.println(
            "Card ending in: "
            + cardNumber.substring(cardNumber.length() - 4)
        );

        System.out.println(
            "Credit card payment successful!"
        );
    }
}

class NetBankingPayment extends Payment {

    private String bankName;

    public NetBankingPayment(
        double amount,
        String bankName
    ) {
        super(amount);
        this.bankName = bankName;
    }

    @Override
    public void processPayment() {
        System.out.println(
            "\nProcessing net banking payment..."
        );
        System.out.println("Amount: ₹" + amount);
        System.out.println("Bank: " + bankName);
        System.out.println(
            "Net banking payment successful!"
        );
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== PAYMENT SYSTEM =====");
        System.out.println("1. UPI Payment");
        System.out.println("2. Credit Card Payment");
        System.out.println("3. Net Banking Payment");

        System.out.print("Select payment method: ");
        int choice = sc.nextInt();

        System.out.print("Enter payment amount: ₹");
        double amount = sc.nextDouble();

        sc.nextLine(); // Consume the leftover newline.

        if (amount <= 0) {
            System.out.println(
                "Invalid amount. Enter an amount greater than zero."
            );
            sc.close();
            return;
        }

        Payment payment = null;

        switch (choice) {

            case 1:
                System.out.print("Enter your UPI ID: ");
                String upiId = sc.nextLine();

                payment = new UpiPayment(amount, upiId);
                break;

            case 2:
                System.out.print(
                    "Enter your card number (16 digits): "
                );

                String cardNumber = sc.nextLine();

                if (!cardNumber.matches("\\d{16}")) {
                    System.out.println(
                        "Invalid card number. Enter 16 digits."
                    );
                    sc.close();
                    return;
                }

                payment = new CreditCardPayment(
                    amount,
                    cardNumber
                );
                break;

            case 3:
                System.out.print("Enter your bank name: ");
                String bankName = sc.nextLine();

                payment = new NetBankingPayment(
                    amount,
                    bankName
                );
                break;

            default:
                System.out.println(
                    "Invalid payment method selected."
                );
                sc.close();
                return;
        }

        // Runtime polymorphism
        payment.processPayment();

        sc.close();
    }
}
```

---

## 7. Understanding the Code

### 7.1 Parent Class — `Payment`

```java
class Payment {

    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public void processPayment() {
        System.out.println(
            "Processing payment of amount: ₹" + amount
        );
    }
}
```

The parent class contains the common payment amount and a general `processPayment()` method.

The `protected` field allows child classes to access the inherited amount.

For larger projects, private fields with getter methods may be preferable to maintain stronger encapsulation.

### 7.2 Child Class — `UpiPayment`

```java
class UpiPayment extends Payment {

    private String upiId;

    public UpiPayment(double amount, String upiId) {
        super(amount);
        this.upiId = upiId;
    }

    @Override
    public void processPayment() {
        System.out.println("UPI payment successful!");
    }
}
```

`UpiPayment` inherits from `Payment`.

The constructor calls:

```java
super(amount);
```

This calls the parent constructor and initializes the inherited amount field.

The child class then initializes its own `upiId` field.

The `@Override` annotation indicates that `processPayment()` is intended to override the inherited method.

### 7.3 Other Child Classes

`CreditCardPayment` and `NetBankingPayment` follow the same pattern.

Each child class:

1. Extends `Payment`.
2. Calls `super(amount)`.
3. Stores its own payment-specific information.
4. Overrides `processPayment()`.

The method name is the same, but the implementations are different.

### 7.4 What Is `Payment payment = null;`?

```java
Payment payment = null;
```

This declares a reference variable of type `Payment`, but initially it does not refer to an object.

After the user selects a payment method, the `switch` assigns a suitable child object to that reference.

For UPI:

```java
payment = new UpiPayment(amount, upiId);
```

For credit card:

```java
payment = new CreditCardPayment(amount, cardNumber);
```

For net banking:

```java
payment = new NetBankingPayment(amount, bankName);
```

After a valid selection, `payment` refers to the selected object.

### 7.5 The Most Important Line

```java
payment.processPayment();
```

This line does not need to know the specific child class.

Java executes the overridden method belonging to the actual object.

This is runtime polymorphism.

---

## 8. How Runtime Polymorphism Works

Suppose the user selects UPI and enters ₹500.

### Step 1: Create the object

```java
payment = new UpiPayment(500, "user@upi");
```

The actual object is `UpiPayment`.

### Step 2: Store it in a parent reference

The reference variable is declared as:

```java
Payment payment;
```

This reference can refer to any compatible child object.

### Step 3: Call the method

```java
payment.processPayment();
```

### Step 4: Java executes the correct implementation

Because the actual object is `UpiPayment`, Java executes `UpiPayment.processPayment()`.

If the actual object is `CreditCardPayment`, Java executes `CreditCardPayment.processPayment()`.

If the actual object is `NetBankingPayment`, Java executes `NetBankingPayment.processPayment()`.

### The Rule

- **Reference type:** Determines which methods are accessible at compile time.
- **Actual object type:** Determines which overridden instance method runs at runtime.

---

## 9. Why Use a Parent-Class Reference?

This was one of the main questions while learning polymorphism.

You might ask:

"Why not create a UPI object directly and call its method?"

You absolutely can.

```java
UpiPayment upi = new UpiPayment(500, "user@upi");
upi.processPayment();
```

For one specific payment, this is perfectly valid.

The benefit of a parent reference becomes clearer when common code must work with different payment types.

```java
Payment payment = new UpiPayment(500, "user@upi");
payment.processPayment();

payment = new CreditCardPayment(
    1000,
    "1234567890123456"
);
payment.processPayment();

payment = new NetBankingPayment(
    1500,
    "Example Bank"
);
payment.processPayment();
```

The same variable can refer to different child objects over time.

The objects are still created using `new`. Polymorphism does not eliminate object creation. It allows code to work through a common parent type.

### Practical Example: One Common Processor

```java
static void process(Payment payment) {
    payment.processPayment();
}
```

Now the same method can process different payment types:

```java
process(new UpiPayment(500, "user@upi"));

process(new CreditCardPayment(
    1000,
    "1234567890123456"
));

process(new NetBankingPayment(
    1500,
    "Example Bank"
));
```

We need only one `process()` method. The actual object determines which overridden method runs.

This becomes useful as applications support more and more implementations.

---

## 10. Can We Use Child Objects Directly?

Yes. Both approaches work.

### Direct Child References

```java
UpiPayment upi = new UpiPayment(500, "user@upi");
upi.processPayment();

CreditCardPayment card =
    new CreditCardPayment(
        1000,
        "1234567890123456"
    );

card.processPayment();
```

This is straightforward when the code specifically needs child-only functionality.

### Parent References

```java
Payment payment = new UpiPayment(500, "user@upi");
payment.processPayment();

payment = new CreditCardPayment(
    1000,
    "1234567890123456"
);

payment.processPayment();
```

This is useful when the calling code needs only common payment operations and should work with different implementations.

| Question                                        | Answer                                                                   |
| ----------------------------------------------- | ------------------------------------------------------------------------ |
| Can I create child objects directly?            | Yes.                                                                     |
| Does a parent reference create a parent object? | No. `new UpiPayment(...)` creates a UPI object.                          |
| Does polymorphism remove object creation?       | No.                                                                      |
| Why use a parent reference?                     | To handle different child objects through one common type.               |
| Is polymorphism necessary for every program?    | No. It is useful when different implementations share a common contract. |

---

## 11. Switch Statement vs Polymorphism

The project uses a `switch`, so it is important to understand its role.

The `switch` handles the user's choice and object creation:

```java
switch (choice) {

    case 1:
        payment = new UpiPayment(amount, upiId);
        break;

    case 2:
        payment = new CreditCardPayment(
            amount,
            cardNumber
        );
        break;

    case 3:
        payment = new NetBankingPayment(
            amount,
            bankName
        );
        break;
}
```

After the object has been selected, the program calls:

```java
payment.processPayment();
```

There is no `switch` here to decide which implementation of `processPayment()` runs. Runtime polymorphism handles that.

Their responsibilities are different:

- **`switch`:** Which object should be created for the user's selection?
- **Polymorphism:** Which overridden method should run for the actual object?

In larger applications, a factory, configuration, or dependency injection can replace the selection logic. The underlying polymorphism principle remains the same.

---

## 12. Compile-Time vs Runtime Polymorphism

Java commonly teaches two forms of polymorphism.

### Compile-Time Polymorphism — Method Overloading

Methods have the same name but different parameter lists.

```java
class Calculator {

    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }
}
```

Java chooses the appropriate overload based on the arguments at compile time.

### Runtime Polymorphism — Method Overriding

A child class provides its own implementation of an inherited instance method.

```java
Payment payment = new UpiPayment(500, "user@upi");
payment.processPayment();
```

Java selects the overridden implementation based on the actual object's class at runtime.

| Overloading                                                | Overriding                                                    |
| ---------------------------------------------------------- | ------------------------------------------------------------- |
| Same method name, different parameter lists                | Same inherited method signature with a compatible return type |
| Selection at compile time                                  | Implementation selection at runtime                           |
| Commonly used for related operations with different inputs | Used for specialized behaviour in child classes               |

This project focuses on runtime polymorphism.

---

## 13. Expected Output

### Example A: UPI Payment

```text
===== PAYMENT SYSTEM =====
1. UPI Payment
2. Credit Card Payment
3. Net Banking Payment
Select payment method: 1
Enter payment amount: ₹500
Enter your UPI ID: user@upi

Processing UPI payment...
Amount: ₹500.0
UPI ID: user@upi
UPI payment successful!
```

### Example B: Credit Card Payment

```text
===== PAYMENT SYSTEM =====
1. UPI Payment
2. Credit Card Payment
3. Net Banking Payment
Select payment method: 2
Enter payment amount: ₹2000
Enter your card number (16 digits): 1234567890123456

Processing credit card payment...
Amount: ₹2000.0
Card ending in: 3456
Credit card payment successful!
```

### Example C: Net Banking Payment

```text
===== PAYMENT SYSTEM =====
1. UPI Payment
2. Credit Card Payment
3. Net Banking Payment
Select payment method: 3
Enter payment amount: ₹1500
Enter your bank name: Example Bank

Processing net banking payment...
Amount: ₹1500.0
Bank: Example Bank
Net banking payment successful!
```

These messages simulate payment processing. The program does not transfer real money.

---

## 14. How to Run the Project

### Prerequisites

- Java Development Kit (JDK) installed.
- IntelliJ IDEA, VS Code, or a terminal.

### Step 1: Compile the Code

From the project root:

```bash
javac src/Main.java
```

### Step 2: Run the Program

```bash
java -cp src Main
```

Alternatively, open the project in IntelliJ IDEA and run `Main`.

---

## 15. Practice Challenges

After understanding the project, try these exercises.

### Beginner

1. Add a `WalletPayment` child class.
2. Override `processPayment()` in `WalletPayment`.
3. Add a fourth menu option.
4. Explain why the new child object can be assigned to a `Payment` reference.

### Intermediate

5. Store multiple payment objects in a `Payment[]` array and process them with a loop.
6. Create a common `process(Payment payment)` method and pass different payment objects to it.
7. Try removing `@Override` and intentionally changing a method name. Observe why the annotation helps catch mistakes.

### Conceptual Questions

8. Why does `Payment payment = new UpiPayment(...)` compile?
9. Why does `payment.processPayment()` execute the UPI implementation?
10. What does the reference type control?
11. What does the actual object type control?
12. What is the difference between the `switch` statement and runtime polymorphism?
13. Can this program work without polymorphism? If yes, what might become repetitive as more payment types are added?

---

## 16. Key Takeaways

- **Inheritance:** Child classes reuse accessible functionality from a parent class.
- **Method overriding:** Child classes customize inherited instance methods.
- **Runtime polymorphism:** A common parent reference can invoke different overridden implementations based on the actual object.
- **Object creation still happens:** `new UpiPayment(...)` creates a UPI object, even when the reference type is `Payment`.
- **Direct child references are valid:** Parent references are useful when common code needs to work with different child implementations.
- **The `switch` and polymorphism have different roles:** The `switch` selects and creates the object; polymorphism selects the overridden method implementation.

### Final Concept to Remember

**One common method call, multiple possible implementations. The actual object's class determines which overridden instance method runs.**

This project is part of my journey to strengthen Java fundamentals before moving on to Abstraction, Interfaces, and Spring Boot backend development.
