package es.uah.filmAlvaritty.controller;

import es.uah.filmAlvaritty.model.Film;
import es.uah.filmAlvaritty.service.IFilmsService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class FilmsController {

    private IFilmsService filmsService;

    @GetMapping("/films")
    public List<Film> findAll() {
        return filmsService.findAll();
    }
    
    @GetMapping("/films/{id}")
    public Film findFilmById(@PathVariable("id") Integer idFilm) {
        return filmsService.findFilmById(idFilm);
    }
    
    @GetMapping("/films/title/{title}")
    public List<Film> findFilmsByTitle(@PathVariable("title") String title) {
        return filmsService.findFilmsByTitle(title);
    }
    
    @GetMapping("/films/genre/{genre}")
    public List<Film> findFilmsByGenre(@PathVariable("genre") String genre) {
        return filmsService.findFilmsByGenre(genre);
    }

    @GetMapping("/films/actor/{actor}")
    public List<Film> findFilmsByCast(@PathVariable("actor") String actor) {
        return filmsService.findFilmsByCast(actor);
    }
    
    @PostMapping(value = "/films", produces = MediaType.TEXT_PLAIN_VALUE)
    public String saveFilm(@RequestBody Film film) {
        return String.valueOf(filmsService.saveFilm(film));
    }
    
    @PutMapping("/films")
    public void updateFilm(@RequestBody Film film) {
        filmsService.updateFilm(film);
    }
    
    @DeleteMapping(value = "/films/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String deleteFilm(@PathVariable("id") Integer idFilm) {
        return String.valueOf(filmsService.deleteFilm(idFilm));
    }
}
