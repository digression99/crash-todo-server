package com.devhouse.crashtodo.task;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class TitleUpdateDto implements TaskUpdateDto {
    String name;
    String title;

    @JsonCreator
    public TitleUpdateDto(@JsonProperty("name") String name,
                          @JsonProperty("title") String title) {
        this.name = name;
        this.title = title;
    }

    @Override
    public String getName() {
        return name;
    }
}