package za.co.revvedAuctions.service.implementation;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.co.revvedAuctions.domain.Admin;
import za.co.revvedAuctions.factory.AdminFactory;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AdminServiceTest {

    @Autowired
    private AdminService adminService;

//    UUID adminId = UUID.randomUUID();
    private static final Admin admin1 = AdminFactory.createAdmin("Esihle Mlinjane", "mlinjane@gmail.com", "Esihle1234", "0795109767", "Admin", true);

    @Test
    void create() {
        Admin createAdmin1 = adminService.create(admin1);
        System.out.println(createAdmin1);
        assertNotNull(createAdmin1);
    }

    @Test
    void read() {
        Admin readAdmin1 = adminService.read(admin1.AdminId());
        assertNotNull(readAdmin1);
        System.out.println(readAdmin1);
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void getAll() {
    }
}