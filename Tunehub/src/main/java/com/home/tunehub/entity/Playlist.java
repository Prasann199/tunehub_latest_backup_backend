package com.home.tunehub.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Playlist {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String name;
	@ManyToMany
	List <Song> songs;
	
	private String createdBy;

	public Playlist() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Playlist(int id, String name, List<Song> songs, String createdBy) {
		super();
		this.id = id;
		this.name = name;
		this.songs = songs;
		this.createdBy = createdBy;
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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public String toString() {
		return "Playlist [id=" + id + ", name=" + name + ", songs=" + songs + ", createdBy=" + createdBy + "]";
	} 
	
	
	
}
