package com.codurance.training.base.view;

import java.io.BufferedReader;
import java.io.PrintWriter;

public abstract class BaseView implements Runnable {

    protected BufferedReader reader = null;
    protected PrintWriter writer = null;

    protected BaseView(BufferedReader reader, PrintWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public abstract void run();
}
