package com.codurance.training.tasks.model;

import com.codurance.training.base.BaseResult;
import com.codurance.training.tasks.entity.task.IsDone;
import com.codurance.training.tasks.entity.task.ProjectName;
import com.codurance.training.tasks.entity.task.Task;
import com.codurance.training.tasks.entity.task.TaskId;

public interface ITaskModel {

    /* ---------------------------------- show ---------------------------------- */

    public BaseResult<String> getShow();

    /* ----------------------------------- add ---------------------------------- */

    public BaseResult<String> addProject(ProjectName name);

    public BaseResult<String> addTask(ProjectName name, Task task);

    /* ---------------------------------- check --------------------------------- */

    public BaseResult<String> setDone(TaskId id, IsDone isDone);

}
