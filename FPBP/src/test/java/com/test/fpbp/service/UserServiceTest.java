package com.test.fpbp.service;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.AssertTrue;
import org.junit.Test;
import com.fpbp.DAO.UserDAO;
import com.fpbp.model.Donor;
import com.fpbp.service.DonorService;
import com.fpbp.service.IDonorService;
import com.fpbp.service.IUserService;
import com.fpbp.service.UserService;
public class UserServiceTest {
    @Test
    public void testRegisterUser() throws SQLException {
        
        UserDAO user= mock(UserDAO.class);    
        
        //Given
        given(user.registerUser("user@test.com", "test")).willReturn("successful");
        //When
        IUserService st= new UserService(user);
        String data= st.registerUser("user@test.com", "test");
        //Then
        assertEquals(data,"successful");
       
        }
    
    @Test
    public void testValidateUser() throws SQLException {
        
        UserDAO user= mock(UserDAO.class);    
        
        //Given
        given(user.validateUser("user@test.com", "test")).willReturn("successful");
        //When
        IUserService st= new UserService(user);
        String data= st.validateUser("user@test.com", "test");
        //Then
        assertEquals(data,"successful");
       
        }
}