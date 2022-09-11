package xyz.dgz48.todob.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import xyz.dgz48.todob.data.entity.Todo;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @GetMapping("/")
    private Flux<Todo> list() {
        // TODO
        return null;
    }

    @GetMapping("/{id}")
    private Mono<Todo> get(@PathVariable String id) {
        // TODO
        return null;
    }

    @PutMapping("/{id}")
    private void register(@PathVariable String id, @RequestBody Todo todo) {
        // TODO
    }

    @PostMapping("/{id}")
    private void update(@PathVariable String id, @RequestBody Todo todo) {
        // TODO
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable String id) {
        // TODO
    }
}
