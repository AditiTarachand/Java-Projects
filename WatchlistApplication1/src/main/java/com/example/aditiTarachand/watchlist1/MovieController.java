package com.example.aditiTarachand.watchlist1;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import jakarta.validation.Valid;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class MovieController {
	
	@Autowired
	DatabaseService databaseService;
	
	@GetMapping("/watchlistItemForm")
	public ModelAndView showWatchListForm(@RequestParam(required = false)  Integer id) {
		
		String viewName= "watchlistItemForm";
		Map<String , Object> model =  new HashMap<>();
		
        if (id == null ) {
	
	   model.put("watchlistItem",new Movie());
	
	
     }
        else {
			model.put("watchlistItem", databaseService.getMovieById(id));
		}
		
		//		Movie dummyMovie= new Movie();
//		dummyMovie.setTitle("dummy");
//		dummyMovie.setRating(0);
//		dummyMovie.setPriority("Low");
//		dummyMovie.setComment("john doe");
//		
//		model.put("watchlistItem", dummyMovie);
		
		
		return new ModelAndView(viewName, model);
		}
	
	
	@PostMapping("/watchlistItemForm")
	// same url me post karre ho ilkiye post mapping me bhi smae honga
	public ModelAndView submitWatchlistForm( @Valid   @ModelAttribute("watchlistItem") Movie movie, BindingResult bindingResult) {
		//TODO: process POST request
		
	if (bindingResult.hasErrors()) {
		//if errors are their re display form, and let user enter again
		return new ModelAndView("watchlistItemForm");
		
	}
		Integer id = movie.getId();
		
		if (id == null) {
			databaseService.create(movie);
			
		}
		
		else {
			databaseService.update(movie, id);
		}
	
		RedirectView rd=new RedirectView();    //Redirecting concept
		rd.setUrl("/watchlist"); 
		
		
		return new ModelAndView(rd);
	}
	
	
	@GetMapping("/watchlist")	
	public ModelAndView getWatchlist() {
		// TODO Auto-generated method stub
		
		String viewName = "watchlist";
		Map<String, Object> model = new HashMap<>();		

		List<Movie> movieList= databaseService.getAllMovies();
		model.put("watchlistrows", movieList);
	    
		model.put("noofmovies", movieList.size() ); 
		return new ModelAndView(viewName, model);
	
	}
	
	 
	
	
	
	
	
	

}
