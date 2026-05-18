package com.gameHub.exception;

@SuppressWarnings("serial")
public class GameAgeRatingException extends RuntimeException {

	private String gameName;
	private int gameAgeRating;
	
	public GameAgeRatingException(String gameName, int gameAgeRating) {
		this.gameName = gameName;
		this.gameAgeRating = gameAgeRating;
	}

	public String getGameName() {
		return gameName;
	}

	public int getGameAgeRating() {
		return gameAgeRating;
	}

}
