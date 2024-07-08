package es.uah.filmAlvaritty.dao;

import es.uah.filmAlvaritty.model.Film;

import java.util.List;

public interface IFilmsDAO {

    List<Film> findAll();
    Film findFilmById(Integer idFilm);
    List<Film> findFilmsByTitle(String title);
    List<Film> findFilmsByGenre(String genre);
    void saveFilm(Film film);
    void deleteFilm(Integer idFilm);
    void updateFilm(Film film);

}
