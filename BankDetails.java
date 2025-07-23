import java.util.Scanner;
import java.util.Random;

public class BankDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account acc = null;


        while (true) {
            System.out.println("\n Account Management :");
            System.out.println("1. Create New Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. View Account Balance");
            System.out.println("5. View Account Details");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int option = sc.nextInt();


            switch (option) {
                case 1:
                    System.out.println("Enter account holder name:");
                    String name = sc.nextLine();
                    System.out.println("Enter email:");
                    String email = sc.nextLine();
                    System.out.println("Enter phone number:");
                    String phone = sc.nextLine();
                    System.out.println("Enter bank name:");
                    String bankName = sc.nextLine();
                    System.out.println("Enter branch name:");
                    String branchName = sc.nextLine();
                    System.out.println("Enter IFSC code:");
                    String ifscCode = sc.nextLine();
                    System.out.println("Enter account type:");
                    String accType = sc.nextLine();
                    System.out.println("Enter initial balance:");
                    double balance = sc.nextDouble();

                    acc = new Account(name, email, phone, bankName, branchName, ifscCode, accType, balance);
                    System.out.println("Account created successfully");
                    acc.displayAccountInfo();
                    break;
                case 2:
                    System.out.println("Enter amount to deposit:");
                    double deposit = sc.nextDouble();
                    acc.credit(deposit);
                    break;
                case 3:
                    System.out.println("Enter amount to withdraw:");
                    double withdraw = sc.nextDouble();
                    acc.debit(withdraw);
                    break;
                case 4:
                    acc.displayBalance();
                    break;
                case 5:
                    acc.displayAccountInfo();
                    break;
                
                default:
                    System.out.println("Invalid option.");
            }
        }
        
    }
}

class Account {
    private String name;
    private String email;
    private String phone;
    private String bankName;
    private String branchName;
    private String ifscCode;
    private String accType;
    private double balance;
    private String accNo;
    private String accID;

    public Account(String name, String email, String phone, String bankName, String branchName, String ifscCode, String accType, double balance) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.bankName = bankName;
        this.branchName = branchName;
        this.ifscCode = ifscCode;
        this.accType = accType;
        this.balance = balance;
        this.accNo = generateAccountNumber();
        this.accID = generateAccountID();
    }

    public String generateAccountNumber() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(rand.nextInt(10));
        }
        return sb.toString();
    }

    public String generateAccountID() {
        Random rand = new Random();
        return "ACC" + (100000 + rand.nextInt(900000));
    }

    public void displayAccountInfo() {
        System.out.println("\n Account Information ");
        System.out.println("Account Holder Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phone);
        System.out.println("Bank Name: " + bankName);
        System.out.println("Branch Name: " + branchName);
        System.out.println("IFSC Code: " + ifscCode);
        System.out.println("Account Type: " + accType);
        System.out.println("Account Number: " + accNo);
        System.out.println("Account ID: " + accID);
        System.out.println("Balance: " + balance);
    }

    public void credit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
            displayBalance();
        } 
    }

    public void debit(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            displayBalance();
        } 
    }

    public void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }

}
