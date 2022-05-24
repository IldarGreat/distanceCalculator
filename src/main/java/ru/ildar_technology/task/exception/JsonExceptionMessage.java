package ru.ildar_technology.task.exception;

public class JsonExceptionMessage {
    private String info;

    public JsonExceptionMessage() {
    }

    public JsonExceptionMessage(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
