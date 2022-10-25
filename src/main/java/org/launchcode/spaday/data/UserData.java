package org.launchcode.spaday.data;

import org.launchcode.spaday.models.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class UserData {
    private HashMap<Integer, User> data;

    public UserData() {
        data = new HashMap<>();
    }

    public void add(User user) {
        data.put(user.getId(), user);
    }

    public Collection<User> getAll() {
        return data.values();
    }

    public User getById(int id) {
        return data.get(id);
    }
}
