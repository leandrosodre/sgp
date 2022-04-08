package com.sgp.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "team")
public class Team implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long teamId;
    private String name;

    public Team() {
        super();
    }

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
