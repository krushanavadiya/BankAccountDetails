import java.util.Scanner;

public class BankDetails {
    public static void main(String[] args) {
      /*  account acc = new account();
        acc.name = "Krusha Navadiya";
        acc.accType = "Savings";
        acc.accNo = "1234567890";
        acc.phoneNo = 987640352;
        acc.bankName = "ICI Bank";
        acc.branchName = "Main Branch";
        acc.ifscCode = "ABCD1234";
        acc.accID = "ACC123456";
        acc.balance = 10000;
     */
      //  acc.displayAccountInfo();

      //  acc.credit(5000);
      //  acc.displayBalance();

      //  acc.debit(2000);
       // acc.displayBalance();
    Scanner sc= new Scanner(System.in);
    account acc = new account();
    System.out.println("Enter account holder name:");
    String name = sc.nextLine();
    acc.name = name;

    System.out.println("Enter account type:");
    String accType = sc.nextLine();
    acc.accType = accType;

    System.out.println("Enter account number:");
    String accNo = sc.nextLine();
    acc.accNo = accNo;

    System.out.println("Enter phone number:");
    long phoneNo = sc.nextLong();
    acc.phoneNo = phoneNo;

    System.out.println("Enter bank name:");
    String bankName = sc.next();
    acc.bankName = bankName;

    System.out.println("Enter branch name:");
    String branchName = sc.next();
    acc.branchName = branchName;

    System.out.println("Enter IFSC code:");
    String ifscCode = sc.next();
    acc.ifscCode = ifscCode;

    System.out.println("Enter account ID:");
    String accID = sc.next();
    acc.accID = accID;

    System.out.println("Enter initial balance:");
    double balance = sc.nextDouble();
    acc.balance = balance;

    acc.displayAccountInfo();

   /*  System.out.println("Enter amount to credit:");
    double creditAmount = sc.nextDouble();
    acc.credit(creditAmount);
    acc.displayBalance();

    System.out.println("Enter amount to debit:");
    double debitAmount = sc.nextDouble();
    acc.debit(debitAmount);
    acc.displayBalance();
        */

    System.out.println("choose an option:");
    System.out.println("1. Credit Amount");
    System.out.println("2. Debit Amount");  

    int option = sc.nextInt();
    switch (option) {
        case 1:
            System.out.println("Enter amount to credit:");
            double creditAmount = sc.nextDouble();
            acc.credit(creditAmount);
            acc.displayBalance();
            break;
        case 2:
            System.out.println("Enter amount to debit:");
            double debitAmount = sc.nextDouble();
            acc.debit(debitAmount);
            acc.displayBalance();
            break;
        default:
            System.out.println("Invalid option.");
    }
    
}
}
class account{
    String name;
    String accType;
    String accNo;
    long phoneNo;
    String bankName;
    String branchName;
    String ifscCode;
    String accID;
    double balance;

    public void displayDetails() {
        System.out.println("Account Holder Name: " + this.name);
        System.out.println("Account Type: " + this.accType);
        System.out.println("Account Number: " + this.accNo);
        System.out.println("Phone Number: " + this.phoneNo);
        System.out.println("Bank Name: " + this.bankName);
        System.out.println("Branch Name: " + this.branchName);
        System.out.println("IFSC Code: " + this.ifscCode);
        System.out.println("Account ID: " + this.accID);
        System.out.println("Balance: " + this.balance);
    }

    public void credit(double amount) {

            this.balance += amount;
            System.out.println("Credited: " + amount);
    }

    public void debit(double amount) {
       
            this.balance -= amount;
            System.out.println("Debited: " + amount);
    }

    public void displayBalance() {
        System.out.println("Current Balance: " + this.balance);
    }

    public void displayAccountInfo() {
        System.out.println("Account Information:");
        displayDetails();
        displayBalance();
    }
}
