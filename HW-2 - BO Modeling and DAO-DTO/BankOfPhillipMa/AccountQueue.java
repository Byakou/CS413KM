package BankOfPhillipMa;

import java.util.PriorityQueue;

public class AccountQueue {
    public static void main(String[] args) {
        AccountLinkedList accounts = new AccountLinkedList();
        accounts.add(new Account(2500));
        accounts.add(new Account(50));
        accounts.add(new Account(1000));

        // Retrieve accounts based on priority
        while (!accounts.isEmpty()) {
            Account nextAccount = accounts.remove();
            System.out.println("Balance: " + nextAccount.getBalance() + ", Created At: " + nextAccount.getCreatedAt());
        }
    }
}
