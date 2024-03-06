package com.codurance.training.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.codurance.training.base.BaseModel;
import com.codurance.training.tasks.data.Task;
import com.codurance.training.tasks.interfaces.ITaskListModel;
import com.codurance.training.tasks.interfaces.ITaskService;
import com.codurance.training.utils.Const;

public class TaskListModel extends BaseModel<ITaskService> implements ITaskListModel {

    private long lastId = 0;

    public TaskListModel(ITaskService service) {
        super(service);
    }

    private long nextId() {
        return ++lastId;
    }

    /* ---------------------------------- show ---------------------------------- */

    @Override
    public List<String> getShow() {
        List<String> res = new ArrayList<String>();
        for (Map.Entry<String, List<Task>> project : service.getProjects().entrySet()) {
            res.add(project.getKey());
            for (Task task : project.getValue()) {
                res.add(task.getShow());
            }
            res.add("");
        }
        return res;
    }

    /* ----------------------------------- add ---------------------------------- */

    @Override
    public String add(String[] commandRest) {
        String[] subcommandRest = commandRest[1].split(" ", 2);
        String subcommand = subcommandRest[0];
        if (subcommand.equals("project")) {
            return addProject(subcommandRest[1]);
        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[1].split(" ", 2);
            return addTask(projectTask[0], projectTask[1]);
        }
        return "";
    }

    private String addProject(String pName) {
        this.service.addProject(pName);
        return "";
    }

    private String addTask(String pName, String description) {
        List<Task> tasks = this.service.getTasks(pName);
        if (tasks == null) {
            return String.format(Const.getNoProjMsg(pName));
        }
        this.service.addTask(pName, new Task(nextId(), description, false));
        return "";
    }

    /* ---------------------------------- check --------------------------------- */

    @Override
    public String check(String idString) {
        return setDone(idString, true);
    };

    @Override
    public String uncheck(String idString) {
        return setDone(idString, false);
    };

    private String setDone(String idString, boolean done) {
        int tid = Integer.parseInt(idString);
        for (Map.Entry<String, List<Task>> project : this.service.getProjects().entrySet()) {
            for (Task task : project.getValue()) {
                if (task.getId() == tid) {
                    task.setDone(done);
                    return "";
                }
            }
        }
        return Const.getNoTaskMsg(tid);
    }

}
