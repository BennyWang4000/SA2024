package com.codurance.training.tasks.entity;

import java.util.List;

import com.codurance.training.base.entity.BaseEntity;

import java.util.ArrayList;

public class Project extends BaseEntity<ProjectName> {
    private final List<Task> tasks;

    Project(ProjectName projectName) {
        super(projectName);
        this.tasks = new ArrayList<>();
    }

    /* ----------------------------------- add ---------------------------------- */

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    /* ---------------------------------- check --------------------------------- */

    public void check(TaskId taskId, boolean isDone) {
        for (Task task : this.tasks) {
            if (task.getId().equals(taskId)) {
                task.setDone(isDone);
            }
        }
    }

    public boolean isTaskExist(TaskId taskId) {
        for (Task task : this.tasks) {
            if (task.getId().equals(taskId)) {
                return true;
            }
        }
        return false;
    }

    /* ---------------------------------- show ---------------------------------- */

    public String getShow() {
        StringBuilder res = new StringBuilder();
        res.append(this.id.getValue() + "\n");

        for (Task task : this.tasks) {
            res.append(task.getShow() + "\n");
        }
        return res.toString() + "\n";
    }
}
