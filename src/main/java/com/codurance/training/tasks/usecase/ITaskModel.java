package com.codurance.training.tasks.usecase;

public interface ITaskModel {

    /* ---------------------------------- show ---------------------------------- */

    public String getShow();

    /* ----------------------------------- add ---------------------------------- */

    public void addProject(String name);

    public void addTask(String name, String description);

    /* ---------------------------------- check --------------------------------- */

    public void setDone(long id, boolean isDone);

}
