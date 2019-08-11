package com.devhouse.crashtodo.task;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class TaskStatusToCreatedDto implements TaskUpdateDto {
    String name;

    @JsonCreator
    public TaskStatusToCreatedDto(@JsonProperty("name") String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
