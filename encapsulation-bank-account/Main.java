
import java.util.Scanner;

/*
 * BankAccount
 *
 * This class represents a bank account.
 * Encapsulation is implemented by keeping account details private
 * and providing public methods to access and modify them safely.
 */
class BankAccount {

  // Private fields - cannot be accessed directly from outside this class
  private String accountHolder;
  private String accountNumber;
  private double currentBalance;

  /*
   * Constructor
   *
   * Initializes the bank account with:
   * - Account holder name
   * - Account number
   * - Initial balance
   */
  public BankAccount(String accountHolder, String accountNumber, double currentBalance) {

    // Validate account holder name
    if (!accountHolder.isEmpty()) {
      this.accountHolder = accountHolder;
    } else {
      this.accountHolder = "Unknown";
    }

    // Validate account number
    if (accountNumber.length() == 12) {
      this.accountNumber = accountNumber;
    } else {
      this.accountNumber = "Invalid Account Number";
    }

    // Validate initial balance
    if (currentBalance >= 0) {
      this.currentBalance = currentBalance;
    } else {
      this.currentBalance = 0;
    }
  }

  /*
   * Displays the account holder's name.
   */
  public void getName() {

    if (!accountHolder.isEmpty()) {
      System.out.println("Account Holder : " + accountHolder);
    }
  }

  /*
   * Displays the current account balance.
   */
  public void getBalance() {

    if (currentBalance >= 0) {
      System.out.println(
          "Balance of " + accountHolder + " : ₹" + currentBalance);
    } else {
      System.out.println(
          "Your account does not have a valid balance.");
    }
  }

  /*
   * Displays the account number.
   */
  public void getAccountNumber() {

    if (!accountNumber.isEmpty()) {
      System.out.println("Account Number : " + accountNumber);
    }
  }

  /*
   * Deposits money into the account.
   *
   * The deposit amount must be greater than zero.
   */
  public void depositMoney(double amount) {

    if (amount > 0) {

      currentBalance += amount;

      System.out.println(
          "Successfully deposited : ₹" + amount);

      System.out.println(
          "Current Balance : ₹" + currentBalance);

    } else {

      System.out.println(
          "Invalid deposit amount. Amount must be greater than zero.");
    }
  }

  /*
   * Withdraws money from the account.
   *
   * Withdrawal is allowed only when:
   * 1. Amount is greater than zero.
   * 2. Amount is not greater than the current balance.
   */
  public void withdrawMoney(double amount) {

    if (amount <= 0) {

      System.out.println(
          "Invalid withdrawal amount.");

    } else if (amount > currentBalance) {

      System.out.println(
          "Insufficient balance.");

    } else {

      currentBalance -= amount;

      System.out.println(
          "Successfully withdrawn : ₹" + amount);

      System.out.println(
          "Current Balance : ₹" + currentBalance);
    }
  }
}

/*
 * Main class
 *
 * Handles user input and provides the banking menu.
 */
public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    // ==========================================
    // STEP 1: CREATE BANK ACCOUNT
    // ==========================================

    System.out.print("Enter account holder name: ");
    String name = sc.nextLine();

    /*
     * Ask for the account number repeatedly
     * until the user enters exactly 12 characters.
     */
    String accountNumber;

    while (true) {

      System.out.print("Enter 12-digit account number: ");
      accountNumber = sc.nextLine();

      // Valid account number
      if (accountNumber.length() == 12) {
        break;
      }

      // Invalid account number
      System.out.println("\n❌ Invalid account number!");
      System.out.println(
          "Account number must contain exactly 12 digits.");
      System.out.println("Please enter again.\n");
    }

    // Get initial account balance
    System.out.print("Enter initial balance: ");
    double balance = sc.nextDouble();

    // Create BankAccount object
    BankAccount person1 = new BankAccount(name, accountNumber, balance);

    // ==========================================
    // STEP 2: BANKING MENU
    // ==========================================

    boolean continueBanking = true;

    /*
     * Keep showing the menu until the user
     * chooses the Exit option.
     */
    while (continueBanking) {

      System.out.println("\n========== BANK MENU ==========");
      System.out.println("1. Show Account Holder");
      System.out.println("2. Show Account Number");
      System.out.println("3. Show Balance");
      System.out.println("4. Deposit Money");
      System.out.println("5. Withdraw Money");
      System.out.println("6. Exit");
      System.out.println("===============================");

      System.out.print("Enter your choice: ");
      int choice = sc.nextInt();

      // ==========================================
      // STEP 3: PROCESS USER'S CHOICE
      // ==========================================

      switch (choice) {

        // Show account holder name
        case 1:
          person1.getName();
          break;

        // Show account number
        case 2:
          person1.getAccountNumber();
          break;

        // Show current balance
        case 3:
          person1.getBalance();
          break;

        // Deposit money
        case 4:

          System.out.print("Enter deposit amount: ");
          double depositAmount = sc.nextDouble();

          person1.depositMoney(depositAmount);
          break;

        // Withdraw money
        case 5:

          System.out.print("Enter withdrawal amount: ");
          double withdrawalAmount = sc.nextDouble();

          person1.withdrawMoney(withdrawalAmount);
          break;

        // Exit the application
        case 6:

          continueBanking = false;

          System.out.println(
              "\nThank you for using our bank!");

          break;

        // Handle invalid menu choices
        default:

          System.out.println(
              "❌ Invalid choice. Please select 1-6.");
      }
    }

    // Close Scanner
    sc.close();
  }
}
