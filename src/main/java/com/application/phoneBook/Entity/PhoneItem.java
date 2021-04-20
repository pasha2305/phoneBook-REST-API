package com.application.phoneBook.Entity;

public class PhoneItem {
    private Long id;
    private String contactName;
    private String number;

    public PhoneItem(Long id, String contactName, String number) {
        this.id = id;
        this.contactName = contactName;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
