package xyz.dgz48.todob.data.entity;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "task")
public class TaskEntity {

    @Id
    @Column(name = "id")
    @NotEmpty
    private String id;

    @Column(name = "owner")
    @NotEmpty
    private String owner;

    @Column(name = "title")
    @NotEmpty
    private String title;

    @Column(name = "detail")
    private String detail;

    @Column(name = "deadline")
    private ZonedDateTime deadline;

    @Column(name = "done")
    private Boolean done;

    @Column(name = "created_date")
    @NotNull
    private ZonedDateTime createdDate;

    @Column(name = "last_modified_date")
    @NotNull
    private ZonedDateTime lastModifiedDate;
}
