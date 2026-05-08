package com.gameHub.repository;

import java.time.LocalDate;
import java.util.List;

import com.gameHub.domain.Game;

public class GameRepositoryImpl implements GameRepository {

	@Override
	public List<Game> getAllGames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Game> getGameByNo(int gameNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Game> getGamesByGenre(String genre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Game> getGamesByDeveloper(String gameDeveloper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Game> getGamesByPublisher(String gamePublisher) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Game> getGamesByReleaseDate(LocalDate startDate, LocalDate endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Game> getGamesByAgeRating(LocalDate userBirthDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNewGame(Game newGame) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEditGame(Game editGame) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDeleteGame(int gameNo) {
		// TODO Auto-generated method stub

	}

}
