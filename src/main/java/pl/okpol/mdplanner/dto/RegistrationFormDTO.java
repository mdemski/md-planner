package pl.okpol.mdplanner.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RegistrationFormDTO {

    @NotBlank(message = "Podaj adres mailowy")
    @Email(message = "Adres maliowy jest niepoprawny")
    private String email;
    @NotBlank(message = "Podaj hasło")
    @Size(min = 8, message = "Hasło musi posiadać conajmniej 8 znaków")
    private String password;
    @NotBlank
    @Size(min = 8)
    private String rePassword;
    @NotBlank(message = "Podaj imię")
    private String firstName;
    private String role;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
