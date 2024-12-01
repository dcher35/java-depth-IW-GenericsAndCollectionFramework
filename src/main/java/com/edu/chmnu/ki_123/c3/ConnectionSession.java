package com.edu.chmnu.ki_123.c3;

import java.util.HashMap;
import java.util.Map;

public class ConnectionSession {
    private final Map<String, String> users = new HashMap<>();

    public boolean addUser(User user) {
        if (users.containsKey(user.getLogin())) {
            return false;
        }
        users.put(user.getLogin(), user.getPassword());
        return true;
    }

    public boolean removeUser(String login) {
        if (users.containsKey(login)) {
            users.remove(login);
            return true;
        }
        return false;
    }

    public boolean authenticate(String login, String password) {
        return users.containsKey(login) && users.get(login).equals(password);
    }

    public int getUserCount() {
        return users.size();
    }
}