package com.example.demo.task;

public class TaskDto {
    private Long id;
    private String taskName;
    private boolean success;

    public TaskDto(Long id, String taskName, boolean success) {
        this.id = id;
        this.taskName = taskName;
        this.success = success;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
