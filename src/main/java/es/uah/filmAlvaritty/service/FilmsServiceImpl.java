package es.uah.filmAlvaritty.service;

import es.uah.filmAlvaritty.dao.IFilmsDAO;
import es.uah.filmAlvaritty.model.Actor;
import es.uah.filmAlvaritty.model.Film;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class FilmsServiceImpl implements IFilmsService {

    private IFilmsDAO filmsDAO;

    @Override
    public List<Film> findAll() {
        return filmsDAO.findAll();
    }

    @Override
    public Film findFilmById(Integer idFilm) {
        return filmsDAO.findFilmById(idFilm);
    }

    @Override
    public List<Film> findFilmsByTitle(String title) {
        return filmsDAO.findFilmsByTitle(title);
    }

    @Override
    public List<Film> findFilmsByGenre(String genre) {
        return filmsDAO.findFilmsByGenre(genre);
    }

    @Override
    public List<Film> findFilmsByCast(String actor) {
        return filmsDAO.findFilmsByCast(actor);
    }

    @Override
    public boolean saveFilm(Film film) {
        if (filmsDAO.findFilmById(film.getId()) == null) {
            filmsDAO.saveFilm(film);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteFilm(Integer idFilm) {
        Film film = filmsDAO.findFilmById(idFilm);
        if (film.getId() != null) {
            for (Actor actor : film.getCast()) {
                actor.getFilmography().remove(film);
            }
            film.getCast().clear();
            filmsDAO.deleteFilm(idFilm);
            return true;
        }
        return false;
    }

    @Override
    public void updateFilm(Film film) {
        if (filmsDAO.findFilmById(film.getId()) != null) {
            filmsDAO.updateFilm(film);
        }
    }
}
