package com.sgp.model;

public class Task {
    private final long taskId;
    private final String description;
    private final int priority;
    private final int status;
    private final long userId;
    private final long teamId;
    private final long sprintId;

    public Task(final long taskId, final String description, final int priority, final int status, final long userId, final long teamId, final long sprintId) {
        this.taskId = taskId;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.userId = userId;
        this.teamId = teamId;
        this.sprintId = sprintId;
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

    public long getUserId() {
        return userId;
    }

    public long getTeamId() {
        return teamId;
    }

    public long getSprintId() {
        return sprintId;
    }
}
