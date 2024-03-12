package BankOfPhillipMa;

class Node {
    Account account;
    Node next;

    public Node(Account account) {
        this.account = account;
        this.next = null;
    }
}