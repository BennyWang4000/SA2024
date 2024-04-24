package com.codurance.training.tasks.usecase.command.show;

import com.codurance.training.tasks.entity.Task;

public class TaskMapper {

    private TaskMapper() {
        throw new IllegalStateException("Utility mapper class");
    }

    public static TaskDto toDto(Task task) {
        return TaskDto.of(
                task.getId().getValue(),
                task.isDone().getValue(),
                task.getDescription());
    }
}
