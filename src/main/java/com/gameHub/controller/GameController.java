package com.gameHub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.gameHub.domain.Game;
import com.gameHub.service.GameService;

@Controller
public class GameController {
	
	@Autowired
	GameService gameService;
	
	@GetMapping("/game/search")
	public String searchGames(@ModelAttribute("game") Game searchGameDTO, Model model) {
		List<Game> gamesBySearch = gameService.searchGames(searchGameDTO);
		model.addAttribute("games", gamesBySearch);
		return "games";
	}
	
	@GetMapping("/game/all")
	public String searchGames(Model model) {
		List<Game> allGames = gameService.getAllGames();
		model.addAttribute("games", allGames);
		return "games";
	}
	
	@GetMapping("/game/{gameNo}")
	public String getGameByNo(@PathVariable("gameNo") int gameNo, Model model) {
		Game gameByNo = gameService.getGameByNo(gameNo);
		model.addAttribute("gameByNo", gameByNo);
		return "game";
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
