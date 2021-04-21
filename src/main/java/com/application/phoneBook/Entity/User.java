package com.application.phoneBook.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class User {
    private String id;
    private String name;

    private List<PhoneItem> phoneItemList;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        phoneItemList = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PhoneItem> getPhoneItemList() {
        return phoneItemList;
    }

    public void setPhoneItemList(List<PhoneItem> phoneItemList) {
        this.phoneItemList = phoneItemList;
    }
}
