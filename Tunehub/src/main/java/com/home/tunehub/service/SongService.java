package com.home.tunehub.service;

import java.util.List;

import com.home.tunehub.entity.Song;
import com.home.tunehub.model.SongData;

public interface SongService {

	public void addSong(SongData song) ;

	public List<Song> viewSong();

	public List<String> getArtists();

	public List<Song> getSongByArtist(String artist);

	

	

}
