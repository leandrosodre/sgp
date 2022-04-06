package com.sgp.model;

import java.util.Date;

public class Sprint {
    private final long sprintId;
    private final int number;
    private final int status;
    private final Date startDate;
    private final Date endDate;
    private final long teamId;

    public Sprint(final long sprintId, final int number, final int status, final Date startDate, final Date endDate, final long teamId) {
        this.sprintId = sprintId;
        this.number = number;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.teamId = teamId;
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

    public long getTeamId() {
        return teamId;
    }
}
