package es.uah.filmAlvaritty.dao;

import es.uah.filmAlvaritty.model.Actor;

import java.util.List;

public interface IActorsDAO {
    List<Actor> findAll();
    Actor findActorById(Integer idActor);
    List<Actor> findActorsByName(String name);
    void saveActor(Actor actor);
    void deleteActor(Integer idActor);
    void updateActor(Actor actor);
}
