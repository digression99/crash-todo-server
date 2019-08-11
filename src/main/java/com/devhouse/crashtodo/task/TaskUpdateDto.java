package com.devhouse.crashtodo.task;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "name",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = TaskStatusToCreatedDto.class, name = "created"),
        @JsonSubTypes.Type(value = TaskStatusToDeletedDto.class, name = "deleted"),
        @JsonSubTypes.Type(value = TitleUpdateDto.class, name = "title") }
)
public interface TaskUpdateDto {
    String getName();
}
