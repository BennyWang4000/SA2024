package com.codurance.training.tasks.interfaces;

import java.util.List;

public interface ITaskListModel {

    public List<String> getShow();

    public String add(String[] commandRest);

    public String check(String idString);

    public String uncheck(String idString);

}
