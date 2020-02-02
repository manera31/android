package com.joanmanera.gmaildos.models;

import java.util.ArrayList;

public class Account {
    private int id;
    private String name;
    private String firstSurname;
    private String email;
    private ArrayList<Contact> contacts;
    private ArrayList<Mail> mails;

    public Account(int id, String name, String firstSurname, String email) {
        this.id = id;
        this.name = name;
        this.firstSurname = firstSurname;
        this.email = email;
        this.contacts = new ArrayList<>();
        this.mails = new ArrayList<>();
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    public void setMails(ArrayList<Mail> mails) {
        this.mails = mails;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public ArrayList<Mail> getMails() {
        return mails;
    }
}
