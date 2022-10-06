package com.jingwenli.lookify.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jingwenli.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {

	List<Song> findAll();
	
	List<Song> findByArtistContaining(String keyword);
	
	List<Song> findAllByOrderByRating();
	
	List<Song> findAllByOrderByRatingDesc();
	
	List<Song> findTop10ByOrderByRatingDesc();
	
//	//custom query
//	@Query(value="SELECT * FROM SONGS", nativeQuery=true)
//	List<Song> whateverQueryName();
	
}
