package com.codurance.training.base;

import java.io.BufferedReader;
import java.io.PrintWriter;

public abstract class BaseView implements Runnable {

    protected BufferedReader reader = null;
    protected PrintWriter writer = null;

    protected BaseView(BufferedReader reader, PrintWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public abstract void run();
}
