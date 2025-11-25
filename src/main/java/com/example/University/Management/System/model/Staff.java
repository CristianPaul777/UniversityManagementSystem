package com.example.University.Management.System.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "staff")
public abstract class Staff extends BaseEntity {

    @Id
    @Column(length = 50)
    protected String id;

    @Column(nullable = false)
    protected String name;

    @Column(nullable = false)
    protected String phoneNumber;

    public Staff() {}

    public Staff(String id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}



