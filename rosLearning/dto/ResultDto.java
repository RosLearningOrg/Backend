package com.ytrewq.rosLearning.dto;

import com.ytrewq.rosLearning.entities.User;

public class ResultDto {
    private String result;
    private User user;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

