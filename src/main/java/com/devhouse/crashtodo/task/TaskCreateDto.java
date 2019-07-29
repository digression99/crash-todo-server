package com.devhouse.crashtodo.task;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class TaskCreateDto {
    String title;

    @JsonCreator
    public TaskCreateDto(@JsonProperty("title") String title) {
        this.title = title;
    }
}
