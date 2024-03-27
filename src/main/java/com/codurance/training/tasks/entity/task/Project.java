package com.codurance.training.tasks.entity.task;

import java.util.List;
import java.util.ArrayList;

public class Project {
    private final ProjectName name;
    private final List<Task> tasks;

    Project(ProjectName projectName) {
        this.name = projectName;
        this.tasks = new ArrayList<>();
    }

    public ProjectName getName() {
        return this.name;
    }

    public boolean isTaskExist(TaskId taskId) {
        for (Task task : this.tasks) {
            if (task.getId().equals(taskId)) {
                return true;
            }
        }
        return false;
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public String getShow() {
        StringBuilder res = new StringBuilder();
        res.append(this.name.getName() + "\n");

        for (Task task : this.tasks) {
            res.append(task.getShow() + "\n");
        }
        return res.toString() + "\n";
    }

    public Task getTask(TaskId taskId) {
        for (Task task : this.tasks) {
            if (task.getId().equals(taskId)) {
                return task;
            }
        }
        return null;
    }

    public void check(TaskId taskId, boolean isDone) {
        for (Task task : this.tasks) {
            if (task.getId().equals(taskId)) {
                task.setDone(isDone);
            }
        }
    }
}
