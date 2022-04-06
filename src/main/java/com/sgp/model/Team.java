package com.sgp.model;

public class Team {
    private final long teamId;
    private final String name;

    public Team(final long teamId, final String name) {
        this.teamId = teamId;
        this.name = name;
    }

    public long getTeamId() {
        return teamId;
    }

    public String getName() {
        return name;
    }
}
