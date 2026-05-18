package com.gameHub.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gameHub.domain.Game;

public class GameRowMapper implements RowMapper<Game> {
	
	private boolean isJoined;
	
	public GameRowMapper(boolean isJoined) {
		this.isJoined = isJoined;
	}

	@Override
	public Game mapRow(ResultSet rs, int rowNum) throws SQLException {
		Game game = new Game();
		game.setGameNo(rs.getInt("game_no"));
		game.setGameName(rs.getString("game_name"));
		game.setGenre(rs.getString("game_genre"));
		game.setGameAgeRating(rs.getInt("game_age_rating"));
		game.setGameDescription(rs.getString("game_description"));
		game.setGameDeveloper(rs.getString("game_developer"));
		game.setGamePublisher(rs.getString("game_publisher"));
		game.setGameReleaseDate(rs.getDate("game_release_date").toLocalDate());
		
		if (isJoined) {
			game.setSavedFileName(rs.getString("saved_name"));
		}
		
		return game;
	}

}
