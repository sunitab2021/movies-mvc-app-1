package com.rab3tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rab3tech.controller.dto.MovieDTO;
import com.rab3tech.service.IMoviesService;

@Controller

//page, request ,session, application
//What is default scope of spring bean ??? singleton
//Scopes -  7 scopes 
//singleton , prototype ,request ,application , session, global-session, websocket
@Scope("singleton")
public class MoviesController {
	
	
	@Autowired
	private IMoviesService iMoviesService;
	
	
	@PostMapping("/updateMovie")
	public String editMovieAction(@ModelAttribute MovieDTO movieDTO,Model model) {
		iMoviesService.updateByMid(movieDTO);
		return "redirect:/movies";
		/*
		 * List<MovieDTO> movieDTOs=moviesService.findAll(); //Adding my list into
		 * request scope so that we can access the same on my JSP page
		 * model.addAttribute("movieDTOs", movieDTOs); return "smovies";
		 */   //  ->> /WEB-INF/pages/smovies.jsp
	}
	

	@GetMapping("/editMovie")
	public String editMovieAction(@RequestParam int mid,Model model) {
		MovieDTO movieDTO=iMoviesService.findByMid(mid);
		///String year=movieDTO.getYear().substring(0, 4);
		//movieDTO.setYear(year);
		model.addAttribute("movieDTO", movieDTO);
		return "editMovie";   
	}
	
	@GetMapping("/deleteMovie")
	public String deleteMovieAction(@RequestParam int paa,Model model) {
		iMoviesService.deleteByMid(paa);
		return "redirect:/movies";
		/*
		 * List<MovieDTO> movieDTOs=moviesService.findAll(); //Adding my list into
		 * request scope so that we can access the same on my JSP page
		 * model.addAttribute("movieDTOs", movieDTOs); return "smovies";
		 */   //  ->> /WEB-INF/pagessmovies.jsp
	}
	
	@GetMapping("/movies")
	public String showAllMovies(Model model) {
		List<MovieDTO> movieDTOs=iMoviesService.findAll();
		//Adding my list into request scope so that we can access the same on my JSP page
		model.addAttribute("movieDTOs", movieDTOs);
		return "smovies";   //  ->> /WEB-INF/pagessmovies.jsp
	}

	
	
	@GetMapping("/addMovie")
	public String addMoviePage() {
		return "addMovie";   //  ->> /WEB-INF/pages/addMovie.jsp
	}
	
	
	//@ModelAttribute - >> it reads all the form data and populates into Plain Old Java object ->> POJO
	
	@PostMapping("/addMovie")
	public String uploadMovie(@ModelAttribute MovieDTO movieDTO, Model model) {
		System.out.println(movieDTO);
		iMoviesService.save(movieDTO);
		model.addAttribute("message","Hey! movie is uploaded successfully!");
		return "addMovie";   // 
	}
	
	

}
