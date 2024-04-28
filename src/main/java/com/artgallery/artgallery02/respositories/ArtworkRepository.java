package com.artgallery.artgallery02.respositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.artgallery.artgallery02.models.Artwork;

@Repository
public interface ArtworkRepository extends JpaRepository<Artwork, Integer> {
  public ArrayList<Artwork> getArtworks();

  public Artwork getByTitle(String title);

  public boolean existsByTitle(String title);

  @Query("select max(s.id) from Artwork s")
  public Integer findMaxId();
}

// @Repository
// public class ArtworkRepository implements IArtworkRepository {
//   private ArrayList<Artwork> artworks;
  
//   public ArtworkRepository()
//   {
//     this.artworks = new ArrayList<Artwork>();
//     this.artworks.add(new Artwork("Mona Lisa"));
//   }
//   public ArrayList<Artwork> getArtworks()
//   {
//     return this.artworks;
//   }
// }
