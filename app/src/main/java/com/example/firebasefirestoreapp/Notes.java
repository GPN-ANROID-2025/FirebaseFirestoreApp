package com.example.firebasefirestoreapp;

public class Notes {
    String id;
    String title;
    String text;

    public Notes(String id, String text, String title) {
        this.id = id;
        this.text = text;
        this.title = title;
    }

    public Notes() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
