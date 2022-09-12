package xyz.dgz48.todob.service.task;

import java.time.ZonedDateTime;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class TaskRequest {

    private @NotEmpty String title;

    private String detail;

    private ZonedDateTime deadline;

    private Boolean done;

}
