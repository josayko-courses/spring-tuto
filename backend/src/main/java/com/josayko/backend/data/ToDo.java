package com.josayko.backend.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("todos")
public class ToDo {

    @Id
    private String id;

    private String title;

    private Boolean completed;

    public ToDo(String title, Boolean completed) {
        this.title = title;
        this.completed = completed;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getCompleted() {
       return completed;
    }

}
