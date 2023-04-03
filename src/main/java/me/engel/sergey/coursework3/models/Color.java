package me.engel.sergey.coursework3.models;

public enum Color {
    BLACK("Black"),
    RED("Red"),
    YELLOW("Yellow");

    private final String text;

    Color(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}