package com.nehouse.nehouse.Model;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String name;
    private String id;
    private List<String> listUID;
    private int count = 0;

    public Group() { }

    public Group(String _name, String _id, ArrayList<String> _list, int _count) {
        name = name;
        count =  _count;
        id = _id;
        listUID = _list;
    }
}
