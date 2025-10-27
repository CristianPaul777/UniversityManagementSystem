package com.example.University.Management.System.model;

public class Assistant extends Staff {
    private String role;

    public Assistant(String id, String name, String phoneNumber, String role) {
        super(id, name, phoneNumber);
        this.role = role;
    }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
