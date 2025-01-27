package com.gabrieldm.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrieldm.dslist.dto.GameListDTO;
import com.gabrieldm.dslist.dto.GameMinDTO;
import com.gabrieldm.dslist.dto.ReplacementDTO;
import com.gabrieldm.dslist.services.GameListService;
import com.gabrieldm.dslist.services.GameService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
	
	@Autowired
	private GameListService service;
	
	@Autowired
	private GameService gameService;
	
	@GetMapping(value = "/{id}")
	public GameListDTO findById(@PathVariable Long id) {
		GameListDTO result = service.findById(id);
		return result;
	}
	
	@GetMapping
	public List<GameListDTO> findAll() {
		List<GameListDTO> result = service.findAll();
		return result;
	}
	
	@GetMapping(value = "/{listId}/games")
	public List<GameMinDTO> findByList(@PathVariable Long listId) {
		List<GameMinDTO> result = gameService.findByList(listId);
		return result;
	}
	
	@PostMapping(value = "/{listId}/replacement")
	public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
		service.move(listId, body.getSourceIndex(), body.getDestinationIndex());
	}
}
