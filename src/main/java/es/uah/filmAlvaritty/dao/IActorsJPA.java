package es.uah.filmAlvaritty.dao;

import es.uah.filmAlvaritty.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IActorsJPA extends JpaRepository<Actor, Integer> {
    List<Actor> findByNameContainingIgnoreCase(String name);
}
