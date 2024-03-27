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

    /* ----------------------------------- add ---------------------------------- */

    public void addProject(ProjectName projectName) {
        this.projects.add(new Project(projectName));
    }

    public void addTask(ProjectName projectName, String description) {

        for (Project project : this.projects) {

            if (project.getName().equals(projectName)) {
                project.addTask(new Task(this.nextId(), description, false));
                break;
            }
        }
    }

    /* ---------------------------------- check --------------------------------- */

    public void check(TaskId taskId, boolean isDone) {
        for (Project project : this.projects) {
            if (project.isTaskExist(taskId)) {
                project.check(taskId, isDone);
            }
        }
    }

    /* -------------------------------- is exist -------------------------------- */

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
            if (project.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /* ---------------------------------- show ---------------------------------- */

    public String getShow() {

        StringBuilder res = new StringBuilder();
        for (Project project : this.projects) {
            res.append(project.getShow());
        }
        return res.toString();
    }
}
