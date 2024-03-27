package com.codurance.training.tasks.entity.service;

import com.codurance.training.tasks.entity.Const;
import com.codurance.training.tasks.entity.response.TaskResult;
import com.codurance.training.tasks.entity.task.ProjectName;
import com.codurance.training.tasks.entity.task.Projects;
import com.codurance.training.tasks.entity.task.TaskId;

public class TaskService implements ITaskService {

    @Override
    public TaskResult<Projects> addProject(Projects projects, ProjectName projectName) {
        projects.addProject(projectName);
        return TaskResult.success(projects);
    }

    @Override
    public TaskResult<Projects> addTask(Projects projects, ProjectName projectName, String description) {
        if (!projects.isProjectExist(projectName)) {
            System.out.println(Const.getNoProjMsg(projectName.getName()));
            return TaskResult.fail(Const.getNoProjMsg(projectName.getName()));
        }

        projects.addTask(projectName, description);

        return TaskResult.success(projects);

    }

    @Override
    public TaskResult<String> getShow(Projects projects) {
        return TaskResult.success(projects.getShow());
    }

    @Override
    public TaskResult<Projects> setDone(Projects projects, TaskId taskId, boolean isDone) {

        if (!projects.isTaskExist(taskId)) {
            return TaskResult.fail(Const.getNoTaskMsg(taskId.getId()));
        }
        projects.check(taskId, isDone);

        return TaskResult.success(projects);
    }
}
