public class BankTest {
    
public static void main(String[] args) {
    // Create 3 bank accounts
    BankAccount firstBankAccount = new BankAccount(0, 0);
    BankAccount secondBankAccount = new BankAccount(0, 0);
    BankAccount thirdBankAccount = new BankAccount(0, 0);

    // deposit test :
    firstBankAccount.deposit(1000, "checkingBalance");
    firstBankAccount.withdraw(500, "checkingBalance");
    firstBankAccount.getBalance();
}
}
