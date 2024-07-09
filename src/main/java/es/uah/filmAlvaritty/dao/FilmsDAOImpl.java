package es.uah.filmAlvaritty.dao;

import es.uah.filmAlvaritty.model.Film;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Repository
public class FilmsDAOImpl implements IFilmsDAO{

    private IFilmsJPA filmsJPA;

    @Override
    public List<Film> findAll() {
        return filmsJPA.findAll();
    }

    @Override
    public Film findFilmById(Integer idFilm) {
        Optional<Film> optional = filmsJPA.findById(idFilm);
        return optional.orElse(null);
    }

    @Override
    public List<Film> findFilmsByTitle(String title) {
        return filmsJPA.findByTitleContainingIgnoreCase(title);
    }

    @Override
    public List<Film> findFilmsByGenre(String genre) {
        return filmsJPA.findByGenreContainingIgnoreCase(genre);
    }

    @Override
    public List<Film> findFilmsByCast(String actor)  { return filmsJPA.findByCast_NameContaining(actor); }

    @Override
    public void saveFilm(Film film) {
        filmsJPA.save(film);
    }

    @Override
    public void deleteFilm(Integer idFilm) {
        filmsJPA.deleteById(idFilm);
    }

    @Override
    public void updateFilm(Film film) {
        filmsJPA.save(film);
    }
}
