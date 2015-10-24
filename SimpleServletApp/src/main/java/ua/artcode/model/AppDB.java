package ua.artcode.model;

import ua.artcode.model.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppDB {


    private static int count = 0;
    private Map<Integer,User> map = new HashMap<>();

    public synchronized void addUser(User user){
        user.setId(count);
        map.put(count, user);
        count++;
    }

    public User getById(int id){
        return map.get(id);
    }

    public Collection<User> userList(){
        return map.values();
    }

    public Map<Integer, User> getMap() {
        return map;
    }

    public void setMap(Map<Integer, User> map) {
        this.map = map;
    }
}
