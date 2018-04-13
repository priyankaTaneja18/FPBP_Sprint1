package com.test.fpbp.model;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.fpbp.model.Users;
public class UserTest {
    @Test
    public void testUserConstructor() {
        Users user= new Users("user@test.com","testing");
        assertEquals(user.getEmailId(),"user@test.com");
        assertEquals(user.getPassword(),"testing");
        
    }
    @Test
    public void testGetterSetters() {
        Users user=new Users();
        user.setEmailId("user@test.com");
        user.setPassword("testing");  
        assertEquals(user.getEmailId(),"user@test.com");
        assertEquals(user.getPassword(),"testing");
    }
}
