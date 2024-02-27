package com.codurance.training.tasks;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.codurance.training.base.Task;

/**
 * TaskHolder
 */
public class TaskHolder {
    protected final Map<String, List<Task>> projects = new LinkedHashMap<>();
}