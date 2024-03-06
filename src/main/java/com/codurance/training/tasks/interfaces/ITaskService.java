package com.codurance.training.tasks.interfaces;

import java.util.List;
import java.util.Map;

import com.codurance.training.tasks.data.Task;

public interface ITaskService {

    public Map<String, List<Task>> getProjects();

    public List<Task> getTasks(String pName);

    public void addProject(String pName);

    public void addTask(String pName, Task task);

    public void uncheckTask(String pName, int tid);

    public void checkTask(String pName, int tid);
}
