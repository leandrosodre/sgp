package com.sgp.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "task")
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long taskId;
    private String description;
    private int priority;
    private int status;

    @ManyToOne
    private User user;
    @ManyToOne
    private Team team;
    @ManyToOne
    private Sprint sprint;

    public Task() {
        super();
    }

    public Task(final long taskId, final String description, final int priority, final int status, final User user, final Team team, final Sprint sprint) {
        this.taskId = taskId;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.user = user;
        this.team = team;
        this.sprint = sprint;
    }

    public long getTaskId() {
        return taskId;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public int getStatus() {
        return status;
    }

    public User getUser() {
        return user;
    }

    public Team getTeam() {
        return team;
    }

    public Sprint getSprint() {
        return sprint;
    }
}
