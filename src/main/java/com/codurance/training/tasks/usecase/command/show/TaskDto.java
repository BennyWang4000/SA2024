package com.codurance.training.tasks.usecase.command.show;

public class TaskDto {

    private long id;

    private boolean isDone;

    private String description;

    private TaskDto(long id, boolean isDone, String description) {
        this.id = id;
        this.isDone = isDone;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static TaskDto of(long id, boolean isDone, String description) {
        return new TaskDto(id, isDone, description);
    }

}
