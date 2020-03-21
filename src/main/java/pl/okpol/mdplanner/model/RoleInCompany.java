package pl.okpol.mdplanner.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class RoleInCompany extends AbstractEntity{

    private String role;

    public RoleInCompany(String role) {
        this.role = role;
    }

    public RoleInCompany() {
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
