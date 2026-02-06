package com.example.demo.task;
import jakarta.validation.constraints.NotBlank;

public class TaskRequest {
    @NotBlank
    private String taskName;

    public TaskRequest(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}
