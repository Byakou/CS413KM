package BankOfPhillipMa;

public class AccountLinkedList {
    private Node head;

    public AccountLinkedList() {
        this.head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    // Inserts with priority (date, then balance)
    public void add(Account newAccount) {
        Node newNode = new Node(newAccount);

        // If empty or new account has the highest priority
        if (isEmpty() || shouldComeBefore(newAccount, head.account)) {
            newNode.next = head;
            head = newNode;
            return;
        }

        // Find the insertion point
        Node current = head;
        while (current.next != null && !shouldComeBefore(newAccount, current.next.account)) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    // Helper method: Determines if account1 should come before account2
    private boolean shouldComeBefore(Account account1, Account account2) {
        if (account1.getCreatedAt().before(account2.getCreatedAt())) {
            return true;
        } else if (account1.getCreatedAt().equals(account2.getCreatedAt())) {
            return account1.getBalance() > account2.getBalance();
        } else {
            return false;
        }
    }

    // Retrieves and removes the highest priority account
    public Account remove() {
        if (isEmpty()) {
            return null;
        }
        Account highestPriority = head.account;
        head = head.next;
        return highestPriority;
    }
}