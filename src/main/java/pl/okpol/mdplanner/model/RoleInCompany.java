package pl.okpol.mdplanner.model;

import java.util.List;

public class RoleInCompany {

    private List<String> roles;

    public RoleInCompany(List<String> roles) {
        this.roles = roles;
    }

    public List<String> getRoles() {
        roles.add("handel");
        roles.add("zaopatrzenie");
        roles.add("produkcja");
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
