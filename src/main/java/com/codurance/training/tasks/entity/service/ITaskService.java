package com.codurance.training.tasks.entity.service;

import com.codurance.training.tasks.entity.response.TaskResult;
import com.codurance.training.tasks.entity.task.IsDone;
import com.codurance.training.tasks.entity.task.ProjectName;
import com.codurance.training.tasks.entity.task.Projects;
import com.codurance.training.tasks.entity.task.TaskId;

public interface ITaskService {

    public TaskResult<Projects> addProject(Projects projects, ProjectName projectName);

    public TaskResult<Projects> addTask(Projects projects, ProjectName projectName, String description);

    public TaskResult<String> getShow(Projects projects);

    public TaskResult<Projects> setDone(Projects projects, TaskId taskId, boolean isDone);
}
