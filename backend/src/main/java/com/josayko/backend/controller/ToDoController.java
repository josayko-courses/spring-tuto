package com.josayko.backend.controller;

import com.josayko.backend.model.ToDo;
import com.josayko.backend.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todo")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    /**
     * Get all the todos
     * @return all the todos
     */
    @GetMapping
    public ResponseEntity<List<ToDo>> findAll() {
        return new ResponseEntity<>(toDoService.findAll(), HttpStatus.OK);
    }

    /**
     * Get a todo with id
     * @param id String
     * @return the todo or 404 not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") String id) {
        Optional<ToDo> todo = toDoService.findById(id);

        if (todo.isPresent()) {
            return new ResponseEntity<>(todo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Create a new todo
     * @param toDo the todo details
     * @return the new todo
     */
    @PostMapping
    public ResponseEntity<ToDo> create(@RequestBody ToDo toDo) {
        return new ResponseEntity<>(toDoService.save(toDo), HttpStatus.OK);
    }

    /**
     * Update an existing todo
     * @param id the todo to update
     * @param toDo new details to update
     * @return the updated todo
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") String id, @RequestBody ToDo toDo) {
        Optional<ToDo> todoData = toDoService.findById(id);

        if (todoData.isPresent()) {
            ToDo updatedToDo = todoData.get();
            updatedToDo.setTitle(toDo.getTitle());
            updatedToDo.setCompleted(toDo.getCompleted());
            return new ResponseEntity<>(toDoService.save(updatedToDo), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Delete a todo with id
     * @param id todo to delete
     * @return status code 204
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") String id) {
        toDoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
