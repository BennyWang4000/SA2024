package com.codurance.training.tasks.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.codurance.training.base.entity.BaseAggregate;

public class Projects extends BaseAggregate<String, Project> {

    private long taskId;

    public Projects(String id) {
        super(id);
        this.taskId = 0;
    }

    public long nextId() {
        return ++this.taskId;
    }

    /* ----------------------------------- get ---------------------------------- */

    public List<Project> getProjects() {
        return contents.stream()
                .map(project -> (Project) new ImmutableProject(project.getId(), project.getTasks()))
                .collect(Collectors.toList());
    }

    /* ----------------------------------- add ---------------------------------- */

    public void addProject(ProjectName projectName) {
        this.contents.add(new Project(projectName, new ArrayList<>()));
    }

    public void addTask(ProjectName projectName, String description) {

        for (Project project : this.contents) {

            if (project.getId().equals(projectName)) {
                project.addTask(new Task(new TaskId(this.nextId()), description, IsDone.of(false)));
                break;
            }
        }
    }

    /* ---------------------------------- check --------------------------------- */

    public void check(TaskId taskId, boolean isDone) {

        for (Project project : this.contents) {
            if (project.isTaskExist(taskId)) {
                project.check(taskId, isDone);
            }
        }
    }

    public boolean isTaskExist(TaskId taskId) {

        for (Project project : this.contents) {
            if (project.isTaskExist(taskId)) {
                return true;
            }
        }
        return false;
    }

    public boolean isProjectExist(ProjectName name) {

        for (Project project : this.contents) {
            if (project.getId().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /* ---------------------------------- show ---------------------------------- */

    public String getShow() {

        StringBuilder res = new StringBuilder();
        for (Project project : this.contents) {
            res.append(project.getShow());
        }
        return res.toString();
    }
}
