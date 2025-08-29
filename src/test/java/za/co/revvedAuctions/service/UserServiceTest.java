package za.co.revvedAuctions.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.co.revvedAuctions.domain.User;
import za.co.revvedAuctions.factory.UserFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService service;
    private User user;

    @BeforeEach
    void setUp() {
        User createUser = UserFactory.createUser(
                132435L,
                "Seller",
                "Karen Sweet",
                "user@example.com",
                "password");
        user = service.create(createUser);
        assertNotNull(user);
        assertNotNull(user.getUserID());
    }


    @Test
    void a_create() {
        User createdUser = service.create(user);
        assertNotNull(createdUser);
        System.out.println(createdUser);
    }

    @Test
    void b_read() {
        User read = service.read(user.getUserID());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void c_update() {
        User updatedUser = new User.Builder().copy(user).setUserFullName("Caren")
                .build();
        User updated = service.update(updatedUser);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void d_delete() {
        boolean deleted = service.delete(user.getUserID());
        assertTrue(deleted);
        System.out.println(deleted);
    }

    @Test
    void e_getAll() {
        System.out.println(service.getAll());
    }
}