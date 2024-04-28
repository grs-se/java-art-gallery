package com.artgallery.artgallery02.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.artgallery.artgallery02.errors.ArtworkNotFoundException;
import com.artgallery.artgallery02.models.Artwork;
import com.artgallery.artgallery02.repositories.ArtworkRepository;
import com.artgallery.artgallery02.services.IArtworkService;

@Service
public class ArtworkService implements IArtworkService {

  @Autowired
  private final ArtworkRepository artworkRepository;

  public ArtworkService(ArtworkRepository artworkRepository) {
    this.artworkRepository = artworkRepository;
  }

  public List<Artwork> getAllArtworks() {
    return artworkRepository.findAll();
    // return artworkRepository.findAll();
  }

  @Transactional
  public String createArtwork(Artwork artwork) {
    try {
      if (!artworkRepository.existsByTitle(artwork.getTitle())) {
        // artwork.setId(null == artworkRepository.findMaxId() ? 0 :
        // artworkRepository.findMaxId() + 1);
        artworkRepository.save(artwork);
        return "Artwork created successfully";
      } else {
        return "Artwork already exists in the database";
      }
    } catch (Exception e) {
      throw e;
    }
  }

  @Transactional
  public Artwork getById(@PathVariable Long id) {
    return artworkRepository.findById(id)
        .orElseThrow(() -> new ArtworkNotFoundException(id));
  }

  // public void deleteArtwork(@PathVariable Long id) {
  // artworkRepository.deleteById(id);
  // }
}
