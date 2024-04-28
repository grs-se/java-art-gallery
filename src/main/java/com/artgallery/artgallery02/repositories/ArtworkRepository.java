package com.artgallery.artgallery02.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.artgallery.artgallery02.models.Artwork;

// @Repository
public interface ArtworkRepository extends JpaRepository<Artwork, Long> {

  // public List<Artwork> getAll();

  public List<Artwork> findByPublished(boolean published);

  public List<Artwork> findByTitleContaining(String title);

  public Artwork findByTitle(String title);

  public boolean existsByTitle(String title);

  @Query("select max(s.id) from Artwork s")
  public Integer findMaxId();

  // public Optional<Artwork> findById(Long id);

  // public void deleteById(Long id);
}

// @Repository
// public class ArtworkRepository {
// public ArrayList<Artwork> getArtworks() {
// return this.artworks;
// }
// }

// @Repository
// public class ArtworkRepository {
// public List<Artwork> getArtworks() {
// return this.artworks;
// }

// public Artwork getByTitle(String title);

// public boolean existsByTitle(String title);

// @Query("select max(s.id) from Artwork s")
// public Integer findMaxId();

// public Optional<Artwork> findById(Long id);

// public void deleteById(Long id);
// }
