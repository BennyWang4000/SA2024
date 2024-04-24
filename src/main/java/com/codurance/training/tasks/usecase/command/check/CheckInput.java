package com.codurance.training.tasks.usecase.command.check;

import com.codurance.training.base.usecase.port.BaseInput;

public class CheckInput implements BaseInput {

    private long taskId;

    private boolean isDone;

    public CheckInput(long taskId, boolean isDone) {
        this.taskId = taskId;
        this.isDone = isDone;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

}
