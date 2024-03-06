package com.codurance.training.tasks.interfaces;

import java.util.List;

public interface ITaskListModel {

    List<String> getShow();

    String add(String[] commandRest);

    String check(String idString);

    String uncheck(String idString);

}
