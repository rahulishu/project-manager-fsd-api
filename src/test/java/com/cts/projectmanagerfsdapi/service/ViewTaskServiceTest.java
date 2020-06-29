package com.cts.projectmanagerfsdapi.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.cts.projectmanagerfsdapi.model.ParentTask;
import com.cts.projectmanagerfsdapi.model.Task;
import com.cts.projectmanagerfsdapi.model.ViewTask;

@RunWith(MockitoJUnitRunner.class)
public class ViewTaskServiceTest {

	@InjectMocks
	private ViewTaskService viewTaskService;

	@Mock
	private TaskService taskService;

	@Mock
	private ParentTaskService parentTaskService;

	private static final Integer ID = Integer.valueOf(1);

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(viewTaskService, "taskService", taskService);
		ReflectionTestUtils.setField(viewTaskService, "parentTaskService", parentTaskService);
	}

	@Test
	public void testGetAllViewTasks() {
		List<Task> tasks = new ArrayList<>();

		Task task = new Task();
		task.setTaskId(ID);
		task.setTaskName("taskName");
		task.setParentId(ID);

		tasks.add(task);

		when(taskService.getAllTasks()).thenReturn(tasks);

		List<ParentTask> parentTasks = new ArrayList<>();

		ParentTask parentTask = new ParentTask();
		parentTask.setParentId(ID);
		parentTask.setParentTask("parentTask");

		parentTasks.add(parentTask);

		when(parentTaskService.getAllParentTasks()).thenReturn(parentTasks);

		List<ViewTask> viewTasks = viewTaskService.getAllViewTasks();

		ViewTask viewTask = new ViewTask(task, parentTask);

		assertNotNull(viewTasks);
		assertEquals(1, viewTasks.size());

		assertEquals(viewTask.getTask().getTaskName(), viewTasks.get(0).getTask().getTaskName());
		assertEquals(viewTask.getParentTask().getParentTask(), viewTasks.get(0).getParentTask().getParentTask());

	}

	@Test
	public void testGetTaskById() {
		Task task = new Task();
		task.setTaskId(ID);
		task.setTaskName("taskName");
		task.setParentId(ID);

		Optional<Task> optionalTask = Optional.of(task);
		when(taskService.getTaskById(ID)).thenReturn(optionalTask);

		Optional<Task> taskById = viewTaskService.getTaskById(ID);
		assertNotNull(taskById);
		if (taskById.isPresent()) {
			assertEquals(taskById.get().getTaskName(), task.getTaskName());
		}
	}

	@Test
	public void testEditTask() {

		Task editTask = new Task();
		viewTaskService.editTask(editTask);

	}

}
