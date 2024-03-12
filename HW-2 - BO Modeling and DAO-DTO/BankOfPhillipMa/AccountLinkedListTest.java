package BankOfPhillipMa;

import org.junit.Test;
import org.junit.Assert;
import java.util.Date;

public class AccountLinkedListTest {

    @Test
    public void testAdd_EmptyList() {
        AccountLinkedList list = new AccountLinkedList();
        Account newAccount = new Account(1000);
        list.add(newAccount);

        Assert.assertFalse(list.isEmpty());
        Assert.assertEquals(newAccount, list.remove()); // Check if added correctly
    }

    @SuppressWarnings("deprecation")
    @Test
    public void testAdd_MaintainPriority() {
        AccountLinkedList list = new AccountLinkedList();
        list.add(new Account(200));
        list.add(new Account(500)); // Should be placed first
        list.add(new Account(100));

        Assert.assertEquals(500, list.remove().getBalance()); // Highest balance first
        Assert.assertEquals(200, list.remove().getBalance());
    }

    @Test
    public void testRemove_EmptyList() {
        AccountLinkedList list = new AccountLinkedList();
        Assert.assertNull(list.remove());
    }

}
