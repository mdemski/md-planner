package pl.okpol.mdplanner.mappers;

import org.springframework.stereotype.Component;
import pl.okpol.mdplanner.dto.UserDTO;
import pl.okpol.mdplanner.model.User;
import pl.okpol.mdplanner.services.UserService;

@Component
public class UserMapper {

    private UserService userService;

    public UserMapper(UserService userService) {
        this.userService = userService;
    }

    public UserDTO convertToUserDTO (User entity) {
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());
        dto.setRePassword(entity.getPassword());
        dto.setFirstName(entity.getFirstName());
        dto.setRole(entity.getRole());
        dto.setActivated(entity.isActivated());
        return dto;
    }

    public User convertToUserEntity(UserDTO userDTO) {
        User user = this.userService.getUserByEmail(userDTO.getEmail());
        return user;
    }

    public User convertToUserEntity(String userEmail) {
        User user = this.userService.getUserByEmail(userEmail);
        return user;
    }
}
