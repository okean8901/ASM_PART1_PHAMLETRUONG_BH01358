package Encapsulation;

public class FinanceApp {
    public static void main(String[] args) {


        BankAccount myAccount = new BankAccount(0);
        myAccount.deposit(300);
        System.out.println("withdrawn: " + myAccount.withdraw(150));
        System.out.println("current balance: " + myAccount.getBalance());
    }
}
//        personalAccount.deposit(100);
//        personalAccount.withdraw(50);
//        System.out.println("remaining balance: " + personalAccount.getBalance());
