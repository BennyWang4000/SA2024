package com.codurance.training.tasks;

import java.util.List;
import java.util.Map;

import com.codurance.training.base.Task;

public interface ITaskService {

    Map<String, List<Task>> getProjects();

    List<Task> getTasks(String pName);

    void addProject(String pName);

    void addTask(String pName, Task task);

    void uncheckTask(String pName, int tid);

    void checkTask(String pName, int tid);
}
