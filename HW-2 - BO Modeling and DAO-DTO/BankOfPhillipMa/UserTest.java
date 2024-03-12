package BankOfPhillipMa;

import org.junit.Test;
import org.junit.Assert;
import java.util.Date;

public class UserTest {

    @Test
    public void testConstructor() {
        Date testDate = new Date();
        User user = new User("John Doe", testDate, "john.doe@email.com", "johndoe", 1234, "mypassword");

        Assert.assertEquals("John Doe", user.getName());
        Assert.assertEquals(testDate, user.getBirthday());
    }

    @Test
    public void testSettersAndGetters() {
        User user = new User("Jane Doe", new Date(), "jane.doe@email.com", "janedoe", 5678, "mypassword");

        user.setName("Updated Name");
        Assert.assertEquals("Updated Name", user.getName());

        
    }

}
