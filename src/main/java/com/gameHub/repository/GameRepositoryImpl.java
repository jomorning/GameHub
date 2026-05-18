package com.gameHub.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gameHub.domain.Game;

@Repository
public class GameRepositoryImpl implements GameRepository {
	
	@Autowired
	JdbcTemplate template;

	void setJdbcTemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	@Override
	public int countAllGames() {
		String SQL = "SELECT COUNT(*) FROM game";
		int countAllGames = template.queryForObject(SQL, Integer.class);
		return countAllGames;
	}

	@Override
	public List<Game> searchGames(Game gameSearchDTO, int startNum, int limit) {
		StringBuilder SQL = new StringBuilder("SELECT * FROM game JOIN image ON game.game_no = image.reference_no WHERE 1=1");
		List<Object> params = new ArrayList<>();
		
		if (gameSearchDTO.getGameName() != null && !gameSearchDTO.getGameName().isEmpty()) {
			SQL.append(" AND game_name LIKE ? ");
			params.add(gameSearchDTO.getGameName() + "%");
		}
		
		if (gameSearchDTO.getGenre() != null && !gameSearchDTO.getGenre().isEmpty()) {
			SQL.append(" AND game_genre = ? ");
			params.add(gameSearchDTO.getGenre());
		}
		
		if (gameSearchDTO.getGameDeveloper() != null && !gameSearchDTO.getGameDeveloper().isEmpty()) {
			SQL.append(" AND game_developer LIKE ? ");
			params.add(gameSearchDTO.getGameDeveloper() + "%");
		}	
		
		if (gameSearchDTO.getGamePublisher() != null && !gameSearchDTO.getGamePublisher().isEmpty()) {
			SQL.append(" AND game_publisher LIKE ? ");
			params.add(gameSearchDTO.getGamePublisher() + "%");
		}
		
		SQL.append(" LIMIT ?, ?");
		params.add(startNum);
		params.add(limit);
		
		List<Game> gamesBySearch = template.query(SQL.toString(), new GameRowMapper(true), params.toArray());
		return gamesBySearch;
	}
	
	@Override
	public String getSavedFileName(int referenceNo) {
		String SQL = "SELECT saved_name FROM image WHERE reference_no = ?";
		String savedFileName = template.queryForObject(SQL, String.class, referenceNo);
		return savedFileName;
	}

	@Override
	public List<Game> getAllGames() {
		String SQL = "SELECT * FROM game";
		List<Game> allGames = template.query(SQL, new GameRowMapper(true));
		return allGames;
	}

	@Override
	public Game getGameByNo(int gameNo) {
		String SQL = "SELECT * FROM game JOIN image ON game.game_no = image.reference_no WHERE game.game_no = ?";
		List<Game> gameByNoTemp = template.query(SQL, new GameRowMapper(true), gameNo);
		
		if (gameByNoTemp.isEmpty()) {
			return null;
		}
		
		Game gameByNo = gameByNoTemp.get(0);
		return gameByNo;
	}

	@Override
	public Game getGameByName(String gameName) {
		String SQL = "SELECT * FROM game WHERE game_name = ?";
		List<Game> gameByNameTemp = template.query(SQL, new GameRowMapper(true), gameName);
		
		if (gameByNameTemp.isEmpty()) {
			return null;
		}
		
		Game gameByName = gameByNameTemp.get(0);
		return gameByName;
	}

	@Override
	public List<Game> getGamesByGenre(String genre) {
		String SQL = "SELECT * FROM game WHERE game_genre = ?";
		List<Game> gamesByGenre = template.query(SQL, new GameRowMapper(true), genre);
		return gamesByGenre;
	}

	@Override
	public List<Game> getGamesByDeveloper(String gameDeveloper) {
		String SQL = "SELECT * FROM game WHERE game_developer = ?";
		List<Game> gamesByDeveloper = template.query(SQL, new GameRowMapper(true), gameDeveloper);
		return gamesByDeveloper;
	}

	@Override
	public List<Game> getGamesByPublisher(String gamePublisher) {
		String SQL = "SELECT * FROM game WHERE game_publisher = ?";
		List<Game> gamesByPublisher = template.query(SQL, new GameRowMapper(true), gamePublisher);
		return gamesByPublisher;
		
	}

	@Override
	public List<Game> getGamesByReleaseDate(LocalDate startDate, LocalDate endDate) {
		String SQL = "SELECT * FROM game WHERE game_release_date BETWEEN ? AND ?";
		List<Game> gamesByReleaseDate = template.query(SQL, new GameRowMapper(true), startDate, endDate);	
		return gamesByReleaseDate;
	}

	@Override
	public List<Game> getGamesByAgeRating(int userAge) {
		String SQL = "SELECT * FROM game WHERE game_age_rating <= ?";
		List<Game> gamesByAgeRating = template.query(SQL, new GameRowMapper(true), userAge);
		return gamesByAgeRating;
	}

	@Override
	public void setNewGame(Game newGame) {
		String SQL = "INSERT INTO game(game_name, game_genre, game_age_rating, game_description, game_developer, game_publisher, game_release_date) VALUES(?,?,?,?,?,?,?)";
		template.update(SQL, newGame.getGameName(), newGame.getGenre(), newGame.getGameAgeRating(), newGame.getGameDescription(), newGame.getGameDeveloper(), newGame.getGamePublisher(), newGame.getGameReleaseDate());
		
		String SQLforReturnPK = "SELECT LAST_INSERT_ID()";
		Integer returnedUserNo = template.queryForObject(SQLforReturnPK, Integer.class);
		
		String SQL_i = "INSERT INTO image(reference_no, image_type, saved_name, file_path) VALUES(?,?,?,?)";
		template.update(SQL_i, returnedUserNo, "game", newGame.getSavedFileName(), "C:\\upload\\game\\" + newGame.getSavedFileName());
	}

	@Override
	public void setEditGame(Game editGame) {
		String SQL = "UPDATE game SET game_name = ?, game_genre = ?, game_age_rating = ?, game_description = ?, game_developer = ?, game_publisher = ?, game_release_date = ? WHERE game_no = ?";
		template.update(SQL, editGame.getGameName(), editGame.getGenre(), editGame.getGameAgeRating(), editGame.getGameDescription(), editGame.getGameDeveloper(), editGame.getGamePublisher(), editGame.getGameReleaseDate(), editGame.getGameNo());
		String SQL_u = "UPDATE image SET saved_name = ?, file_path = ? WHERE reference_no = ?";
		template.update(SQL_u, editGame.getSavedFileName(), "C:\\upload\\game\\" + editGame.getSavedFileName(), editGame.getGameNo());
	}

	@Override
	public void setDeleteGame(int gameNo) {
		String SQL = "DELETE FROM game WHERE game_no = ?";
		template.update(SQL, gameNo);
		String SQL_d = "DELETE FROM image WHERE reference_no = ?";
		template.update(SQL_d, gameNo);
	}

}
