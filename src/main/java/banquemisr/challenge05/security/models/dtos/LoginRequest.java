package banquemisr.challenge05.security.models.dtos;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
