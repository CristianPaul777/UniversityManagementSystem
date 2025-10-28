package com.example.University.Management.System.model;

public class Assistant extends Staff {
    private AssistantRole role;

    public Assistant() {
        super();
        this.role = AssistantRole.LAB;
    }

    public Assistant(String id, String name, String phoneNumber, AssistantRole role) {
        super(id, name, phoneNumber);
        this.role = role;
    }

    public AssistantRole getRole() { return role; }
    public void setRole(AssistantRole role) { this.role = role; }

    @Override
    public String toString() {
        return "Assistant{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", role=" + role +
                '}';
    }
}
