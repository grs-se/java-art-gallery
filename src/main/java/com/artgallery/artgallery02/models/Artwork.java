package com.artgallery.artgallery02.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Artwork {

  @Id
  private int id;
  
  private String title;

  public Artwork() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
