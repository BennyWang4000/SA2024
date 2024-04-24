package com.codurance.training.tasks.usecase;

import com.codurance.training.base.usecase.BaseModel;
import com.codurance.training.tasks.adapter.response.TaskResult;
import com.codurance.training.tasks.entity.MessageService;
import com.codurance.training.tasks.entity.ProjectName;
import com.codurance.training.tasks.entity.Projects;
import com.codurance.training.tasks.entity.TaskId;

public class TaskModel extends BaseModel implements ITaskModel {

    private final Projects projects;

    public TaskModel() {
        super();
        this.projects = new Projects("0001");
    }

    /* ---------------------------------- show ---------------------------------- */

    @Override
    public TaskResult<String> getShow() {
        return TaskResult.success(projects.getShow());
    }

    @Override
    public TaskResult<String> getHelp() {
        return TaskResult.success(MessageService.getHelpMsg());
    }

    @Override
    public TaskResult<String> getUnknown(String command) {
        return TaskResult.fail(MessageService.getCmdNotFound(command));
    }

    @Override
    public TaskResult<String> quit() {
        return TaskResult.quit();
    }

    /* ----------------------------------- add ---------------------------------- */

    @Override
    public TaskResult<String> addProject(String name) {

        ProjectName projectName = new ProjectName(name);
        projects.addProject(projectName);
        return TaskResult.empty();
    }

    @Override
    public TaskResult<String> addTask(String name, String description) {

        ProjectName projectName = new ProjectName(name);

        if (!projects.isProjectExist(projectName)) {
            return TaskResult.fail(MessageService.getProjNotFound(projectName.getValue()));
        }

        projects.addTask(projectName, description);

        return TaskResult.empty();

    }

    /* ---------------------------------- check --------------------------------- */
    @Override
    public TaskResult<String> setDone(String[] cmdRest, boolean isDone) {
        TaskId taskId = new TaskId(Long.parseLong(cmdRest[1]));

        if (!projects.isTaskExist(taskId)) {
            return TaskResult.fail(MessageService.getTaskNotFound(taskId.getId()));
        }
        projects.check(taskId, isDone);

        return TaskResult.empty();

    }

}