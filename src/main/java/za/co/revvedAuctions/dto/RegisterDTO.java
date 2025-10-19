package za.co.revvedAuctions.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDTO {
    private String email;
    private String password;
    private String username;
    private String userFullName;
}

