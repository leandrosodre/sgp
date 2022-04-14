package com.sgp.models;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;
import java.util.List;

@SuppressWarnings("serial")
@Entity
public class Role implements GrantedAuthority {

    @Id
    @Size(max = 20)
    private String nameRole;

    @ManyToMany
    private List<User> users;

    public Role() {
    }

    public Role(final String nameRole) {
        this.nameRole = nameRole;
    }

    @Override
    public String getAuthority() {
        return nameRole;
    }


    public String getNameRole() {
        return nameRole;
    }


    public void setNameRole(final String nameRole) {
        this.nameRole = nameRole;
    }
}
