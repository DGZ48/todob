package xyz.dgz48.todob.data.entity;

import java.time.ZonedDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Todo {

    private @NotEmpty String id;

    private @NotEmpty String title;

    private @NotEmpty String detail;

    private ZonedDateTime deadline;

    private @NotNull ZonedDateTime createdAt;

    private @NotNull ZonedDateTime modifiedAt;
}
