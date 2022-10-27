package se331.rest.security.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    Long id;
    String username;
    String email;
    String password;

    String age;
    String hometown;
    List<String> imageUrls;
    List<String> authorities;
}
