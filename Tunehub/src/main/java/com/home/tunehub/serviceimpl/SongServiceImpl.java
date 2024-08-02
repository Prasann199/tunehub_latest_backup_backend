package com.home.tunehub.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.tunehub.entity.Song;
import com.home.tunehub.model.SongData;
import com.home.tunehub.repository.SongRepository;
import com.home.tunehub.service.SongService;
@Service
public class SongServiceImpl implements SongService{
	
	@Autowired
	SongRepository songRepository;

	@Override
	public void addSong(SongData song) {
		Song sng=new Song();
		sng.setName(song.getName());
		sng.setArtist(song.getArtist());
		sng.setGenre(song.getGenre());
		sng.setAudioUrl(song.getAudioUrl());
		sng.setImgUrl(song.getImgUrl());
		songRepository.save(sng);
		
	}

	@Override
	public List<Song> viewSong() {
		return songRepository.findAll();
	}

	@Override
	public List<String> getArtists() {
		List<String> artists=songRepository.findArtists();
		return artists;
	}

	@Override
	public List<Song> getSongByArtist(String artist) {
		 List<Song> songs = songRepository.findByArtist(artist);
//		    System.out.println("Songs found: " + songs);
		return songs;
	}

	
	

}
