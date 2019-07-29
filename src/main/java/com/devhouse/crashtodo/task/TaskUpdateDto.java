package com.devhouse.crashtodo.task;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class TaskUpdateDto {
    String title;

    @JsonCreator
    public TaskUpdateDto(@JsonProperty("title") String title) {
        this.title = title;
    }
}