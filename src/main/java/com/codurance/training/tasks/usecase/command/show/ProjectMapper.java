package com.codurance.training.tasks.usecase.command.show;

import java.util.stream.Collectors;

import com.codurance.training.tasks.entity.Project;

public class ProjectMapper {
    private ProjectMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static ProjectDto toDto(Project project) {
        return new ProjectDto(
                project.getId().getValue(),
                project.getTasks().stream()
                        .map(TaskMapper::toDto)
                        .collect(Collectors.toList()));
    }
}
