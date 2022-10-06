package com.jingwenli.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jingwenli.lookify.models.Song;
import com.jingwenli.lookify.services.SongService;

@Controller
public class HomeController {
	
	@Autowired
	private SongService songService;
	
//	Home
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
//	Dashboard
//	FIND ALL
	@GetMapping("/dashboard") 
	public String dashboard(Model model) {
		List<Song> allSongs = songService.AllSongs();
		model.addAttribute("songList", allSongs);
		return "dashboard.jsp";
	}
	
//	FIND ONE
	@GetMapping("/songs/{id}")
	public String oneSong(@PathVariable("id") Long id, Model model) {
		Song foundSong = songService.oneSong(id);
		model.addAttribute("song", foundSong);
		return "details.jsp";
	}

//	CREATE
//	show the form
	@GetMapping("/songs/new")
	public String addSong(Model model) {
		Song emptySong = new Song();
		model.addAttribute("newSong", emptySong);
		return "new.jsp";
	}
	
	@PostMapping("/songs/new")
	public String createSong(
			@Valid @ModelAttribute("newSong") Song song, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "new.jsp";
		} else {
			songService.createSong(song);
			return "redirect:/dashboard";
		}
	}

//	DELETE
	@DeleteMapping("/songs/delete/{id}")
	public String processDelete(@PathVariable("id") Long id) {
		songService.deleteSong(id);
		return "redirect:/dashboard";
	}
	
//	SEARCH
	@GetMapping("/search")
	public String search(Model model, @RequestParam(value="keyword") String keyword) {
		List<Song> filteredSong = songService.AllSongsInSearchResult(keyword);
		model.addAttribute("songList", filteredSong);
		model.addAttribute("keyword", keyword);
		return "search.jsp";
	}
	
//	Top 10
	@GetMapping("/top10")
	public String getTop10(Model model) {
		List<Song> filteredSong = songService.Top10Songs();
		model.addAttribute("songList", filteredSong);
		return "topTen.jsp";
	}
	
	
	
	
}
