package com.codurance.training.tasks.entity.task;

import java.util.List;
import java.util.ArrayList;

public class Projects {
    private final List<Project> projects;

    private long id;

    public Projects() {
        this.projects = new ArrayList<>();
        this.id = 0;
    }

    public long nextId() {
        return ++this.id;
    }

    public void addProject(ProjectName name) {
        this.projects.add(new Project(name));
    }

    public void addTask(ProjectName name, String description) {

        for (Project project : this.projects) {

            if (project.getName() == name) {
                project.addTask(new Task(this.nextId(), description, false));
                break;
            }
        }
    }

    public void check(TaskId taskId, boolean isDone) {
        for (Project project : this.projects) {
            if (project.isTaskExist(taskId)) {
                project.check(taskId, isDone);
            }
        }
    }

    public boolean isTaskExist(TaskId taskId) {
        for (Project project : this.projects) {
            if (project.isTaskExist(taskId)) {
                return true;
            }
        }
        return false;

    }

    public boolean isProjectExist(ProjectName name) {

        for (Project project : this.projects) {
            if (project.getName() == name) {
                return true;
            }
        }
        return false;
    }

    public String getShow() {

        StringBuilder res = new StringBuilder();
        for (Project project : this.projects) {
            res.append(project.getShow());
        }
        return res.toString();
    }

    public Project getProject(ProjectName name) {

        for (Project project : this.projects) {
            if (project.getName() == name) {
                return project;
            }
        }
        return null;
    }
}
