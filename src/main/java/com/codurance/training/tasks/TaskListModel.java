package com.codurance.training.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.codurance.training.base.BaseView;
import com.codurance.training.base.BaseModel;
import com.codurance.training.base.Task;
import com.codurance.training.utils.Const;

public class TaskListModel extends BaseModel {

    public TaskListModel(BaseView view) {
        super(view);
    }

    private TaskService taskService = new TaskService();

    private long lastId = 0;

    protected void check(String idString) {
        setDone(idString, true);
    };

    protected void uncheck(String idString) {
        setDone(idString, false);
    };

    protected void setDone(String idString, boolean done) {
        int tid = Integer.parseInt(idString);
        for (Map.Entry<String, List<Task>> project : this.taskService.getProjects().entrySet()) {
            for (Task task : project.getValue()) {
                if (task.getId() == tid) {
                    task.setDone(done);
                    return;
                }
            }
        }
        view.printLine(Const.getNoTaskMsg(tid));
    }

    protected long nextId() {
        return ++lastId;
    }

    protected void addProject(String pName) {
        this.taskService.addProject(pName);
    }

    protected void addTask(String pName, String description) {
        List<Task> tasks = this.taskService.getTasks(pName);
        if (tasks == null) {
            this.view.printLine(String.format(Const.getNoProjMsg(pName)));
            return;
        }
        this.taskService.addTask(pName, new Task(nextId(), description, false));
    }

    protected Map<String, List<Task>> getProjects() {
        return this.taskService.getProjects();
    }

    public void show() {
        List<String> res = new ArrayList<String>();
        for (Map.Entry<String, List<Task>> project : this.getProjects().entrySet()) {
            res.add(project.getKey());
            for (Task task : project.getValue()) {
                res.add(task.getShow());
            }
        }
        this.view.printLines(res);
    }
}
