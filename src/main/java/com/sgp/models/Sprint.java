package com.sgp.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "sprint")
public class Sprint implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sprintId;
    private int number;
    private int status;
    private Date startDate;
    private Date endDate;

    @ManyToOne
    private Team team;

    public Sprint() {
        super();
    }

    public Sprint(final long sprintId, final int number, final int status, final Date startDate, final Date endDate, final Team team) {
        this.sprintId = sprintId;
        this.number = number;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.team = team;
    }

    public long getSprintId() {
        return sprintId;
    }

    public int getNumber() {
        return number;
    }

    public int getStatus() {
        return status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Team getTeam() {
        return team;
    }
}
