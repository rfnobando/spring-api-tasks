package com.api.tasks.controllers;

import com.api.tasks.models.Task;
import com.api.tasks.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ArrayList<Task> getTasks() {
        return this.taskService.getTasks();
    }

    @PostMapping
    public Task saveTask(@RequestBody Task task) {
        return this.taskService.saveTask(task);
    }

    @GetMapping(path = "/{id}")
    public Optional<Task> getTask(@PathVariable Long id) {
        return this.taskService.getTask(id);
    }

    @PutMapping(path = "/{id}")
    public Task updateTask(@RequestBody Task request, @PathVariable Long id) {
        return this.taskService.updateTask(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteTask(@PathVariable  Long id) {
        boolean ok = this.taskService.deleteTask(id);

        if (ok) {
            return "Task #" + id + " has been deleted.";
        } else {
            return "Can't delete task #" + id;
        }
    }

}
