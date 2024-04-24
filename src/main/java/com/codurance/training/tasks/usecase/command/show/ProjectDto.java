package com.codurance.training.tasks.usecase.command.show;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.codurance.training.tasks.entity.Project;

public class ProjectDto {

    private String projectName;

    ProjectDto(String projectName, List<TaskDto> tasks) {
        this.projectName = projectName;
        this.tasks = tasks;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    private List<TaskDto> tasks = new ArrayList<>();

    public void addTaskDto(TaskDto taskDto) {
        tasks.add(taskDto);
    }

    public List<TaskDto> getTaskDtos() {
        return tasks;
    }

    public static ProjectDto of(Project project) {
        return new ProjectDto(
                project.getId().getValue(),
                project.getTasks().stream()
                        .map(TaskMapper::toDto)
                        .collect(Collectors.toList()));
    }
}
