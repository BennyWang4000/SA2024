package com.codurance.training.tasks.entity.task;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Projects {
    private final Map<ProjectName, Project> projects;

    public Projects() {
        this.projects = new LinkedHashMap<ProjectName, Project>();
    };

    public void addProject(ProjectName name) {
        this.projects.put(name, new Project());
    };

    public void addTask(ProjectName name, TaskId id, Task task) {
        this.projects.get(name).addTask(id, task);
    };

    public boolean isKey(ProjectName name) {
        return this.projects.keySet().contains(name);
    }

    public Set<Entry<ProjectName, Project>> getEntrySet() {
        return this.projects.entrySet();
    }

    public String getShow() {

        String res = "";
        for (Map.Entry<ProjectName, Project> project : this.projects.entrySet()) {
            res += project.getKey().getProjectName() + "\n" + project.getValue().getShow();
        }
        return res;
    };
}
