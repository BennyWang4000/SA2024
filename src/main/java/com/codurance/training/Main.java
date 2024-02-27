package com.codurance.training;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import com.codurance.training.tasks.TaskView;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        TaskView taskView = new TaskView(reader, writer);
        taskView.run();
    }
}
