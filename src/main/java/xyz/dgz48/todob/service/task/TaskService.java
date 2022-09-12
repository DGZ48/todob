package xyz.dgz48.todob.service.task;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;

@Validated
public interface TaskService {

    @NotNull Page<Task> list(String user, TaskRequest request);

    @NotNull Optional<Task> get(String user, String id);

    void register(String user, String id, TaskRequest request);

    void update(String user, String id, TaskRequest request);

    void delete(String user, String id);
}
