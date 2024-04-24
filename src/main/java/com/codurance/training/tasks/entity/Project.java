package com.codurance.training.tasks.entity;

import java.util.List;
import java.util.stream.Collectors;

import com.codurance.training.base.entity.BaseEntity;

public class Project extends BaseEntity<ProjectName> {
    private final List<Task> tasks;

    Project(ProjectName projectName, List<Task> tasks) {
        super(projectName);
        this.tasks = tasks;
    }

    /* ----------------------------------- get ---------------------------------- */

    public List<Task> getTasks() {

        return tasks.stream()
                .map(task -> (Task) new ImmutableTask(task.getId(), task.getDescription(), task.isDone()))
                .collect(Collectors.toList());
    }

    /* ----------------------------------- add ---------------------------------- */

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    /* ---------------------------------- check --------------------------------- */

    public void check(TaskId taskId, boolean isDone) {
        for (Task task : this.tasks) {
            if (task.getId().equals(taskId)) {
                task.setDone(IsDone.of(isDone));
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
