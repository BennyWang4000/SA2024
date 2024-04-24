package com.codurance.training.tasks.usecase.command.add;

import com.codurance.training.base.usecase.port.BaseInput;

public class AddTaskInput implements BaseInput {

    private String projectName;

    private String description;

    public AddTaskInput(String projectName, String description) {
        this.projectName = projectName;
        this.description = description;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
