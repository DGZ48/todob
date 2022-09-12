package xyz.dgz48.todob.service.task;

import java.time.ZonedDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Task {

    @NotEmpty
    private String id;

    @NotEmpty
    private String title;

    private String detail;

    private ZonedDateTime deadline;

    @NotNull
    private Boolean done;

    @NotNull
    private ZonedDateTime createdDate;

    @NotNull
    private ZonedDateTime lastModifiedDate;

}
