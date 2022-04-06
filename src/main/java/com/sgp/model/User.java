package com.sgp.model;

import java.util.Date;

public class User {
    private final long userId;
    private final String name;
    private final String login;
    private final String password;
    private final Date bornDate;
    private final Date registerDate;
    private final int type;
    private final long teamId;

    public User(final long userId, final String name, final String login, final String password, final Date bornDate, final Date registerDate, final int type, final long teamId) {
        this.userId = userId;
        this.name = name;
        this.login = login;
        this.password = password;
        this.bornDate = bornDate;
        this.registerDate = registerDate;
        this.type = type;
        this.teamId = teamId;
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

    public long getTeamId() {
        return teamId;
    }
}
