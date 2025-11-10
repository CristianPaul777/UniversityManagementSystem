package com.example.University.Management.System.model;

public class Assistant extends BaseEntity {

    private String id;
    private String name;
    private String phoneNumber;
    private String role;

    public Assistant() {}

    public Assistant(String id, String name, String phoneNumber, String role) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    @Override
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
