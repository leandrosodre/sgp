package com.sgp.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "sprint")
public class Sprint implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sprintId;

    @NotNull
    private int number;
    private boolean open;

    @NotNull
    private Date startDate;

    @NotNull
    private Date endDate;

    @ManyToOne
    private Team team;

    public Sprint() {
        super();
    }

    public Sprint(final long sprintId, final int number, final boolean open, final Date startDate, final Date endDate, final Team team) {
        this.sprintId = sprintId;
        this.number = number;
        this.open = open;
        this.startDate = startDate;
        this.endDate = endDate;
        this.team = team;
    }

    public long getSprintId() {
        return sprintId;
    }

    public void setSprintId(final long sprintId) {
        this.sprintId = sprintId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(final int number) {
        this.number = number;
    }

    public boolean getOpen() {
        return open;
    }

    public void setOpen(final boolean open) {
        this.open = open;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(final Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(final Date endDate) {
        this.endDate = endDate;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(final Team team) {
        this.team = team;
    }
}
