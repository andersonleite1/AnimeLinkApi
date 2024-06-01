package br.com.andersonleite.animelinkapi.domain;

import br.com.andersonleite.animelinkapi.util.UserDataCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class UserDataTest {

    private UserData userData;

    private UserData userDataValid;

    @BeforeEach
    void setUp() {
        userData = new UserData();
        userDataValid = UserDataCreator.createValidUserData();
    }

    @Test
    void testSettersAndGetters() {
        userData.setId(userDataValid.getId());
        userData.setName(userDataValid.getName());
        userData.setUsername(userDataValid.getUsername());
        userData.setPassword(userDataValid.getPassword());
        userData.setAuthorities("ROLE_USER,ROLE_ADMIN");

        assertEquals(userDataValid.getId(), userData.getId());
        assertEquals(userDataValid.getName(), userData.getName());
        assertEquals(userDataValid.getUsername(), userData.getUsername());
        assertEquals(userDataValid.getPassword(), userData.getPassword());

        Collection<? extends GrantedAuthority> expectedAuthorities = Arrays.stream("ROLE_USER,ROLE_ADMIN".split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
        assertEquals(expectedAuthorities, userData.getAuthorities().stream().collect(Collectors.toSet()));
    }

    @Test
    void testNotEmptyName() {
        userData.setName("");
        Set<ConstraintViolation<UserData>> violations = Validation.buildDefaultValidatorFactory()
                .getValidator().validate(userData);

        Assertions.assertFalse(violations.isEmpty());
        assertTrue(violations.stream().anyMatch(v -> v.getMessage().equals("The user name cannot be empty")));
    }

    @Test
    void testBuilder() {
        UserData builtUserData = UserData.builder()
                .id(userDataValid.getId())
                .name(userDataValid.getName())
                .username(userDataValid.getUsername())
                .password(userDataValid.getPassword())
                .authorities("ROLE_USER")
                .build();

        assertEquals(userDataValid.getId(), builtUserData.getId());
        assertEquals(userDataValid.getName(), builtUserData.getName());
        assertEquals(userDataValid.getUsername(), builtUserData.getUsername());
        assertEquals(userDataValid.getPassword(), builtUserData.getPassword());

        Collection<? extends GrantedAuthority> expectedAuthorities = Arrays.stream("ROLE_USER".split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
        assertEquals(expectedAuthorities, builtUserData.getAuthorities().stream().collect(Collectors.toSet()));
    }

    @Test
    void testToString() {
        String expectedToString = "UserData(id=1, name=John Doe, username=john_doe, password=password456, authorities=[ROLE_USER, ROLE_ADMIN])";
        assertEquals(expectedToString, userDataValid.toString());
    }

    @Test
    void testHashCode() {
        UserData userData1 = UserData.builder()
                .id(userDataValid.getId())
                .name(userDataValid.getName())
                .username(userDataValid.getUsername())
                .password(userDataValid.getPassword())
                .authorities("ROLE_USER")
                .build();

        UserData userData2 = UserData.builder()
                .id(userDataValid.getId())
                .name(userDataValid.getName())
                .username(userDataValid.getUsername())
                .password(userDataValid.getPassword())
                .authorities("ROLE_USER")
                .build();

        UserData userData3 = UserData.builder()
                .id(2L)
                .name("Jane Doe")
                .username("jane_doe")
                .password("janepassword")
                .authorities("ROLE_ADMIN")
                .build();

        // Verificar se objetos iguais produzem o mesmo hash code
        assertEquals(userData1.hashCode(), userData2.hashCode());

        // Verificar se objetos diferentes produzem hash codes diferentes
        assertNotEquals(userData1.hashCode(), userData3.hashCode());
    }

    @Test
    void testIsEnabled() {
        assertTrue(userData.isEnabled());
    }

    @Test
    void testIsCredentialsNonExpired() {
        assertTrue(userData.isCredentialsNonExpired());
    }

    @Test
    void testIsAccountNonLocked() {
        assertTrue(userData.isAccountNonLocked());
    }

    @Test
    void testIsAccountNonExpired() {
        assertTrue(userData.isAccountNonExpired());
    }

    @Test
    void testCanEqual() {
        UserData userData1 = new UserData();
        UserData userData2 = new UserData();
        Object otherObject = new Object();

        assertTrue(userData1.canEqual(userData2));
        assertFalse(userData1.canEqual(otherObject));
    }

    @Test
    void testEquals() {
        UserData userData1 = UserData.builder()
                .id(userDataValid.getId())
                .name(userDataValid.getName())
                .username(userDataValid.getUsername())
                .password(userDataValid.getPassword())
                .authorities("ROLE_USER")
                .build();

        UserData userData2 = UserData.builder()
                .id(userDataValid.getId())
                .name(userDataValid.getName())
                .username(userDataValid.getUsername())
                .password(userDataValid.getPassword())
                .authorities("ROLE_USER")
                .build();

        UserData userData3 = UserData.builder()
                .id(2L)
                .name("Jane Doe")
                .username("jane_doe")
                .password("janepassword")
                .authorities("ROLE_ADMIN")
                .build();

        assertEquals(userData1, userData2);
        assertNotEquals(userData1, userData3);
        assertNotEquals(userData2, userData3);
    }
}