package com.home.tunehub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.home.tunehub.entity.Song;
import com.home.tunehub.model.SongData;
@Repository
public interface SongRepository extends JpaRepository<Song, Integer>{

	void save(SongData song);
	
	@Query("SELECT DISTINCT s.artist FROM Song s")
	List<String> findArtists();
	
	List<Song> findByArtist(String artist);

}
