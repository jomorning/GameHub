package com.gameHub.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gameHub.domain.Game;
import com.gameHub.exception.NoGameFoundException;
import com.gameHub.repository.GameRepository;
import com.gameHub.repository.UserRepository;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	GameRepository gameRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public int countAllGames() {
		int countAllGames = gameRepository.countAllGames();
		return countAllGames;
	}

	@Override
	public List<Game> searchGames(Game gameSearchDTO, int startNum, int limit) {
		List<Game> gamesBySearch = gameRepository.searchGames(gameSearchDTO, startNum, limit);
		return gamesBySearch;
	}

	@Override
	public List<Game> getAllGames() {
		List<Game> allGames = gameRepository.getAllGames();
		return allGames;
	}

	@Override
	public Game getGameByNo(int gameNo) {
		Game gameByNo = gameRepository.getGameByNo(gameNo);
		
		if (gameByNo == null) {
			throw new NoGameFoundException(gameNo);
		}
	
		return gameByNo;
	}

	@Override
	public List<Game> getGamesByGenre(String genre) {
		List<Game> gamesByGenre = gameRepository.getGamesByGenre(genre);
		return gamesByGenre;
	}

	@Override
	public List<Game> getGamesByDeveloper(String gameDeveloper) {
		List<Game> gamesByDeveloper = gameRepository.getGamesByDeveloper(gameDeveloper);
		return gamesByDeveloper;
	}

	@Override
	public List<Game> getGamesByPublisher(String gamePublisher) {
		List<Game> gamesByPublisher = gameRepository.getGamesByPublisher(gamePublisher);
		return gamesByPublisher;
	}

	@Override
	public List<Game> getGamesByReleaseDate(LocalDate startDate, LocalDate endDate) {
		List<Game> gamesByReleaseDate = gameRepository.getGamesByReleaseDate(startDate, endDate);
		return gamesByReleaseDate;
	}

	@Override
	public List<Game> getGamesByAgeRating(LocalDate userBirthDate) {
		int userAge = (LocalDate.now().getYear() - userBirthDate.getYear());
		List<Game> gamesByAgeRating = gameRepository.getGamesByAgeRating(userAge);
		return gamesByAgeRating;
	}

	@Override
	public void setNewGame(Game newGame) {
		gameRepository.setNewGame(newGame);
	}

	@Override
	public void setEditGame(Game editGame) {
		
		Game originGame = gameRepository.getGameByNo(editGame.getGameNo());
		
		if (editGame.getGameReleaseDate() == null) {
			editGame.setGameReleaseDate(originGame.getGameReleaseDate());
		}
		
		gameRepository.setEditGame(editGame);
	}

	@Override
	public void setDeleteGame(int gameNo) {
		gameRepository.setDeleteGame(gameNo);
	}

}
