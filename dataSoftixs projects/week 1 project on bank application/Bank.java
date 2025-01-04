import java.util.ArrayList;
import java.util.Scanner;

/**
 * Bank Management System
 * Author: MR.POSA
 */
public class Bank {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("******************DATA SOFTIXS Bank********************");
        ArrayList<BankAccounts> accounts = new ArrayList<>();

        while (true) {
            System.out.println("Create an account - Press 1");
            System.out.println("Bank operations - Press 2");
            System.out.println("Delete account - Press 3");
            System.out.println("Display all accounts - Press 4");
            System.out.println("Close the bank - Press 5");
            System.out.print("Enter your choice: ");
            int press = s.nextInt();

            switch (press) {
                case 1: {
                    System.out.println();
                    System.out.println("Enter user name: ");
                    s.nextLine(); // Consume the leftover newline
                    String name = s.nextLine();
                    System.out.println("Enter account number: ");
                    int accnum = s.nextInt();
                    System.out.println("Enter initial amount: ");
                    double amount = s.nextDouble();
                    System.out.println("Enter phone number: ");
                    int phone = s.nextInt();

                    accounts.add(new BankAccounts(name, accnum, amount, phone));
                    System.out.println("Account created successfully with the name of " + name);
                    break;
                }
                case 2: {
                    System.out.println("Bank operations menu:");
                    BankOperations bo = new BankOperations();
                    bo.Menu(accounts);
                    break;
                }
                case 3: {
                    System.out.println("Enter the account number or phone number to remove: ");
                    int identifier = s.nextInt();
                    BankAccounts accountToRemove = findAccountByIdentifier(accounts, identifier);
                    if (accountToRemove != null) {
                        accounts.remove(accountToRemove);
                        System.out.println("Account removed successfully.");
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                }
                case 4: {
                    displayAccounts(accounts);
                    break;
                }
                case 5: {
                    System.out.println("Closing the bank. Goodbye!");
                    System.exit(1);
                }
                default: {
                    System.out.println("Enter a valid choice.");
                }
            }
        }
    }

    private static BankAccounts findAccountByIdentifier(ArrayList<BankAccounts> accounts, int identifier) {
        for (BankAccounts account : accounts) {
            if (account.getAccnum() == identifier || account.getPhone() == identifier) {
                return account;
            }
        }
        return null;
    }

    private static void displayAccounts(ArrayList<BankAccounts> accounts) {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available to display.");
        } else {
            System.out.println("\nAccount Details:");
            for (BankAccounts account : accounts) {
                System.out.println("Name: " + account.getName() + ", Account Number: " + account.getAccnum() + ", Balance: " + account.getAmount());
            }
        }
    }
}