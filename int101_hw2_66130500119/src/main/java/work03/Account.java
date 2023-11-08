package work03;

import work01.Utilitor;
import work02.Person;

import java.util.AbstractQueue;

public class Account {
    private static long nextNo = 100_000_000L;
    private final long no;
    private final Person owner;
    private double balance;

    public Account(Person owner) {
        if (owner == null) {
            throw new NullPointerException("");
        }
        this.owner = owner;
        this.balance = 0.0;

        do {
            long result = Utilitor.computeIsbn10(nextNo);
            if (result != 10) {
                this.no = 10 * nextNo + result;
                nextNo++;
                break;
            }
            nextNo++;
        } while (true);
    }

    public long getNo() {
        return no;
    }

    public Person getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public double deposit(double amount) {
        Utilitor.testPositive(amount);
        balance += amount;
        return balance;
    }

    public double withdraw(double amount) {
        Utilitor.testPositive(amount);
        double newBalance = balance - amount;
        Utilitor.testPositive(newBalance);
        balance = newBalance;
        return balance;
    }

    public void transfer(double amount, Account account) {
        if (account == null) {
            throw new IllegalArgumentException();
        }
        withdraw(amount);
        account.deposit(amount);
    }

    @Override
    public String toString() {
        return "Account( No: " + no + " Balance= " + balance + ")";
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj;
    }

}
