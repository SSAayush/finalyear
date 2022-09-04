package com.example.nepaleats.models;

import java.util.List;

public class DataModel {
    private List<String>nestedList;
    private String itemText;
    private boolean isExpandable;

    public DataModel(List<String> nestedList, String itemText) {
        this.nestedList = nestedList;
        this.itemText = itemText;
        isExpandable = false;
    }

    public List<String> getnestedList() {
        return nestedList;
    }

    public String getItemText() {
        return itemText;
    }

    public boolean isExpandable() {
        return isExpandable;
    }

    public void setExpandable(boolean expandable) {
        isExpandable = expandable;
    }
}
