package xyz.dgz48.todob.service.task;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@Transactional
class TaskServiceImpl implements TaskService {

    @Override
    public @NotNull Page<Task> list(String user, TaskRequest request) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public @NotNull Optional<Task> get(String user, String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void register(String user, String id, TaskRequest request) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void update(String user, String id, TaskRequest request) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(String user, String id) {
        // TODO Auto-generated method stub
        
    }
    
}
