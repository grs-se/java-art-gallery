package com.artgallery.artgallery02.artwork;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

@Repository
public class ArtworkRepository {
  private ArrayList<Artwork> artworks;
  
  public ArtworkRepository()
  {
    this.artworks = new ArrayList<Artwork>();
    this.artworks.add(new Artwork("Mona Lisa"));
  }
  public ArrayList<Artwork> getArtworks()
  {
    return this.artworks;
  }
}
