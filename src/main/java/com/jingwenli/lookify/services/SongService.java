package com.jingwenli.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jingwenli.lookify.models.Song;
import com.jingwenli.lookify.repositories.SongRepository;

@Service
public class SongService {

		@Autowired
		private SongRepository songRepo;
		
//		FIND ALL
		public List<Song> AllSongs() {
			return songRepo.findAll();
		}
		
//		CREATE
		public Song createSong(Song newSong) {
			return songRepo.save(newSong);
		}
		
//		FIND ONE
		public Song oneSong(Long id) {
			Optional<Song> optionalSong = songRepo.findById(id);
			if (optionalSong.isPresent()) {
				return optionalSong.get();
			} else {
				return null;
			}
		}

//		EDIT
		public Song editSong(Song updatedSong) {
			return songRepo.save(updatedSong);
		}
		
//		DELETE
		public void deleteSong(Long id) {
			songRepo.deleteById(id);
		}
		
//		SEARH
		public List<Song> AllSongsInSearchResult(String keyword) {
			return songRepo.findByArtistContaining(keyword);
		}
		
//		TOP 10
		public List<Song> Top10Songs() {
			return songRepo.findTop10ByOrderByRatingDesc();
		}
		
}
