package com.codurance.training.tasks.usecase;

import com.codurance.training.base.BaseModel;
import com.codurance.training.tasks.adapter.controller.CommandController.AddType;
import com.codurance.training.tasks.entity.Const;
import com.codurance.training.tasks.entity.task.ProjectName;
import com.codurance.training.tasks.entity.task.Projects;
import com.codurance.training.tasks.entity.task.TaskId;
import com.codurance.training.tasks.usecase.response.TaskResult;

public class TaskModel extends BaseModel implements ITaskModel {

    private final Projects projects;

    public TaskModel() {
        super();
        this.projects = new Projects();
    }

    /* ---------------------------------- show ---------------------------------- */

    @Override
    public TaskResult<String> getShow() {
        return TaskResult.success(projects.getShow());
    }

    @Override
    public TaskResult<String> getHelp() {
        return TaskResult.success(Const.HELP_MSG);
    }

    @Override
    public TaskResult<String> getUnknown(String command) {
        return TaskResult.success(Const.getNoCmdMsg(command));
    }

    @Override
    public TaskResult<String> quit() {
        return TaskResult.quit();
    }

    /* ----------------------------------- add ---------------------------------- */

    @Override
    public TaskResult<String> add(String[] cmdRest) {
        try {
            String[] typeRest = cmdRest[1].split(" ", 2);
            String type = typeRest[0];
            switch (AddType.valueOf(type.toUpperCase())) {
                case PROJECT:
                    return addProject(typeRest[1]);
                case TASK:
                    return addTask(
                            typeRest[1].split(" ", 2)[0],
                            typeRest[1].split(" ", 2)[1]);
                default:
                    return TaskResult.fail(Const.getNoCmdMsg(type));
            }
        } catch (Exception e) {
            return TaskResult.error(e);
        }
    }

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
            return TaskResult.fail(Const.getNoProjMsg(projectName.getName()));
        }

        projects.addTask(projectName, description);

        return TaskResult.empty();

    }

    /* ---------------------------------- check --------------------------------- */
    @Override
    public TaskResult<String> setDone(String[] cmdRest, boolean isDone) {
        TaskId taskId = new TaskId(Long.parseLong(cmdRest[1]));

        if (!projects.isTaskExist(taskId)) {
            return TaskResult.fail(Const.getNoTaskMsg(taskId.getId()));
        }
        projects.check(taskId, isDone);

        return TaskResult.empty();

    }

}