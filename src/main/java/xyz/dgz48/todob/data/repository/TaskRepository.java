package xyz.dgz48.todob.data.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import xyz.dgz48.todob.data.entity.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity, String> {

    Page<TaskEntity> findByOwner(String owner, Pageable pageable);
}
