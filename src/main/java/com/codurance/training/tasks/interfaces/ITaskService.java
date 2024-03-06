package com.codurance.training.tasks.interfaces;

import java.util.List;
import java.util.Map;

import com.codurance.training.tasks.data.Task;

public interface ITaskService {

    Map<String, List<Task>> getProjects();

    List<Task> getTasks(String pName);

    void addProject(String pName);

    void addTask(String pName, Task task);

    void uncheckTask(String pName, int tid);

    void checkTask(String pName, int tid);
}
