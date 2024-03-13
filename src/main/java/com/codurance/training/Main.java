package com.codurance.training;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import com.codurance.training.tasks.TaskList;
import com.codurance.training.tasks.interfaces.ITaskList;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        ITaskList taskList = new TaskList(reader, writer);
        taskList.run();
    }
}
