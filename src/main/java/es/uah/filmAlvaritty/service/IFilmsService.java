package es.uah.filmAlvaritty.service;

import es.uah.filmAlvaritty.model.Film;

import java.util.List;

public interface IFilmsService {

    List<Film> findAll();
    Film findFilmById(Integer idFilm);
    List<Film> findFilmsByTitle(String title);
    List<Film> findFilmsByGenre(String genre);
    boolean saveFilm(Film film);
    boolean deleteFilm(Integer idFilm);
    void updateFilm(Film film);

}
