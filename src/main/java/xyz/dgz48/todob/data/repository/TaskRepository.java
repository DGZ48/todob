package xyz.dgz48.todob.data.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

import xyz.dgz48.todob.data.entity.TaskEntity;

public interface TaskRepository extends PagingAndSortingRepository<TaskEntity, String> {

    Page<TaskEntity> findByOwner(String owner);
}
