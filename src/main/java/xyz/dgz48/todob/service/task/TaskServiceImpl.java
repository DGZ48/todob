package xyz.dgz48.todob.service.task;

import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import xyz.dgz48.todob.common.exception.GeneralBusinessLogicException;
import xyz.dgz48.todob.common.exception.TargetNotFoundException;
import xyz.dgz48.todob.data.entity.TaskEntity;
import xyz.dgz48.todob.data.repository.TaskRepository;

@Service
@Transactional
class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ModelMapper dxo;

    @Override
    public Page<Task> list(String user) {
        return this.taskRepository.findByOwner(user).map(e -> this.dxo.map(e, Task.class));
    }

    @Override
    public Optional<Task> get(String user, String id) {

        Optional<TaskEntity> op = this.taskRepository.findById(id);
        if(op.isEmpty()) {
            return Optional.empty();
        }

        TaskEntity entity = op.get();
        if(!Objects.equals(user, entity.getOwner())) {
            return Optional.empty();
        }

        return Optional.of(dxo.map(entity, Task.class));
    }

    @Override
    public void register(String user, String id, TaskRequest request) {
        Optional<TaskEntity> op = this.taskRepository.findById(id);
        if(op.isPresent()) {
            throw new GeneralBusinessLogicException("IDは既に使用されています");
        }

        TaskEntity entity = new TaskEntity();
        entity.setId(id);
        dxo.map(request, entity);

        entity = this.taskRepository.save(entity);
    }

    @Override
    public void update(String user, String id, TaskRequest request) {
        Optional<TaskEntity> op = this.taskRepository.findById(id);
        if(op.isEmpty()) {
            throw new TargetNotFoundException("IDは見つかりません");
        }

        TaskEntity entity = op.get();
        dxo.map(request, entity);

        entity = this.taskRepository.save(entity);
    }

    @Override
    public void delete(String user, String id) {
        Optional<TaskEntity> op = this.taskRepository.findById(id);
        if(op.isEmpty()) {
            throw new TargetNotFoundException("IDは見つかりません");
        }

        TaskEntity entity = op.get();
        this.taskRepository.delete(entity);
    }

}
