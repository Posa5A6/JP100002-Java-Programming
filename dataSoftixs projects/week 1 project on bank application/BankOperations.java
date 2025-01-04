
import java.util.ArrayList;
import java.util.Scanner;

class BankOperations {
    Scanner s = new Scanner(System.in);

    public void Menu(ArrayList<BankAccounts> accounts) {
        while (true) {
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. Check Balance");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = s.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("Enter account number or phone number to deposit into: ");
                    int identifier = s.nextInt();
                    BankAccounts account = findAccountByIdentifier(accounts, identifier);
                    if (account != null) {
                        System.out.println("Enter deposit amount: ");
                        double amount = s.nextDouble();
                        account.deposit(amount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                }
                case 2: {
                    System.out.println("Enter account number or phone number to withdraw from: ");
                    int identifier = s.nextInt();
                    BankAccounts account = findAccountByIdentifier(accounts, identifier);
                    if (account != null) {
                        System.out.println("Enter withdrawal amount: ");
                        double amount = s.nextDouble();
                        account.withdraw(amount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Enter your account number or phone number: ");
                    int fromIdentifier = s.nextInt();
                    BankAccounts fromAccount = findAccountByIdentifier(accounts, fromIdentifier);
                    if (fromAccount != null) {
                        System.out.println("Enter target account number or phone number: ");
                        int toIdentifier = s.nextInt();
                        BankAccounts toAccount = findAccountByIdentifier(accounts, toIdentifier);
                        if (toAccount != null) {
                            System.out.println("Enter transfer amount: ");
                            double amount = s.nextDouble();
                            fromAccount.transfer(toAccount, amount);
                        } else {
                            System.out.println("Target account not found.");
                        }
                    } else {
                        System.out.println("Your account not found.");
                    }
                    break;
                }
                case 4: {
                    System.out.println("Enter account number or phone number to check balance: ");
                    int identifier = s.nextInt();
                    BankAccounts account = findAccountByIdentifier(accounts, identifier);
                    if (account != null) {
                        account.checkBalance();
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                }
                case 5: {
                    System.out.println("Returning to main menu.");
                    return;
                }
                default: {
                    System.out.println("Enter a valid choice.");
                }
            }
        }
    }

    private BankAccounts findAccountByIdentifier(ArrayList<BankAccounts> accounts, int identifier) {
        for (BankAccounts account : accounts) {
            if (account.getAccnum() == identifier || account.getPhone() == identifier) {
                return account;
            }
        }
        return null;
    }
}
