package com.codurance.training.tasks;

import java.util.List;
import java.util.Map;

import com.codurance.training.base.BaseView;
import com.codurance.training.base.BaseViewModel;
import com.codurance.training.base.Task;
import com.codurance.training.utils.Const;

public class TaskViewModel extends BaseViewModel {

    public TaskViewModel(BaseView view) {
        super(view);
    }

    private TaskService taskService = new TaskService();

    private long lastId = 0;

    protected void add(String commandLine) {
        String[] subcommandRest = commandLine.split(" ", 2);
        String subcommand = subcommandRest[0];
        if (subcommand.equals("project")) {
            addProject(subcommandRest[1]);
        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[1].split(" ", 2);
            this.addTask(projectTask[0], projectTask[1]);
        }
    }

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

    protected void uncheckTask(int tid) {
        this.taskService.uncheckTask(tid);
    }

    protected void checkTask(int tid) {
        this.taskService.checkTask(tid);
    }

    protected Map<String, List<Task>> getProjects() {
        return this.taskService.getProjects();
    }
}
