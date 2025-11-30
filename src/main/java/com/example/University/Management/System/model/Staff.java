package com.example.University.Management.System.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@MappedSuperclass
public abstract class Staff extends BaseEntity {

    @Id
    @Column(length = 50)
    @NotBlank(message = "ID must not be empty")
    private String id;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "Name must not be empty")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @Column(nullable = false, length = 20)
    @NotBlank(message = "Phone number must not be empty")
    @Pattern(
            regexp = "^[0-9+ ]{7,20}$",
            message = "Phone number must contain only digits, + and spaces, length 7–20"
    )
    private String phoneNumber;

    protected Staff() {}

    public Staff(String id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}
