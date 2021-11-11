package com.rab3tech.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rab3tech.controller.dto.ApplicationResponseDTO;
import com.rab3tech.controller.dto.MovieDTO;
import com.rab3tech.service.IMoviesService;


//because this is suppose to deal with raw data
@RestController
@RequestMapping("/v3")
public class MoviesRestController {
	
	@Autowired
	private IMoviesService iMoviesService;
	
	
	//Endpoint - /movies
	//METHOD =POST
	@PutMapping("/movies")
	public ApplicationResponseDTO updateMovies(@RequestBody MovieDTO movieDTO){
		 iMoviesService.save(movieDTO);
		 ApplicationResponseDTO applicationResponseDTO=new ApplicationResponseDTO();
		 applicationResponseDTO.setCode("1000");
		 applicationResponseDTO.setMessage("Hey! movie is created successfully!");
		 return applicationResponseDTO;
	}
	
	//Endpoint - /movies
	//METHOD =POST
	/**
	 * 
	 * @param movieDTO
	 * @return
	 *  @RequestBody - it takes raw data from the in coming request body
	 *  and populate into java object
	 */
	@PostMapping("/movies")
	public ApplicationResponseDTO uploadMovies(@RequestBody MovieDTO movieDTO){
		 iMoviesService.save(movieDTO);
		 ApplicationResponseDTO applicationResponseDTO=new ApplicationResponseDTO();
		 applicationResponseDTO.setCode("1000");
		 applicationResponseDTO.setMessage("Hey! movie is created successfully!");
		 return applicationResponseDTO;
		 
	}
	
	/**
	 * list of movies  - >> as json data
	 * @return
	 */
	@GetMapping("/movies")
	public List<MovieDTO> findMovies(){
		return iMoviesService.findAll();
	}
	
	
	//http://localhost:7777/v3/movies/9
	//@PathVariable - it is used to read data into rest api from URI
	//METHOD=DELETE
	
	//POSTMAN Tool or - >> CURL COMMAND
	@DeleteMapping("/movies/{mid}")
	public ApplicationResponseDTO deleteMovieByid(@PathVariable int mid){
		 iMoviesService.deleteByMid(mid);
		 ApplicationResponseDTO applicationResponseDTO=new ApplicationResponseDTO();
		 applicationResponseDTO.setCode("1000");
		 applicationResponseDTO.setMessage("Hey! movie is deleted successfully!");
		 return applicationResponseDTO;
	}
	
	
	/**
	 * movie data  - >> as per mid
	 * @return
	 */
	//http://localhost:7777/v3/movies/9
	//@PathVariable - it is used to read data into rest api from URI
	//METHOD=GET
	@GetMapping("/movies/{mid}")
	public MovieDTO findMovieByid(@PathVariable int mid){
		return iMoviesService.findByMid(mid);
	}

}
