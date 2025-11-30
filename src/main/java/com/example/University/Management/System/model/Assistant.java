package com.example.University.Management.System.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "assistants")
public class Assistant extends Staff {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull(message = "Role must be chosen (LAB / TA / GRADER)")
    private AssistantRole role;

    public Assistant() {}

    public Assistant(String id, String name, String phoneNumber, AssistantRole role) {
        super(id, name, phoneNumber);
        this.role = role;
    }

    public AssistantRole getRole() { return role; }
    public void setRole(AssistantRole role) { this.role = role; }
}
