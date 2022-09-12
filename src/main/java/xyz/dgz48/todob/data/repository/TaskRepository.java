package xyz.dgz48.todob.data.repository;

import org.springframework.data.repository.CrudRepository;

import xyz.dgz48.todob.data.entity.TaskEntity;

public interface TaskRepository extends CrudRepository<TaskEntity, String> {

}
