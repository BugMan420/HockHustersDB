package com.example.tsi.izzy.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

	@GetMapping("/AllLanguages")
	public @ResponseBody
	Iterable<Language>getAllLanguages(){
		return languageRepository.findAll();
	}

	@PostMapping("/AddLanguages")
	Language createLanguage(@Validated @RequestBody Language newLanguage) {
		return languageRepository.save(newLanguage);
	}


	@GetMapping("/AllActors")
	public @ResponseBody
	Iterable<Actor>getAllActor(){
		return actorRepository.findAll();
	}

	@GetMapping("/AllFilms")
	public @ResponseBody
	Iterable<Film>getAllFilm(){
		return filmRepository.findAll();
	}

	@GetMapping("/AllCategories")
	public @ResponseBody
	Iterable<Category>getAllCategory(){
		return categoryRepository.findAll();
	}

	@PostMapping("/AddCategories")
	Category createCategory(@Validated @RequestBody Category newCategory) {
		return categoryRepository.save(newCategory);
	}

}
