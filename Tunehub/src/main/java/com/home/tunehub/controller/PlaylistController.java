package com.home.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.home.tunehub.entity.Playlist;
import com.home.tunehub.model.PlaylistData;
import com.home.tunehub.service.PlaylistService;

import jakarta.servlet.http.HttpSession;

@RestController
//@RequestMapping("*")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @PostMapping("/addplaylist")
    public String createPlaylist(@RequestBody PlaylistData playlistData, HttpSession session) {
        String userEmail = (String) session.getAttribute("email");
        if (userEmail == null) {
            return "User not logged in";
        }
        playlistService.addPlaylist(playlistData, userEmail);
        return "Playlist created successfully";
    }
 
    @GetMapping("/views/{name}")
    public Playlist viewPlaylist(@PathVariable("name") String name) {
        return playlistService.getPlaylistSongs(name);
    }

    @GetMapping("/getplaylists")
    public List<Playlist> getAllPlaylists(HttpSession session) {
        String userEmail = (String) session.getAttribute("email");
        if (userEmail == null) {
            return null;
        }
        return playlistService.viewPlaylist(userEmail);
    }

    @DeleteMapping("/deleteplaylist/{id}")
    public String deletePlaylist(@PathVariable("id") int id) {
        playlistService.deletePlaylist(id);
        return "Playlist deleted successfully";
    }
}
