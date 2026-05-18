package com.gameHub.domain;

import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

public class Game {
	
	private int gameNo;
	private String gameName;
	private String genre;
	private int gameAgeRating;
	private String gameDescription;
	private String gameDeveloper;
	private String gamePublisher;
	private LocalDate gameReleaseDate;
	
	private MultipartFile savedFile;
	private String savedFileName;
	
	public Game() {
	}

	public int getGameNo() {
		return gameNo;
	}

	public void setGameNo(int gameNo) {
		this.gameNo = gameNo;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getGameAgeRating() {
		return gameAgeRating;
	}

	public void setGameAgeRating(int gameAgeRating) {
		this.gameAgeRating = gameAgeRating;
	}

	public String getGameDescription() {
		return gameDescription;
	}

	public void setGameDescription(String gameDescription) {
		this.gameDescription = gameDescription;
	}

	public String getGameDeveloper() {
		return gameDeveloper;
	}

	public void setGameDeveloper(String gameDeveloper) {
		this.gameDeveloper = gameDeveloper;
	}

	public String getGamePublisher() {
		return gamePublisher;
	}

	public void setGamePublisher(String gamePublisher) {
		this.gamePublisher = gamePublisher;
	}

	public LocalDate getGameReleaseDate() {
		return gameReleaseDate;
	}

	public void setGameReleaseDate(LocalDate gameReleaseDate) {
		this.gameReleaseDate = gameReleaseDate;
	}

	public MultipartFile getSavedFile() {
		return savedFile;
	}

	public void setSavedFile(MultipartFile savedFile) {
		this.savedFile = savedFile;
	}

	public String getSavedFileName() {
		return savedFileName;
	}

	public void setSavedFileName(String savedFileName) {
		this.savedFileName = savedFileName;
	}

}
