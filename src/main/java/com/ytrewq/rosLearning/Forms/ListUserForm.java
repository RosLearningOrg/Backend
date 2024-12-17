package com.ytrewq.rosLearning.Forms;

import java.util.List;

public class ListUserForm {
    List<String> usernames;

    public ListUserForm(List<String> usernames) {
        this.usernames = usernames;
    }

    public List<String> getUsernames() {
        return usernames;
    }

    public void setUsernames(List<String> usernames) {
        this.usernames = usernames;
    }
}
