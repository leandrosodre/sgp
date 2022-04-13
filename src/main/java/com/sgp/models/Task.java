package com.sgp.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "task")
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long taskId;
    @NotNull
    private long number;

    @NotNull
    @Size(min = 10, max = 200)
    private String description;

    @NotNull
    private int priority;
    private float loggedTime;

    @NotNull
    private Date expectedDate;
    private Date actualDate;

    @ManyToOne
    private User user;
    @ManyToOne
    private Team team;
    @ManyToOne
    private Sprint sprint;

    public Task() {
        super();
    }

    public Task(final long taskId, final long number, final String description, final int priority, final float loggedTime, final Date expectedDate, final Date actualDate, final User user, final Team team, final Sprint sprint) {
        this.taskId = taskId;
        this.number = number;
        this.description = description;
        this.priority = priority;
        this.loggedTime = loggedTime;
        this.expectedDate = expectedDate;
        this.actualDate = actualDate;
        this.user = user;
        this.team = team;
        this.sprint = sprint;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(final long taskId) {
        this.taskId = taskId;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(final long number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(final int priority) {
        this.priority = priority;
    }

    public float getLoggedTime() {
        return loggedTime;
    }

    public void setLoggedTime(final float loggedTime) {
        this.loggedTime = loggedTime;
    }

    public Date getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(final Date expectedDate) {
        this.expectedDate = expectedDate;
    }

    public Date getActualDate() {
        return actualDate;
    }

    public void setActualDate(final Date actualDate) {
        this.actualDate = actualDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(final Team team) {
        this.team = team;
    }

    public Sprint getSprint() {
        return sprint;
    }

    public void setSprint(final Sprint sprint) {
        this.sprint = sprint;
    }
}
