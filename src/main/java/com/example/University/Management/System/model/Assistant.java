package com.example.University.Management.System.model;

import jakarta.persistence.*;

@Entity
@Table(name = "assistants")
public class Assistant extends Staff {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AssistantRole role;

    public Assistant() {}

    public Assistant(String id, String name, String phoneNumber, AssistantRole role) {
        super(id, name, phoneNumber);
        this.role = role;
    }

    public AssistantRole getRole() { return role; }
    public void setRole(AssistantRole role) { this.role = role; }
}


