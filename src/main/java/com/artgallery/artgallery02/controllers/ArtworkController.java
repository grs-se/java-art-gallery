package com.artgallery.artgallery02.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artgallery.artgallery02.models.Artwork;
import com.artgallery.artgallery02.services.impl.ArtworkService;

@RestController
@RequestMapping("/api")
public class ArtworkController {

  @Autowired
  private ArtworkService artworkService;

  /**
   * @return
   */
  // TODO: query param, route param
  @GetMapping(value = "/artworks")
  public List<Artwork> getArtworks() {
    return artworkService.getAllArtworks();
    // ArtworkRepository repo = new ArtworkRepository();
    // return new ResponseEntity<>(repo.getArtworks(), HttpStatus.OK);
  }

  @PostMapping(value = "createartwork")
  public String createArtwork(@RequestBody Artwork artwork) {
    return artworkService.createArtwork(artwork);
  }
}
