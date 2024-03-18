package com.codurance.training.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

public abstract class BaseView implements Runnable {

    private BufferedReader reader = null;
    private PrintWriter writer = null;

    // public BaseView() {
    // this.reader = new BufferedReader(new InputStreamReader(System.in));
    // this.writer = new PrintWriter(System.out);
    // }
    public BaseView(BufferedReader reader, PrintWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    protected String readLine() throws IOException {
        return reader.readLine();
    }

    protected void print(String line) {
        writer.print(line);
    }

    protected void printLine(String line) {
        writer.print(line);
    }

    protected void printLines(List<String> lines) {
        for (String line : lines)
            writer.println(line);
    }

    protected void flush() {
        writer.flush();
    }

    public abstract void run();
}
