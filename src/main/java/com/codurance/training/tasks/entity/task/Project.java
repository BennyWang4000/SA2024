package com.codurance.training.tasks.entity.task;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Project {
    final Map<TaskId, Task> tasks;

    Project() {
        this.tasks = new LinkedHashMap<TaskId, Task>();
    }

    public void addTask(TaskId id, Task task) {
        this.tasks.put(id, task);
    }

    public Set<Entry<TaskId, Task>> getEntrySet() {
        return this.tasks.entrySet();
    }

    public String getShow() {
        String res = "";

        for (Map.Entry<TaskId, Task> task : this.tasks.entrySet()) {
            res += task.getValue().getShow(task.getKey().getId()) + "\n";
        }
        return res + "\n";
    }
}
