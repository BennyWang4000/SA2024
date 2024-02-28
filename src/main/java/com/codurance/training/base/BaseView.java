package com.codurance.training.base;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;

public abstract class BaseView implements Runnable {

    protected BufferedReader reader = null;
    protected PrintWriter writer = null;

    public BaseView(BufferedReader reader, PrintWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public void printLine(String line) {
        writer.println(line);
    }

    public void printLines(List<String> lines) {
        for (String line : lines) {
            writer.println(line);
        }
    }

    public abstract void run();
}
