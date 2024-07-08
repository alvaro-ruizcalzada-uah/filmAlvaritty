package es.uah.filmAlvaritty.service;

import es.uah.filmAlvaritty.dao.IFilmsDAO;
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
    public boolean saveFilm(Film film) {
        if (filmsDAO.findFilmById(film.getId()) != null) {
            filmsDAO.saveFilm(film);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteFilm(Integer idFilm) {
        if (filmsDAO.findFilmById(idFilm) != null) {
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
