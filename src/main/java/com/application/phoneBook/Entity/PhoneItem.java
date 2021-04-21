package com.application.phoneBook.Entity;

public class PhoneItem {
    private String id;
    private String contactName;
    private String number;

    public PhoneItem(String id, String contactName, String number) {
        this.id = id;
        this.contactName = contactName;
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
