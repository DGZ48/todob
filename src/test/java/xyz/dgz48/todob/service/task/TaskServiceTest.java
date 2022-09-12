package xyz.dgz48.todob.service.task;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@Transactional
public class TaskServiceTest {

    @Autowired
    private TaskService taskService;

    @Test
    public void CRUDの確認() throws Exception {

        Optional<Task> op = this.taskService.get(null, "NOTEXISTS");
        assertTrue(op.isEmpty());
    }
}
