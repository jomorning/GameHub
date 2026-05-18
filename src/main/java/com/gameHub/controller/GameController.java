package com.gameHub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gameHub.domain.Game;
import com.gameHub.exception.GameAgeRatingException;
import com.gameHub.exception.NoGameFoundException;
import com.gameHub.service.GameService;

import jakarta.servlet.http.HttpSession;

@Controller
public class GameController {
	
	@Autowired
	GameService gameService;
	
	@GetMapping("/game/search")
	public String searchGames(@RequestParam(value="pageNum", defaultValue="1") int pageNum, @RequestParam(value="limit", defaultValue="5") int limit, @ModelAttribute("game") Game searchGameDTO, Model model) {
		
		int startNum = (limit * (pageNum - 1));
		int countAllGames = gameService.countAllGames();
		int totalPages = (countAllGames % limit) == 0 ? countAllGames / limit : (countAllGames / limit) + 1;
		List<Game> gamesBySearch = gameService.searchGames(searchGameDTO, startNum, limit);
		model.addAttribute("games", gamesBySearch);
		model.addAttribute("totalPages", totalPages);
		return "games";
	}
	
	@GetMapping("/game/{gameNo}")
	public String getGameByNo(@PathVariable("gameNo") int gameNo, Model model) {
		Game gameByNo = gameService.getGameByNo(gameNo);
		model.addAttribute("gameByNo", gameByNo);
		return "game";
	}
	
	@ExceptionHandler(value={(NoGameFoundException.class)})
	public String noGameFoundHandler(NoGameFoundException exception, Model model) {
		model.addAttribute("invalidGameNo", exception.getInvalidGameNo());
		return "noGameFoundException";
	}
	
	@ExceptionHandler(value={(GameAgeRatingException.class)})
	public String GameAgeRatingHandler(GameAgeRatingException exception, Model model) {
		model.addAttribute("gameName", exception.getGameName());
		model.addAttribute("gameAgeRating", exception.getGameAgeRating());
		return "gameAgeRatingException";
	}
	
	@GetMapping("/game/new")
	public String getNewGameForm(@ModelAttribute("newGame") Game newGame) {
		return "newGame";
	}
	
	@PostMapping("/game")
	public String submitNewGameForm(@ModelAttribute("newGame") Game newGame) {
		gameService.setNewGame(newGame);
		return "redirect:/game/search";
	}
	
	@GetMapping("/game/{gameNo}/edit")
	public String getEditGameForm(@PathVariable("gameNo") int gameNo, Model model) {
		Game gameByNo = gameService.getGameByNo(gameNo);
		model.addAttribute("editGame", gameByNo);
		return "editGame";
	}
	
	@PutMapping("/game/{gameNo}")
	public String submitEditGameForm(@ModelAttribute("editGame") Game editGame) {
		gameService.setEditGame(editGame);
		return "redirect:/game/" + editGame.getGameNo();
	}
	
	@DeleteMapping("/game/{gameNo}")
	public String submitDeleteGameForm(@PathVariable("gameNo") int gameNo) {
		gameService.setDeleteGame(gameNo);
		return "redirect:/game/search";
	}

}
