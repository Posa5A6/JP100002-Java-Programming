class BankAccounts {
    private String name;
    private int accnum;
    private double amount;
    private int phone;

    public BankAccounts(String name, int accnum, double amount, int phone) {
        this.name = name;
        this.accnum = accnum;
        this.amount = amount;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public int getAccnum() {
        return accnum;
    }

    public double getAmount() {
        return amount;
    }

    public int getPhone() {
        return phone;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.amount += amount;
            System.out.println("Amount deposited successfully. New balance: " + this.amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && this.amount >= amount) {
            this.amount -= amount;
            System.out.println("Amount withdrawn successfully. Remaining balance: " + this.amount);
        } else {
            System.out.println("Insufficient funds or invalid withdrawal amount.");
        }
    }

    public void transfer(BankAccounts targetAccount, double amount) {
        if (amount > 0 && this.amount >= amount) {
            this.amount -= amount;
            targetAccount.deposit(amount);
            System.out.println("Transferred " + amount + " to account number: " + targetAccount.getAccnum());
        } else {
            System.out.println("Transfer failed due to insufficient balance or invalid amount.");
        }
    }

    public void checkBalance() {
        System.out.println("Account balance for " + name + " is: " + amount);
    }
}