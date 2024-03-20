package com.codurance.training.tasks.model;

import com.codurance.training.tasks.entity.response.TaskResult;
import com.codurance.training.tasks.entity.task.IsDone;
import com.codurance.training.tasks.entity.task.ProjectName;
import com.codurance.training.tasks.entity.task.Task;
import com.codurance.training.tasks.entity.task.TaskId;

public interface ITaskModel {

    /* ---------------------------------- show ---------------------------------- */

    public TaskResult<String> getShow();

    /* ----------------------------------- add ---------------------------------- */

    public TaskResult<String> addProject(ProjectName name);

    public TaskResult<String> addTask(ProjectName name, Task task);

    /* ---------------------------------- check --------------------------------- */

    public TaskResult<String> setDone(TaskId id, IsDone isDone);

}
