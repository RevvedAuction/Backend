package za.co.revvedAuctions.factory;

import org.junit.jupiter.api.Test;
import za.co.revvedAuctions.domain.User;

import static org.junit.jupiter.api.Assertions.*;

class UserFactoryTest {

@Test
public void testCreateValidUser() {
    User user = UserFactory.createUser(
            132435L,
            "Seller",
            "Karen Sweet",
            "user@example.com",
            "password"
    );
    assertNotNull(user);
    assertEquals("Paul Sweet", user.getUserFullName());
    assertEquals("john@gmail.com", user.getUserEmail());
    assertEquals("password", user.getUserPassword());
    System.out.println(user);
}

@Test
void User_FullNameNullOrEmpty() {
    User user = UserFactory.createUser(
            132435L,
            "Seller",
            "Karen Sweet",
            "user@example.com",
            "password"
    );
    assertNull(user, "User should not be created if full name is empty");
}


@Test
void User_EmailNullOrEmpty() {
    User user = UserFactory.createUser(
            132435L,
            "Seller",
            "Karen Sweet",
            "user@example.com",
            "password"
    );
    assertNull(user, "User should not be created if email is empty");
}

@Test
void User_EmailInvalid() {
    User user = UserFactory.createUser(
            132435L,
            "Seller",
            "Karen Sweet",
            "user@example.com",
            "password"
    );
    assertNull(user, "User should not be created if email is invalid");
}

@Test
void User_PasswordNullOrEmpty() {
    User user = UserFactory.createUser(
            132435L,
            "Seller",
            "Karen Sweet",
            "user@example.com",
            "password"
    );
    assertNull(user, "User should not be created if email is invalid");
}


}