/**
 * BankAccount
 */
public class BankAccount {
    // MEMBER VARIABLES
    private double checkingBalance;
    private double savingsBalance;
    private static int accounts;
    private static double totalMoney; // refers to the sum of all bank account checking and savings balances

    // CONSTRUCTOR
    public BankAccount(double checkingBalance, double savingsBalance) {
        BankAccount.accounts += 1;
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
    }

    // Getters : for checking, savings, accounts, and totalMoney
    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public static int getAccounts() {
        return accounts;
    }

    public static double getTotalMoney() {
        return totalMoney;
    }

    // Methods :
    // deposit method :
    public void deposit(double money, String accountType) {
        if (accountType == "checkingBalance") {
            this.checkingBalance += money;
        } else {
            this.savingsBalance += money;
        }
        totalMoney += money;
    }

    // Withdrow:
    public void withdraw(double money, String accountType) {
        if (accountType == "checkingBalance") {
            if (money <= this.checkingBalance) {
                this.checkingBalance -= money;
            } else {
                System.out.println("insufficiant money in your checking account");
            }
        } else {
            if (money <= this.savingsBalance) {
                this.savingsBalance -= money;
            } else {
                System.out.println("insufficiant money in your balance account");
            }
        }
        totalMoney -= money;
        // System.out.println(totalMoney);
    }

    // getBalance method :
    public void getBalance() {
        totalMoney = this.checkingBalance + this.savingsBalance;
        System.out.println("Total Balance is :" + totalMoney);
    }

}
