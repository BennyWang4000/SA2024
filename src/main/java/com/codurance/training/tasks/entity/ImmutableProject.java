package com.codurance.training.tasks.entity;

import java.util.List;

public final class ImmutableProject extends Project {

    ImmutableProject(ProjectName projectName, List<Task> tasks) {
        super(projectName, tasks);
    }

}
