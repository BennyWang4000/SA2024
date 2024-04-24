package com.codurance.training.tasks.usecase;

import com.codurance.training.tasks.entity.Projects;

public class TaskRepository implements ITaskRepository {

    private Projects projects;

    public TaskRepository() {
        this.projects = new Projects("0001");
    }

    @Override
    public Projects getProjects() {
        return this.projects;
    }

    @Override
    public void save(Projects projects) {
        this.projects = projects;
    }

    // /* --------------------------------- query ---------------------------------
    // */

    // public TaskResult<String> getShow() {
    // return TaskResult.success(projects.getShow());
    // }

    // public TaskResult<String> getHelp() {
    // return TaskResult.success(MessageService.getHelpMsg());
    // }

    // public TaskResult<String> getUnknown(String command) {
    // return TaskResult.fail(MessageService.getCmdNotFound(command));
    // }

    // public TaskResult<String> quit() {
    // return TaskResult.quit();
    // }

    // /* --------------------------------- command --------------------------------
    // */

    // public TaskResult<String> addProject(String name) {

    // ProjectName projectName = new ProjectName(name);
    // projects.addProject(projectName);
    // return TaskResult.empty();
    // }

    // public TaskResult<String> addTask(String name, String description) {

    // ProjectName projectName = new ProjectName(name);

    // if (!projects.isProjectExist(projectName)) {
    // return
    // TaskResult.fail(MessageService.getProjNotFound(projectName.getValue()));
    // }

    // projects.addTask(projectName, description);

    // return TaskResult.empty();

    // }

    // /* ---------------------------------- check ---------------------------------
    // */
    // public TaskResult<String> setDone(String[] cmdRest, boolean isDone) {
    // TaskId taskId = new TaskId(Long.parseLong(cmdRest[1]));

    // if (!projects.isTaskExist(taskId)) {
    // return TaskResult.fail(MessageService.getTaskNotFound(taskId.getId()));
    // }
    // projects.check(taskId, isDone);

    // return TaskResult.empty();

    // }

}
