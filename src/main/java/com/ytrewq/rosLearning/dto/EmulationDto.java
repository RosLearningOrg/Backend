package com.ytrewq.rosLearning.dto;

import com.ytrewq.rosLearning.entities.Task;

import java.time.LocalDateTime;

public class EmulationDto {
    private String private_title;
    private LocalDateTime dateOfCreation;
    private Integer timerTime;
    private String timerDescription;
    private String screenImageURL;
    private String blockSchemeJSON;
    private String blockCodeJS;
    private String byteArrayInterface;
    private Task task;

    public String getPrivate_title() {
        return private_title;
    }

    public void setPrivate_title(String private_title) {
        this.private_title = private_title;
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public Integer getTimerTime() {
        return timerTime;
    }

    public void setTimerTime(Integer timerTime) {
        this.timerTime = timerTime;
    }

    public String getTimerDescription() {
        return timerDescription;
    }

    public void setTimerDescription(String timerDescription) {
        this.timerDescription = timerDescription;
    }

    public String getScreenImageURL() {
        return screenImageURL;
    }

    public void setScreenImageURL(String screenImageURL) {
        this.screenImageURL = screenImageURL;
    }

    public String getBlockSchemeJSON() {
        return blockSchemeJSON;
    }

    public void setBlockSchemeJSON(String blockSchemeJSON) {
        this.blockSchemeJSON = blockSchemeJSON;
    }

    public String getBlockCodeJS() {
        return blockCodeJS;
    }

    public void setBlockCodeJS(String blockCodeJS) {
        this.blockCodeJS = blockCodeJS;
    }

    public String getByteArrayInterface() {
        return byteArrayInterface;
    }

    public void setByteArrayInterface(String byteArrayInterface) {
        this.byteArrayInterface = byteArrayInterface;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
