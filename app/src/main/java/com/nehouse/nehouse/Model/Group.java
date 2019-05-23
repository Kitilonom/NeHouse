package com.nehouse.nehouse.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Group {
    private String name;
    private ArrayList<String> listUID;

    public Group() { }

    public Group(String _name, ArrayList<String> _list, int _count) {
        name = name;
        listUID = _list;
    }

    public void setName(String _name) {
        name = _name;
    }

    public String getName() {
        return name;
    }

    public void setFriends(String uid) {
        listUID.add(uid);
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> res = new HashMap<>();
        res.put("name", name);
        res.put("list", listUID);
        return res;
    }
}
