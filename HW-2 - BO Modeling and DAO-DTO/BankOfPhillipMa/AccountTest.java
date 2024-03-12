package BankOfPhillipMa;

import org.junit.Test;
import org.junit.Assert;

public class AccountTest {

    @Test
    public void testConstructor() {
        double initialBalance = 1000.0;
        Account account = new Account(initialBalance); 

        Assert.assertEquals(initialBalance, account.getBalance(), 0.0); // Allow for minor floating-point differences
        Assert.assertNotNull(account.getCreatedAt()); // Ensure creation time is set
    }

    @Test 
    public void testCompareTo_DifferentDates() throws InterruptedException {
        Account olderAccount = new Account(500);
        // Simulate olderAccount being created slightly earlier...
        Thread.sleep(10); // For demo, in real code, you'd manipulate dates directly 

        Account newerAccount = new Account(200);

        Assert.assertTrue(olderAccount.compareTo(newerAccount) < 0); // olderAccount comes first
        Assert.assertTrue(newerAccount.compareTo(olderAccount) > 0); 
    }

    @Test
    public void testCompareTo_SameDate() {
        Account account1 = new Account(250);
        Account account2 = new Account(1000); 

        Assert.assertTrue(account1.compareTo(account2) > 0); // Higher balance comes first
        Assert.assertTrue(account2.compareTo(account1) < 0); 
    }
    
}
