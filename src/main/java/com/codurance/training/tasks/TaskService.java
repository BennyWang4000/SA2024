package com.codurance.training.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.codurance.training.base.Task;

public class TaskService implements ITaskService {

    @Override
    public Map<String, List<Task>> getProjects() {
        return TaskHolder.projects;
    }

    @Override
    public List<Task> getTasks(String pName) {
        return TaskHolder.projects.get(pName);
    }

    @Override
    public void addProject(String pName) {
        TaskHolder.projects.put(pName, new ArrayList<Task>());
    }

    @Override
    public void addTask(String pName, Task task) {
        TaskHolder.projects.get(pName).add(task);
    }

    @Override
    public void uncheckTask(String pName, int tid) {
        TaskHolder.projects.get(pName).get(tid).setDone(true);

    }

    @Override
    public void checkTask(String pName, int tid) {
        TaskHolder.projects.get(pName).get(tid).setDone(true);
    }

}
