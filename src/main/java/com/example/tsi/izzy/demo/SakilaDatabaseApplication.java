package com.example.tsi.izzy.demo;


import com.amazonaws.services.secretsmanager.model.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins= "*")
@SpringBootApplication
@RestController
@RequestMapping("/homepage")
public class SakilaDatabaseApplication {

	@Autowired
	private LanguageRepository languageRepository;
	@Autowired
	private ActorRepository actorRepository;
	@Autowired
	private FilmRepository filmRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	private String save = "save";

	public SakilaDatabaseApplication(LanguageRepository languageRepository, ActorRepository actorRepository,
									 FilmRepository filmRepository,CategoryRepository categoryRepository){
		this.languageRepository=languageRepository;
		this.actorRepository=actorRepository;
		this.filmRepository=filmRepository;
		this.categoryRepository=categoryRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SakilaDatabaseApplication.class,args);
	}

	@GetMapping("/Languages")
	public @ResponseBody
	Iterable<Language>getAllLanguages(){
		return languageRepository.findAll();
	}

	@PostMapping("/addLanguages")
	public @ResponseBody
	String addLanguage(@RequestParam String name){
		Language addLanguage = new Language(name);
		languageRepository.save(addLanguage);
		return save;
	}

	@DeleteMapping ("/removeLanguages/{language_id}")
	public Map<String, Boolean> deleteLanguage (@PathVariable(value = "language_id") int language_id)
			throws ResourceNotFoundException {
		Language language = languageRepository.findById(language_id).orElseThrow(() ->new ResourceNotFoundException("Language not found"));
		languageRepository.delete(language);
		Map<String,Boolean> response = new HashMap<>();
		return response;
	}


	@GetMapping("/Actors")
	public @ResponseBody
	Iterable<Actor>getAllActor(){
		return actorRepository.findAll();
	}

	@GetMapping("/findActors/{actor_id}")
	public @ResponseBody
	Optional<Actor> getActorByID(@PathVariable int actor_id){

		return actorRepository.findById(actor_id);
	}


	@PostMapping("/addActors")
	public @ResponseBody
	String addActor(@RequestParam String first_name, String last_name){
		Actor addActor = new Actor(first_name,last_name);
		actorRepository.save(addActor);
		return save;
	}

	@PutMapping("/updateActor/{actor_id}")
	public @ResponseBody
	String updateActor(@PathVariable int actor_id, @RequestParam String first_name, String last_name){
		Actor updateActor = actorRepository.findById(actor_id).orElseThrow(() ->new ResourceNotFoundException("Actor id not found"));
		updateActor.setFirst_name(first_name);
		updateActor.setLast_name(last_name);
		final Actor updatedActor = actorRepository.save(updateActor);
		return updatedActor.getFirst_name() + updatedActor.getLast_name();
	}


//	@PutMapping("/updateActor/{actor_id}")
//	public @ResponseBody
//	String updateActor(@PathVariable int actor_id, @RequestParam Set <Film> film_id){
//		actorRepository.findById(actor_id).orElseThrow(() ->new ResourceNotFoundException("Actor id not found"));
//		Actor updateActor = new Actor();
//		updateActor.setActor_id(actor_id);
//		updateActor.setFirst_name(updateActor.getFirst_name());
//		updateActor.setLast_name(updateActor.getLast_name());
//		updateActor.setFilms(film_id);
//		final Actor updatedActor = actorRepository.save(updateActor);
//		return save;
//	}



	@GetMapping("/Films")
	public @ResponseBody
	Iterable<Film>getAllFilm(){
		return filmRepository.findAll();
	}

	@GetMapping("/Categories")
	public @ResponseBody
	Iterable<Category>getAllCategory(){
		return categoryRepository.findAll();
	}
}
