package com.josayko.backend.service;

import com.josayko.backend.data.ToDo;
import com.josayko.backend.exception.EntityNotFoundException;
import com.josayko.backend.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    public List<ToDo> findAll() {
        return toDoRepository.findAll();
    }

    public ToDo findById(String id) {
        return toDoRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public ToDo save(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    public void deleteById(String id) {
        toDoRepository.deleteById(id);
    }

}
