package com.codurance.training.tasks.usecase;

import java.util.Map;

import com.codurance.training.base.BaseModel;
import com.codurance.training.tasks.entity.Const;
import com.codurance.training.tasks.entity.response.TaskResult;
import com.codurance.training.tasks.entity.service.ITaskService;
import com.codurance.training.tasks.entity.service.TaskService;
import com.codurance.training.tasks.entity.task.IsDone;
import com.codurance.training.tasks.entity.task.Project;
import com.codurance.training.tasks.entity.task.ProjectName;
import com.codurance.training.tasks.entity.task.Projects;
import com.codurance.training.tasks.entity.task.Task;
import com.codurance.training.tasks.entity.task.TaskId;

public class TaskModel extends BaseModel implements ITaskModel {

    private final Projects projects;
    private final ITaskService service = new TaskService();

    public TaskModel() {
        super();
        this.projects = new Projects();
    }

    /* ---------------------------------- show ---------------------------------- */

    @Override
    public String getShow() {
        return this.projects.getShow();
    }

    /* ----------------------------------- add ---------------------------------- */

    @Override
    public void addProject(String name) {
        ProjectName projectName = new ProjectName(name);
        TaskResult<Projects> result = this.service.addProject(projects, projectName);

        switch (result.getType()) {
            case FAILURE:
                // TODO
                break;
            default:
                break;
        }
    }

    @Override
    public void addTask(String name, String description) {
        ProjectName projectName = new ProjectName(name);

        TaskResult<Projects> result = this.service.addTask(projects, projectName, description);

        switch (result.getType()) {
            case FAILURE:
                // TODO
                break;
            default:
                break;
        }
    }

    /* ---------------------------------- check --------------------------------- */
    @Override
    public void setDone(long id, boolean isDone) {

        TaskId taskId = new TaskId(id);
        TaskResult<Projects> result = this.service.setDone(projects, taskId, isDone);

        switch (result.getType()) {
            case FAILURE:
                // TODO
                break;
            default:
                break;
        }

        // try {
        // return TaskResult.fail(Const.getNoTaskMsg(id.getId()));
        // } catch (Exception e) {
        // return TaskResult.error(e);
        // }
    }
}