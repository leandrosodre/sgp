package com.sgp.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String name;
    private String login;
    private String password;
    private Date bornDate;
    private Date registerDate = new Date();
    private int type;

    @ManyToOne
    private Team team;

    public User() {
        super();
    }

    public User(final long userId, final String name, final String login, final String password, final Date bornDate, final Date registerDate, final int type, final Team team) {
        this.userId = userId;
        this.name = name;
        this.login = login;
        this.password = password;
        this.bornDate = bornDate;
        this.registerDate = registerDate;
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

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(final Date registerDate) {
        this.registerDate = registerDate;
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
