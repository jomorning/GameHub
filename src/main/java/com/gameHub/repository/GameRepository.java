package com.gameHub.repository;

import java.time.LocalDate;
import java.util.List;

import com.gameHub.domain.Game;

public interface GameRepository {
	
	int countAllGames();
	
	List<Game> searchGames(Game gameSearchDTO, int startNum, int limit);
	
	String getSavedFileName(int referenceNo);
	
	List<Game> getAllGames();
	
	Game getGameByNo(int gameNo);
	
	Game getGameByName(String gameName);
	
	List<Game> getGamesByGenre(String genre);
	
	List<Game> getGamesByDeveloper(String gameDeveloper);
	
	List<Game> getGamesByPublisher(String gamePublisher);
	
	List<Game> getGamesByReleaseDate(LocalDate startDate, LocalDate endDate);
	
	List<Game> getGamesByAgeRating(int userAge);
	
	void setNewGame(Game newGame);
	
	void setEditGame(Game editGame);
	
	void setDeleteGame(int gameNo);
	
}
