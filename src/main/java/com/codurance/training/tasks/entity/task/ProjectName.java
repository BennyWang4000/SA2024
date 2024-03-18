package com.codurance.training.tasks.entity.task;

public final class ProjectName {

    private final String projectName;

    public ProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectName() {
        return projectName;
    }

    @Override
    public int hashCode() {
        return this.projectName.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return this.hashCode() == o.hashCode();
    }
}
