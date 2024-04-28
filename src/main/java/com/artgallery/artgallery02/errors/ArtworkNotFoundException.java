package com.artgallery.artgallery02.errors;

public class ArtworkNotFoundException extends RuntimeException {
  public ArtworkNotFoundException(Long id) {
    super("Could not find employee" + id);
  }
}
