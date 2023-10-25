package com.example.rest_test.model;

public class Fact {
    private String content;
    private FactAuthor author;
    private int id;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public FactAuthor getAuthor() {
        return author;
    }

    public void setAuthor(FactAuthor author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return author.getName() + ": " + content + " id:" + id;
    }
}
