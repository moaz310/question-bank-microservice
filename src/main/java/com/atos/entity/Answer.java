package com.atos.entity;

import org.springframework.data.annotation.Id;

public class Answer {
    @Id
    private String id;

    private String name;

    private String description;

    public Answer() {
    }

    public Answer(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Answer)) return false;
        return ((Answer) obj).id.equals(this.id);
    }
}
