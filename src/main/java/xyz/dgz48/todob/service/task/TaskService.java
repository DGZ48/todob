package xyz.dgz48.todob.service.task;

import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;

@Validated
public interface TaskService {

    @NotNull @Valid Page<Task> list(@NotEmpty String user);

    @NotNull @Valid Optional<Task> get(@NotEmpty String user, @NotEmpty String id);

    void register(@NotEmpty String user, @NotEmpty String id, @NotNull @Valid TaskRequest request);

    void update(@NotEmpty String user, @NotEmpty String id, @NotNull @Valid TaskRequest request);

    void delete(@NotEmpty String user, @NotEmpty String id);
}
