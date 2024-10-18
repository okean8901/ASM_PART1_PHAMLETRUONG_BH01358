package Encapsulation;

public class SecureBankAccount {
    private double balance;
    public SecureBankAccount(){
        this.balance = 0;
    }
    public void deposit(double amount){
        if (amount > 0){
            balance += amount;
        }
    }
    public double withdraw(double amount){
        if (amount > 0 && amount <= balance){
            balance -= amount;
            return amount;
        }else{
            throw new IllegalArgumentException("invalid withdrawal amount");
        }
    }
    public double getBalance(){
        return balance;
    }
}
