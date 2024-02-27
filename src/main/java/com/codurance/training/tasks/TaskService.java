package com.codurance.training.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.codurance.training.base.Task;

public class TaskService implements TaskServiceInterface {
    private TaskHolder taskHolder = new TaskHolder();

    @Override
    public Map<String, List<Task>> getProjects() {
        return this.taskHolder.projects;
    }

    @Override
    public List<Task> getTasks(String pName) {
        return this.taskHolder.projects.get(pName);
    }

    @Override
    public void addProject(String pName) {
        this.taskHolder.projects.put(pName, new ArrayList<Task>());
    }

    @Override
    public void addTask(String pName, Task task) {
        this.taskHolder.projects.get(pName).add(task);
    }

    @Override
    public void uncheckTask(int tid) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'uncheckTask'");
    }

    @Override
    public void checkTask(int tid) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkTask'");
    }

}
