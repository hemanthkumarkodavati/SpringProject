package com.example.springall.model;

import jakarta.persistence.Entity;

@Entity
public class Student extends Person implements Displayable, Identifiable {
  private String course;

  public String getCourse() { return course; }
  public void setCourse(String course) { this.course = course; }

  @Override
  public String display() {
    return "Student: " + getName() + " (" + course + ")";
  }

  @Override
  public Long getId() {
    return super.getId();
  }
}