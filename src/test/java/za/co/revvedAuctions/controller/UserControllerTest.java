package za.co.revvedAuctions.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import za.co.revvedAuctions.domain.User;
import za.co.revvedAuctions.repository.UserRepository;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;

    private User sampleUser;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();

        sampleUser = new User.Builder()
                .setUserID(132435L)
                .setUserType("Seller")
                .setUserFullName("Karen Sweet")
                .setUserEmail("user@example.com")
                .setUserPassword("test1234")
                .build();

        userRepository.save(sampleUser);
    }

    @Test
    void create() throws Exception{
        User newUser = new User.Builder()
                .setUserID(132435L)
                .setUserType("Seller")
                .setUserFullName("Karen Sweet")
                .setUserEmail("user@example.com")
                .setUserPassword("test1234")
                .build();

        mockMvc.perform(post("/api/user/132435L")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newUser)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userID").value(132435L))
                .andExpect(jsonPath("$.userFullName").value("Matt Hemi"));
    }

    @Test
    void read() throws Exception {
    }

    @Test
    void update() throws Exception {
        User userUpdated = new User.Builder()
                .copy(sampleUser)
                .setUserPassword("test5678")
                .build();

        mockMvc.perform(put("/api/user/132435L")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userUpdated)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userPassword").value("test9012"));
    }

    @Test
    void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/user/132435L"))
                .andExpect(status().isNoContent());
    }

    @Test
    void getAll() throws Exception {
        mockMvc.perform(get("/api/user/132435L"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userType").value("Buyer"));
    }
}