package com.sgp.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "task")
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long taskId;
    private long number;
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

    public Task(final long taskId, final long number, final String description, final int priority, final int status, final User user, final Team team, final Sprint sprint) {
        this.taskId = taskId;
        this.number = number;
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

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Sprint getSprint() {
        return sprint;
    }

    public void setSprint(Sprint sprint) {
        this.sprint = sprint;
    }
}
