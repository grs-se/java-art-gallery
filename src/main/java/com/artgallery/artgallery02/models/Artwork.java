package com.artgallery.artgallery02.models;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "artworks")
public class Artwork {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "title")
  private String title;

  @Column(name = "medium")
  private String medium;

  @Column(name = "category")
  private String category;

  @Column(name = "description")
  private String description;

  @Column(name = "published")
  private boolean published;

  public Artwork() {
  }

  public Artwork(String title, String medium, String category) {
    this.title = title;
    this.medium = medium;
    this.category = category;
  }

  public Artwork(String title, String medium, String category, String description, boolean published) {
    this.title = title;
    this.medium = medium;
    this.category = category;
    this.description = description;
    this.published = published;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getMedium() {
    return this.medium;
  }

  public void setMedium(String medium) {
    this.medium = medium;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isPublished() {
    return published;
  }

  public void setPublished(boolean isPublished) {
    this.published = isPublished;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Artwork))
      return false;
    Artwork artwork = (Artwork) o;
    return Objects.equals(this.id, artwork.id) && Objects.equals(this.title, artwork.title)
        && Objects.equals(this.category, artwork.category);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.title, this.category);
  }

  @Override
  public String toString() {
    return "artwork{" + "id=" + this.id + ", title='" + this.title + '\'' + ", category='" + this.category + '\''
        + ", desc='" + this.description + '\'' + ", published='" + this.published + '}';
  }
}
