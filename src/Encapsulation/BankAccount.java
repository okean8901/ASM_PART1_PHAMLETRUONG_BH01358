package Encapsulation;

public class BankAccount {
    private double[] transactions;
    private int transactionCount;
    public BankAccount(){
        transactions = new double[100];
        transactionCount = 0;
    }

    public BankAccount(int i) {
    }

    public void deposit(double amount){
        int transactionsCount = 0;
        transactions[transactionsCount++] = amount;
    }
    public double withdraw(double amount){
        double balance = getBalance();
        if (amount <= balance){
            transactions[transactionCount++] = -amount;
            return amount;
        }else{
            throw new IllegalArgumentException("insufficient funds");
        }
    }
    public double getBalance(){
        double balance = 0;
        for (int i = 0; i < transactionCount; i++){
            balance += transactions[i];
        }return balance;
    }

//    private double balance;
//    public BankAccount(double balance){
//        this.balance = balance;
//    }
//
//    public void deposit(double amount){
//        balance += amount;
//    }
//    public double withdraw(double amount){
//        if (amount <= balance){
//            balance -= amount;
//            return amount;
//        }
//        else{
//            throw new IllegalArgumentException("insufficient funds");
//        }
//    }
//    public double getBalance(){
//        return balance;
//    }
}
