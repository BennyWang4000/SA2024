package com.codurance.training.tasks.usecase.command.show;

import java.util.stream.Collectors;

import com.codurance.training.tasks.entity.Projects;

public class ProjectsMapper {
    private ProjectsMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static ProjectsDto toDto(Projects projects) {
        return new ProjectsDto(
                projects.getProjects().stream()
                        .map(ProjectMapper::toDto)
                        .collect(Collectors.toList()));
    }
}
