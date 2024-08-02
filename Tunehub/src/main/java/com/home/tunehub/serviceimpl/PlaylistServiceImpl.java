package com.home.tunehub.serviceimpl;

import com.home.tunehub.entity.Playlist;
import com.home.tunehub.model.PlaylistData;
import com.home.tunehub.repository.PlaylistRepository;
import com.home.tunehub.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    @Override
    public Playlist getPlaylistSongs(String name) {
        return playlistRepository.findByName(name);
    }

    @Override
    public void addPlaylist(PlaylistData playlistData, String userEmail) {
        Playlist playlist = new Playlist();
        playlist.setName(playlistData.getName());
        playlist.setSongs(playlistData.getSongs());
        playlist.setCreatedBy(userEmail);
        playlistRepository.save(playlist);
    }

    @Override
    public List<Playlist> viewPlaylist(String userEmail) {
        return playlistRepository.findByCreatedBy(userEmail);
    }

    @Override
    public void deletePlaylist(int id) {
        playlistRepository.deleteById(id);
    }
}
