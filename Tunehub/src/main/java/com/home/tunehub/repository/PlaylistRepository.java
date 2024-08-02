package com.home.tunehub.repository;

import com.home.tunehub.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {
	
    Playlist findByName(String name);

    List<Playlist> findByCreatedBy(String createdBy);
}
