package com.josayko.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("todos")
public class ToDo {

    /***** Attributes *****/
    @Id
    private String id;

    private String title;

    private Boolean completed;

    public ToDo(String title, Boolean completed) {
        this.title = title;
        this.completed = completed;
    }

    /***** Getters *****/
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getCompleted() {
       return completed;
    }

    /***** Setters *****/
    public void setCompleted(Boolean value) {
        this.completed = value;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

}
