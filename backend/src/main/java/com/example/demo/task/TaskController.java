package com.example.demo.task;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService=taskService;
    }

    @PostMapping
    public ResponseEntity<TaskResponse> addTask(@Valid @RequestBody TaskRequest taskRequest){
            taskService.addTask(taskRequest);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(new TaskResponse(true, "task added succesfully"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> update(@PathVariable("id") Long id, @Valid @RequestBody TaskRequest taskRequest)
    {
        taskService.updateTask(id, taskRequest);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new TaskResponse(true, "task updated succesfully"));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TaskResponse> done(@PathVariable("id") Long id)
    {
        taskService.doneTask(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new TaskResponse(true, "task done succesfully"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> task(@PathVariable("id") Long id){
        Task task=taskService.getTask(id);
        TaskDto taskDto=mapToDto(task);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(taskDto);

    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> task(){
        List<Task> tasks =taskService.getTasks();
        List<TaskDto> tasksDto=tasks
                .stream()
                .map(this::mapToDto)
                .toList();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tasksDto);

    }

    private TaskDto mapToDto(Task task) {
        return new TaskDto(
          task.getId(), task.getTaskName(), task.isStatus()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable("id") Long id){
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
