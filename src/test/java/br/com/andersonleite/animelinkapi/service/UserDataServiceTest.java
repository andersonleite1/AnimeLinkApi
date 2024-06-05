package br.com.andersonleite.animelinkapi.service;

import br.com.andersonleite.animelinkapi.domain.UserData;
import br.com.andersonleite.animelinkapi.repository.UserDataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class UserDataServiceTest {

    @Mock
    private UserDataRepository userDataRepository;

    @InjectMocks
    private UserDataService userDataService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLoadUserByUsername_UserExists() {
        String username = "testUser";
        UserData userData = new UserData();
        userData.setUsername(username);
        userData.setPassword("password");
        when(userDataRepository.findByUsername(username)).thenReturn(userData);

        UserDetails result = userDataService.loadUserByUsername(username);

        assertNotNull(result);
        assertEquals(username, result.getUsername());
        assertEquals("password", result.getPassword());
    }

    @Test
    public void testLoadUserByUsername_UserNotFound() {
        String username = "nonExistentUser";
        when(userDataRepository.findByUsername(username)).thenReturn(null);

        assertThrows(UsernameNotFoundException.class, () -> userDataService.loadUserByUsername(username));
    }
}
