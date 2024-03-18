package com.codurance.training.tasks.model;

import java.util.Map;

import com.codurance.training.base.BaseModel;
import com.codurance.training.base.BaseResult;
import com.codurance.training.tasks.entity.Const;
import com.codurance.training.tasks.entity.task.IsDone;
import com.codurance.training.tasks.entity.task.Project;
import com.codurance.training.tasks.entity.task.ProjectName;
import com.codurance.training.tasks.entity.task.Projects;
import com.codurance.training.tasks.entity.task.Task;
import com.codurance.training.tasks.entity.task.TaskId;
import com.codurance.training.tasks.entity.service.ITaskService;

public class TaskModel extends BaseModel<ITaskService> implements ITaskModel {

    private long lastId = 0;
    private final Projects projects = new Projects();

    public TaskModel(ITaskService service) {
        super(service);
    }

    private long nextId() {
        return ++lastId;
    }

    /* ---------------------------------- show ---------------------------------- */

    @Override
    public BaseResult<String> getShow() {
        try {
            return new BaseResult.Success<String>(this.projects.getShow());
        } catch (Exception e) {
            return new BaseResult.Error<>(e);
        }
    }

    /* ----------------------------------- add ---------------------------------- */

    public BaseResult<String> addProject(ProjectName name) {
        try {
            this.projects.addProject(name);
            return new BaseResult.Empty<>();
        } catch (Exception e) {
            return new BaseResult.Error<>(e);
        }
    }

    public BaseResult<String> addTask(ProjectName name, Task task) {
        try {
            if (this.projects.isKey(name)) {
                this.projects.addTask(name, new TaskId(nextId()), task);
                return new BaseResult.Empty<>();
            }
            return new BaseResult.Failure<>(Const.getNoProjMsg(name.getProjectName()));

        } catch (Exception e) {
            return new BaseResult.Error<>(e);
        }
    }

    /* ---------------------------------- check --------------------------------- */

    public BaseResult<String> setDone(TaskId id, IsDone isDone) {
        try {
            for (Map.Entry<ProjectName, Project> project : this.projects.getEntrySet())
                for (Map.Entry<TaskId, Task> task : project.getValue().getEntrySet()) {
                    if (task.getKey().getId() == id.getId()) {
                        task.getValue().setDone(isDone);
                        return new BaseResult.Success<String>("");
                    }
                }
            return new BaseResult.Failure<String>(Const.getNoTaskMsg(id.getId()));
        } catch (Exception e) {
            return new BaseResult.Error<>(e);
        }
    }
}