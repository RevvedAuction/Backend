package za.co.revvedAuctions.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import za.co.revvedAuctions.domain.User;
import za.co.revvedAuctions.dto.LoginRequest;
import za.co.revvedAuctions.dto.UserDTO;
import za.co.revvedAuctions.payload.LoginMessage;
import za.co.revvedAuctions.repository.UserRepository;
import za.co.revvedAuctions.service.IUserService;

import java.util.List;

@Service
public class UserService implements IUserService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository){
        this.repository = repository;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createFromDTO(UserDTO userDTO) {
        User user = new User.Builder()
                .setUserID(userDTO.getUserID())
                .setUserType(userDTO.getUserType())
                .setUserFullName(userDTO.getUserFullName())
                .setUserEmail(userDTO.getUserEmail())
                .setUserPassword(userDTO.getUserPassword())
                .build();
        return repository.save(user);
    }

    public LoginMessage loginUser(LoginRequest loginRequest) {
        return repository.findByUserEmail(loginRequest.getUserEmail())
                .map(user -> {
                    boolean isPasswordCorrect = passwordEncoder.matches(
                            loginRequest.getUserPassword(),
                            user.getUserPassword()
                    );

                    if (isPasswordCorrect) {
                        return new LoginMessage("Login Success", true);
                    } else {
                        return new LoginMessage("Password does not match", false);
                    }
                })
                .orElseGet(() -> new LoginMessage("Email does not exist", false));
    }



    @Override
    public User create(User user) {
        return repository.save(user);
    }

    @Override
    public User read(Long userId) {
        return repository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public User update(User user) {
        return repository.save(user);
    }

    @Override
    public User delete(Long userId) {
        User toDelete = read(userId);
        repository.delete(toDelete);
        return toDelete;
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }
}
