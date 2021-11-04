package com.rab3tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rab3tech.controller.dto.ActorDTO;
import com.rab3tech.service.IActorsService;

@Controller
public class ActorController {
	
	@Autowired
	private IActorsService actorsService;
	
	@GetMapping("/addActor")
	public String showActorPage() {
		return "addActor";
	}
	
	@GetMapping("/actors")
	public String showActors(@RequestParam int mid ,Model model) {
		List<ActorDTO> actorDTOs=actorsService.findActors(mid);
		model.addAttribute("actorDTOs",actorDTOs);
		return "tactors";
	}
	
	
	
	
	@PostMapping("/addActor")
	public String postDate(@ModelAttribute ActorDTO actorDTO) {
		actorsService.save(actorDTO);
		return "redirect:/movies";
	}

}
