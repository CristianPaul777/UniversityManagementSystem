package com.example.University.Management.System.model;

public class Teacher extends Staff {
    private String title;
    private String departmentId;

    public Teacher() {
        super();
    }

    public Teacher(String id, String name, String phoneNumber, String title, String departmentId) {
        super(id, name, phoneNumber);
        this.title = title;
        this.departmentId = departmentId;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDepartmentId() { return departmentId; }
    public void setDepartmentId(String departmentId) { this.departmentId = departmentId; }

    @Override
    public String toString() {
        return "Teacher{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", title='" + title + '\'' +
                ", departmentId='" + departmentId + '\'' +
                '}';
    }
}
