package com.connectiva.email_system.model;

public class Lead {

    private String email;
    private String name;
    private String company;

    public Lead(String email, String name, String company) {
        this.email = email;
        this.name = name;
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }
}