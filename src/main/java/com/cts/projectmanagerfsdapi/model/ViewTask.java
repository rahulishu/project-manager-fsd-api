package com.cts.projectmanagerfsdapi.model;

public class ViewTask {

	private Task task;
	private ParentTask parentTask;

	public ViewTask(Task task, ParentTask parentTask) {
		this.task = task;
		this.parentTask = parentTask;
	}

	/**
	 * @return the task
	 */
	public Task getTask() {
		return task;
	}

	/**
	 * @return the parentTask
	 */
	public ParentTask getParentTask() {
		return parentTask;
	}

}
