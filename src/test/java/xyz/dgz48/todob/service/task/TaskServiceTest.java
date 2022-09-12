package xyz.dgz48.todob.service.task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.domain.Page;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@Transactional
public class TaskServiceTest {

    @Autowired
    private TaskService taskService;

    @Test
    public void CRUDの確認() throws Exception {

        String user1 = "user1";

        Optional<Task> op = this.taskService.get(user1, "NOTEXISTS");
        assertTrue(op.isEmpty());

        TaskRequest task1Req1 = new TaskRequest();
        task1Req1.setTitle("たすく１");
        task1Req1.setDetail("たすくしょうさい１");
        task1Req1.setDeadline(ZonedDateTime.now().plusDays(3L));
        task1Req1.setDone(Boolean.TRUE);

        String id1 = UUID.randomUUID().toString();
        taskService.register(user1, id1, task1Req1);

        Task task1_1_before = taskService.get(user1, id1).get();
        assertEquals(id1, task1_1_before.getId());
        assertEquals(task1Req1.getTitle(), task1_1_before.getTitle());
        assertEquals(task1Req1.getDetail(), task1_1_before.getDetail());
        assertEquals(task1Req1.getDeadline(), task1_1_before.getDeadline());
        assertEquals(task1Req1.getDone(), task1_1_before.getDone());
        assertNotNull(task1_1_before.getCreatedDate());
        assertNotNull(task1_1_before.getLastModifiedDate());

        TaskRequest task1Req2 = new TaskRequest();
        task1Req2.setTitle("たすく１");
        task1Req2.setDetail(null);
        task1Req2.setDeadline(null);
        task1Req2.setDone(null);
        taskService.update(user1, id1, task1Req2);

        Task task1_1_after = taskService.get(user1, id1).get();
        assertEquals(id1, task1_1_after.getId());
        assertEquals(task1Req2.getTitle(), task1_1_after.getTitle());
        assertNull(task1_1_after.getDetail());
        assertNull(task1_1_after.getDeadline());
        assertEquals(Boolean.FALSE, task1_1_after.getDone());
        assertNotNull(task1_1_after.getCreatedDate());
        assertEquals(task1_1_before.getCreatedDate(), task1_1_after.getCreatedDate());
        assertNotNull(task1_1_after.getLastModifiedDate());
        assertNotEquals(task1_1_before.getLastModifiedDate(), task1_1_after.getLastModifiedDate());

        TaskRequest task2Req1 = new TaskRequest();
        task2Req1.setTitle("たすく２");
        task2Req1.setDetail("たすくしょうさい２");
        task2Req1.setDeadline(ZonedDateTime.now().plusDays(5L));
        task2Req1.setDone(Boolean.FALSE);

        String id2 = UUID.randomUUID().toString();
        taskService.register(user1, id2, task2Req1);

        String user2 = "user2";

        TaskRequest task3Req1 = new TaskRequest();
        task3Req1.setTitle("たすく３");
        task3Req1.setDetail("たすくしょうさい３");
        task3Req1.setDeadline(ZonedDateTime.now().plusDays(7L));
        task3Req1.setDone(null);

        String id3 = UUID.randomUUID().toString();
        taskService.register(user2, id3, task3Req1);

        Page<Task> tasks = taskService.list(user1);
        assertEquals(2, tasks.getNumberOfElements());

        taskService.delete(user1, id1);

        tasks = taskService.list(user1);
        assertEquals(1, tasks.getNumberOfElements());
    }
}
