package com.codurance.training.tasks.entity;

public final class ImmutableTask extends Task {

    public ImmutableTask(TaskId id, String description, IsDone done) {
        super(id, description, done);
    }

}
