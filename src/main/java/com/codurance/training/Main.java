package com.codurance.training;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import com.codurance.training.tasks.view.ITaskView;
import com.codurance.training.tasks.view.TaskView;

public class Main {
    public static void main(String[] args) {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        ITaskView taskList = new TaskView(in, out);
        taskList.run();
    }
}
