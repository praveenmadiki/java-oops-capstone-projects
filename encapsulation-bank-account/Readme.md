# 🏦 Bank Account Management System

A console-based Java application created to understand and demonstrate **Encapsulation**, one of the four fundamental pillars of Object-Oriented Programming.

This is the first project in my **Java OOP Capstone Projects** repository.

---

## 📌 Project Overview

The Bank Account Management System simulates basic banking operations through a command-line interface.

The user can:

- Create a bank account
- View account holder information
- View account number
- Check account balance
- Deposit money
- Withdraw money
- Exit the application

The main purpose of this project is not to build a complete banking application, but to understand how **Encapsulation** can be applied to protect an object's data and control how that data is accessed and modified.

---

# 🧠 OOP Concept: Encapsulation

## What is Encapsulation?

**Encapsulation is the process of wrapping data and the methods that operate on that data inside a class while controlling access to the data.**

In Java, encapsulation is commonly implemented using:

```text
private variables
      +
public methods
      =
controlled access to data
```

Instead of allowing other classes to directly modify the internal data, the class decides how that data can be accessed or changed.

---

# 🔐 How Encapsulation Is Used in This Project

The `BankAccount` class contains three important pieces of data:

```java
private String accountHolder;
private String accountNub;
private double currentBalance;
```

These variables are declared as `private`.

### Why `private`?

Because we don't want outside code to directly modify the account information.

For example, this should NOT be possible:

```java
person1.currentBalance = -50000;
```

or:

```java
person1.accountNub = "123";
```

If these variables were public, any part of the program could change them without validation.

By making them `private`, the data is protected inside the `BankAccount` class.

---

# 🔄 Controlled Access

Although the variables are private, we still need a way to work with them.

Therefore, the class provides public methods.

For example:

```java
public void depositMoney(double money) {
    if (money > 0) {
        currentBalance += money;
    }
}
```

The outside code cannot directly change:

```java
currentBalance
```

Instead, it must use:

```java
depositMoney()
```

This gives the class control over how the balance changes.

---

# 💰 Example: Deposit

Suppose the account has:

```text
Current Balance = ₹50,000
```

The user wants to deposit:

```text
₹5,000
```

The user calls:

```java
person1.depositMoney(5000);
```

Inside the class:

```java
if (money > 0) {
    currentBalance += money;
}
```

The class checks the input before modifying the balance.

This is **controlled access**.

---

# 💸 Example: Withdrawal

The withdrawal operation also uses encapsulation.

```java
public void withdraw(double withMoney) {

    if (withMoney > 0 && withMoney <= currentBalance) {
        currentBalance -= withMoney;
    }
}
```

The outside code cannot directly subtract money from the balance.

Instead, it must use:

```java
person1.withdraw(2500);
```

The `BankAccount` class checks:

1. Is the withdrawal amount greater than `0`?
2. Is the withdrawal amount less than or equal to the available balance?

Only after these conditions are satisfied is the balance changed.

---

# 🛡️ Why This Is Better

Without encapsulation:

```java
class BankAccount {

    public double balance;
}
```

Anyone could do:

```java
account.balance = -100000;
```

There is no protection.

With encapsulation:

```java
class BankAccount {

    private double balance;

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }
}
```

Now the class controls how its balance changes.

```text
Outside Code
     │
     │ cannot directly access
     ↓
private balance
     │
     │ controlled through
     ↓
public methods
     │
     ├── depositMoney()
     │
     └── withdraw()
```

---

# 🏗️ Constructor and Encapsulation

The constructor is also used to initialize the object's state.

```java
public BankAccount(
        String accountHolder,
        String accountNub,
        double currentBalance) {

    if (!accountHolder.isEmpty()) {
        this.accountHolder = accountHolder;
    }

    if (accountNub.length() == 12) {
        this.accountNub = accountNub;
    }

    if (currentBalance >= 0) {
        this.currentBalance = currentBalance;
    }
}
```

The constructor ensures that the object is initialized with valid information.

For example, the account number must contain exactly 12 characters.

---

# 🔎 Input Validation

The project also validates the account number before creating the `BankAccount` object.

Example:

```text
Enter 12-digit account number: 12345

Invalid account number!
Account number must contain exactly 12 digits.

Please enter again.
```

The user is asked again until a valid account number is entered.

This prevents an invalid account from being created.

---

# 🖥️ User Interaction

The application uses `Scanner` to accept user input.

The user is provided with a menu:

```text
===== BANK MENU =====

1. Show Account Holder
2. Show Account Number
3. Show Balance
4. Deposit Money
5. Withdraw Money
6. Exit
```

A `switch` statement performs the selected operation.

Example:

```java
switch (choice) {

    case 1:
        person1.getName();
        break;

    case 2:
        person1.getAccNo();
        break;

    case 3:
        person1.getBalance();
        break;

    case 4:
        person1.depositMoney(deposit);
        break;

    case 5:
        person1.withdraw(withdraw);
        break;

    case 6:
        continueBanking = false;
        break;
}
```

---

# 🔑 Where Exactly Is Encapsulation?

| Project Component | Encapsulation Usage       |
| ----------------- | ------------------------- |
| `accountHolder`   | `private` data            |
| `accountNub`      | `private` data            |
| `currentBalance`  | `private` data            |
| Constructor       | Controlled initialization |
| `getName()`       | Controlled reading        |
| `getAccNo()`      | Controlled reading        |
| `getBalance()`    | Controlled reading        |
| `depositMoney()`  | Controlled modification   |
| `withdraw()`      | Controlled modification   |
| Validation        | Protects object state     |

---

# 🧩 Encapsulation Flow

The overall design can be understood as:

```text
                BankAccount
                     │
          ┌──────────┴──────────┐
          │                     │
     PRIVATE DATA          PUBLIC METHODS
          │                     │
          │              ┌──────┼───────┐
          │              │      │       │
          ↓              ↓      ↓       ↓
   accountHolder       get    deposit  withdraw
   accountNub          methods
   currentBalance
          │
          ↓
    Protected State
```

The important idea is:

> **The outside world does not directly manipulate the object's internal data. The object itself controls how its data is accessed and modified.**

---

# 🎯 Learning Objectives

Through this project, I practiced:

- Understanding Encapsulation
- Using `private` variables
- Creating classes and objects
- Creating constructors
- Using `this` keyword
- Creating methods
- Controlling access to object data
- Input validation
- `Scanner`
- `while` loops
- `switch-case`
- Conditional statements
- Basic object state management

---

# 🛠️ Technologies Used

- **Java**
- **Object-Oriented Programming**
- **Java Scanner**
- **Control Flow**
- **Input Validation**

No external libraries or packages are required.

---

# 🚀 Future Improvements

This project can later be extended with:

- Multiple bank accounts
- Account PIN authentication
- Transaction history
- Money transfer
- Multiple customers
- Exception handling
- File handling
- Database integration
- JDBC
- PostgreSQL/MySQL
- Spring Boot REST API

The project can eventually evolve from a simple console application into a real backend application.

---

# 📚 OOP Concept Demonstrated

### Primary Concept

**Encapsulation 🔐**

### Supporting Concepts

- Classes & Objects
- Constructors
- Methods
- Access Modifiers
- Data Validation

---

## 👨‍💻 Author

**Praveen Chandra**

Part of my journey to become a **Java Backend Developer**.

This project is part of my **Java OOP Capstone Projects** repository, where each project focuses on understanding and implementing a specific Object-Oriented Programming concept.
