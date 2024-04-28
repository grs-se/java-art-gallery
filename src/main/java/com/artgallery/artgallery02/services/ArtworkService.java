package com.artgallery.artgallery02.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artgallery.artgallery02.models.Artwork;
import com.artgallery.artgallery02.respositories.ArtworkRepository;

@Service
public class ArtworkService {
  
  @Autowired
  private ArtworkRepository artworkRepository;

  public ArrayList<Artwork> getArtworks() {
    return artworkRepository.getArtworks();
  }

}
