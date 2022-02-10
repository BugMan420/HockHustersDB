package com.example.tsi.izzy.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

	@PostMapping("/addFilmToActor")
	public @ResponseBody
	int addFilmToActor(@RequestParam int actor_id, int film_id){

		return actor_id;
	}





	@PostMapping("/addActors")
	public @ResponseBody
	String addActor(@RequestParam String first_name, String last_name){
		Actor addActor = new Actor(first_name,last_name);
		actorRepository.save(addActor);
		return save;
	}


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
