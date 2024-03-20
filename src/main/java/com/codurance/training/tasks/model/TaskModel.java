package com.codurance.training.tasks.model;

import java.util.Map;

import com.codurance.training.base.BaseModel;
import com.codurance.training.tasks.entity.Const;
import com.codurance.training.tasks.entity.response.TaskResult;
import com.codurance.training.tasks.entity.task.IsDone;
import com.codurance.training.tasks.entity.task.Project;
import com.codurance.training.tasks.entity.task.ProjectName;
import com.codurance.training.tasks.entity.task.Projects;
import com.codurance.training.tasks.entity.task.Task;
import com.codurance.training.tasks.entity.task.TaskId;

public class TaskModel extends BaseModel implements ITaskModel {

    private long lastId = 0;
    private final Projects projects = new Projects();

    public TaskModel() {
        super();
    }

    private long nextId() {
        return ++lastId;
    }

    /* ---------------------------------- show ---------------------------------- */

    @Override
    public TaskResult<String> getShow() {
        try {
            return TaskResult.success(this.projects.getShow());
        } catch (Exception e) {
            return TaskResult.error(e);
        }
    }

    /* ----------------------------------- add ---------------------------------- */

    public TaskResult<String> addProject(ProjectName name) {
        try {
            this.projects.addProject(name);
            return TaskResult.empty();
        } catch (Exception e) {
            return TaskResult.error(e);
        }
    }

    public TaskResult<String> addTask(ProjectName name, Task task) {
        try {
            if (this.projects.isKey(name)) {
                this.projects.addTask(name, new TaskId(nextId()), task);
                return TaskResult.empty();
            }
            return TaskResult.fail(Const.getNoProjMsg(name.getProjectName()));

        } catch (Exception e) {
            return TaskResult.error(e);
        }
    }

    /* ---------------------------------- check --------------------------------- */

    public TaskResult<String> setDone(TaskId id, IsDone isDone) {
        try {
            for (Map.Entry<ProjectName, Project> project : this.projects.getEntrySet())
                for (Map.Entry<TaskId, Task> task : project.getValue().getEntrySet()) {
                    if (task.getKey().getId() == id.getId()) {
                        task.getValue().setDone(isDone);
                        return TaskResult.empty();
                    }
                }
            return TaskResult.fail(Const.getNoTaskMsg(id.getId()));
        } catch (Exception e) {
            return TaskResult.error(e);
        }
    }
}