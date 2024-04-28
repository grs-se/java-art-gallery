package com.artgallery.artgallery02.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.artgallery.artgallery02.models.Artwork;
import com.artgallery.artgallery02.services.ArtworkService;


@RestController
public class ArtworkController {

  @Autowired
  private ArtworkService artworkService;

  /**
   * @return
   */
  // TODO: query param, route param
  @RequestMapping(value = "/artworks")
  public ArrayList<Artwork> getArtworks() {
    return artworkService.getArtworks();
      // ArtworkRepository repo = new ArtworkRepository();
      // return new ResponseEntity<>(repo.getArtworks(), HttpStatus.OK);
  }
  
  @RequestMapping(value = "createartwork", method = RequestMethod.POST)
  public String createStudent(@RequestBody Artwork artwork){
      return artworkService.createArtwork(artwork);
  }
}
