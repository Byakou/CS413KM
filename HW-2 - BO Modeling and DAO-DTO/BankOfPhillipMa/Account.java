package BankOfPhillipMa;

import java.util.Date;

public class Account implements Comparable<Account> {
    private Date createdAt;
    private double balance;

    public Account(double balance) {
        this.balance = balance;
        this.createdAt = new Date(); // Record creation time
    }

    // Getters
    public Date getCreatedAt() {
        return createdAt;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public int compareTo(Account otherAccount) {
        // Compare creation dates first
        int dateResult = this.createdAt.compareTo(otherAccount.getCreatedAt());
        if (dateResult != 0) {
            return dateResult;
        }

        // If dates are the same, prioritize by balance (descending)
        return Double.compare(otherAccount.getBalance(), this.getBalance());
    }
}
