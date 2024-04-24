package com.codurance.training.tasks.usecase.command.add;

import com.codurance.training.base.usecase.port.BaseInput;

public class AddProjectInput implements BaseInput {

    private String name;

    public AddProjectInput(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
