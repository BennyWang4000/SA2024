package com.codurance.training.tasks.usecase.command.show;

import java.util.ArrayList;
import java.util.List;

public class ProjectsDto {

    private List<ProjectDto> projects = new ArrayList<>();

    public ProjectsDto(List<ProjectDto> projects) {
        this.projects = projects;
    }

    public List<ProjectDto> getProjectDtos() {
        return projects;
    }

    public void setProjects(List<ProjectDto> projects) {
        this.projects = projects;
    }
}
