package com.josayko.backend.data;

import org.springframework.data.annotation.Id;

public class ToDo {
    @Id
    private String id;

    private String title;
    private Boolean completed;
}
