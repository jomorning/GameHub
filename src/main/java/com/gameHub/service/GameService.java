package com.gameHub.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.gameHub.domain.Game;

public interface GameService {
	
	int countAllGames();
	
	List<Game> searchGames(Game gameSearchDTO, int startNum, int limit);

	List<Game> getAllGames();

	Game getGameByNo(int gameNo);

	List<Game> getGamesByGenre(String genre);

	List<Game> getGamesByDeveloper(String gameDeveloper);

	List<Game> getGamesByPublisher(String gamePublisher);

	List<Game> getGamesByReleaseDate(LocalDate startDate, LocalDate endDate);

	List<Game> getGamesByAgeRating(LocalDate userBirthDate);
	
	void saveImageFile(Game game, MultipartFile file);

	void setNewGame(Game newGame);

	void setEditGame(Game editGame);

	void setDeleteGame(int gameNo);

}
