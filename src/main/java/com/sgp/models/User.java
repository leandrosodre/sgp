package com.sgp.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @NotNull
    private String name;

    @NotNull
    private String login;

    @NotNull
    @Size(min = 3, max = 20)
    private String password;
    private Date bornDate;
    private int type;

    @ManyToOne
    private Team team;

    public User() {
        super();
    }

    public User(final long userId, final String name, final String login, final String password, final Date bornDate, final int type, final Team team) {
        this.userId = userId;
        this.name = name;
        this.login = login;
        this.password = password;
        this.bornDate = bornDate;
        this.type = type;
        this.team = team;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(final long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(final String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(final Date bornDate) {
        this.bornDate = bornDate;
    }

    public int getType() {
        return type;
    }

    public void setType(final int type) {
        this.type = type;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(final Team team) {
        this.team = team;
    }
}
