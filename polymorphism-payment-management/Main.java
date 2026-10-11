
import java.util.Scanner;

class Payment {
  protected double amount;

  public Payment(double amount) {
    this.amount = amount;
  }

  public void processPayment() {
    System.out.println("Processing payment of amount: ₹" + amount);
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

  public CreditCardPayment(double amount, String cardNumber) {
    super(amount);
    this.cardNumber = cardNumber;
  }

  @Override
  public void processPayment() {
    System.out.println("\nProcessing credit card payment...");
    System.out.println("Amount: ₹" + amount);
    System.out.println("Card ending in: "
        + cardNumber.substring(cardNumber.length() - 4));
    System.out.println("Credit card payment successful!");
  }
}

class NetBankingPayment extends Payment {
  private String bankName;

  public NetBankingPayment(double amount, String bankName) {
    super(amount);
    this.bankName = bankName;
  }

  @Override
  public void processPayment() {
    System.out.println("\nProcessing net banking payment...");
    System.out.println("Amount: ₹" + amount);
    System.out.println("Bank: " + bankName);
    System.out.println("Net banking payment successful!");
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
    sc.nextLine(); // Consume the leftover newline

    if (amount <= 0) {
      System.out.println("Invalid amount. Enter an amount greater than zero.");
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
        System.out.print("Enter your card number: ");
        String cardNumber = sc.nextLine();

        if (!cardNumber.matches("\\d{16}")) {
          System.out.println("Invalid card number. Enter 16 digits.");
          sc.close();
          return;
        }

        payment = new CreditCardPayment(amount, cardNumber);
        break;

      case 3:
        System.out.print("Enter your bank name: ");
        String bankName = sc.nextLine();

        payment = new NetBankingPayment(amount, bankName);
        break;

      default:
        System.out.println("Invalid payment method selected.");
        sc.close();
        return;
    }

    // Runtime polymorphism
    payment.processPayment();

    sc.close();
  }
}
