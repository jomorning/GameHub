package com.gameHub.service;

import java.time.LocalDate;
import java.util.List;

import com.gameHub.domain.Game;

public interface GameService {
	
	List<Game> searchGames(Game gameSearchDTO);

	List<Game> getAllGames();

	Game getGameByNo(int gameNo);

	List<Game> getGamesByGenre(String genre);

	List<Game> getGamesByDeveloper(String gameDeveloper);

	List<Game> getGamesByPublisher(String gamePublisher);

	List<Game> getGamesByReleaseDate(LocalDate startDate, LocalDate endDate);

	List<Game> getGamesByAgeRating(LocalDate userBirthDate);

	void setNewGame(Game newGame);

	void setEditGame(Game editGame);

	void setDeleteGame(int gameNo);

}
