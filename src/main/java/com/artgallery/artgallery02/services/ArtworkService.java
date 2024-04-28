package com.artgallery.artgallery02.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artgallery.artgallery02.models.Artwork;
import com.artgallery.artgallery02.respositories.ArtworkRepository;

import jakarta.transaction.Transactional;

@Service
public class ArtworkService {
  
  @Autowired
  private ArtworkRepository artworkRepository;

  public ArrayList<Artwork> getArtworks() {
    return artworkRepository.getArtworks();
  }

  @Transactional
  public String createArtwork(Artwork artwork) {
    try {
      if (!artworkRepository.existsByTitle(artwork.getTitle())) {
        artwork.setId(null == artworkRepository.findMaxId()? 0 : artworkRepository.findMaxId() + 1);
        artworkRepository.save(artwork);
        return "Artwork created successfully";
      } else {
      return "Artwork already exists in the database";
      }
    } catch (Exception e) {
      throw e;
    }
  }



}
