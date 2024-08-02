package com.home.tunehub.service;

import com.home.tunehub.entity.Playlist;
import com.home.tunehub.model.PlaylistData;

import java.util.List;

public interface PlaylistService {

    Playlist getPlaylistSongs(String name);

    void addPlaylist(PlaylistData playlistData, String userEmail);

    List<Playlist> viewPlaylist(String userEmail);

    void deletePlaylist(int id);
}
