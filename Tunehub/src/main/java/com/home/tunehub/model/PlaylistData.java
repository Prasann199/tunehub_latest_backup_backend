package com.home.tunehub.model;

import java.util.List;

import com.home.tunehub.entity.Song;

public class PlaylistData {

	int id;
	String name;
	List <Song> songs;
	
	
	public PlaylistData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PlaylistData(int id, String name, List<Song> songs) {
		super();
		this.id = id;
		this.name = name;
		this.songs = songs;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Song> getSongs() {
		return songs;
	}
	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
	@Override
	public String toString() {
		return "PlaylistData [id=" + id + ", name=" + name + ", songs=" + songs + "]";
	}
	
	
}
