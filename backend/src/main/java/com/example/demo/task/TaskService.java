package com.example.demo.task;

import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository=taskRepository;
    }

    public Task addTask(TaskRequest taskRequest) {
        Task task=new Task();
        task.setStatus(false);
        task.setTaskName(taskRequest.getTaskName());
        task.setCreatedAt(LocalDateTime.now());
        return taskRepository.save(task);
    }

    private Task getOrThrowTask(Long id){
        Task task=taskRepository
                .findById(id).orElseThrow(()-> new ResourceNotFoundException("Task not found "+id));
        return task;
    }

    @Transactional
    public Long updateTask(Long id, TaskRequest taskRequest){
        Task task=getOrThrowTask(id);
        task.setTaskName(taskRequest.getTaskName());
        taskRepository.save(task);
        return task.getId();
    }

    @Transactional
    public Long doneTask(Long id) {
        Task task=getOrThrowTask(id);
        task.setStatus(true);
        taskRepository.save(task);
        return task.getId();
    }


    public Task getTask(Long id) {
        return getOrThrowTask(id);
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @Transactional
    public void deleteTask(Long id) {
        Task task=getOrThrowTask(id);
        taskRepository.delete(task);
    }

}
