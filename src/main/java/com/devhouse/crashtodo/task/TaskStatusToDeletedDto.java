package com.devhouse.crashtodo.task;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TaskStatusToDeletedDto implements TaskUpdateDto {
    String name;

    @JsonCreator
    public TaskStatusToDeletedDto(@JsonProperty("name") String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
