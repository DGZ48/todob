package xyz.dgz48.todob.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.dgz48.todob.service.task.Task;
import xyz.dgz48.todob.service.task.TaskRequest;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @GetMapping("/")
    private Page<Task> list() {
        // TODO
        return null;
    }

    @GetMapping("/{id}")
    private Task get(@PathVariable String id) {
        // TODO
        return null;
    }

    @PutMapping("/{id}")
    private void register(@PathVariable String id, @RequestBody TaskRequest request) {
        // TODO
    }

    @PostMapping("/{id}")
    private void update(@PathVariable String id, @RequestBody TaskRequest request) {
        // TODO
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable String id) {
        // TODO
    }
}
