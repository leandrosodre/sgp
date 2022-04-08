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
    private Date registerDate;
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

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public int getType() {
        return type;
    }

    public Team getTeam() {
        return team;
    }
}
