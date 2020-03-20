package pl.okpol.mdplanner.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import pl.okpol.mdplanner.model.RoleInCompany;

public class RegistrationFormDTO {

    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(min = 8)
    private String password;
    @NotBlank
    @Size(min = 8)
    private String rePassword;
    @NotBlank
    private String firstName;

    private RoleInCompany role;

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

    public RoleInCompany getRole() {
        return role;
    }

    public void setRole(RoleInCompany role) {
        this.role = role;
    }
}