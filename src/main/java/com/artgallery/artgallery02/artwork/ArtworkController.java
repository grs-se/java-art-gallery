package com.artgallery.artgallery02.artwork;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ArtworkController {
  /**
   * @return
   */
  // TODO: query param, route param
  @RequestMapping(value = "/artworks")
  public ResponseEntity<ArrayList<Artwork>> getArtworks() {
      ArtworkRepository repo = new ArtworkRepository();
      return new ResponseEntity<>(repo.getArtworks(), HttpStatus.OK);
  }
}
