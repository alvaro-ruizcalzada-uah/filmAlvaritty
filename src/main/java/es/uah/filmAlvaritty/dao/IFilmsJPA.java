package es.uah.filmAlvaritty.dao;

import es.uah.filmAlvaritty.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFilmsJPA extends JpaRepository<Film, Integer> {
    List<Film> findByTitleContainingIgnoreCase(String title);
    List<Film> findByGenreContainingIgnoreCase(String genre);
    List<Film> findByCast_NameContaining(String actor);
}