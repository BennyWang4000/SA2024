package com.codurance.training.tasks;

import java.util.List;
import java.util.Map;

import com.codurance.training.base.Task;

public interface TaskServiceInterface {
    Map<String, List<Task>> getProjects();

    List<Task> getTasks(String pName);

    void addProject(String pName);

    void addTask(String pName, Task task);

    void uncheckTask(int tid);

    void checkTask(int tid);
}
