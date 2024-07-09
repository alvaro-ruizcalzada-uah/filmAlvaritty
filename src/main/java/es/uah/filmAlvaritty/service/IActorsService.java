package es.uah.filmAlvaritty.service;

import es.uah.filmAlvaritty.model.Actor;

import java.util.List;

public interface IActorsService {

    List<Actor> findAll();
    Actor findActorById(Integer idActor);
    List<Actor> findActorsByName(String name);
    boolean saveActor(Actor actor);
    boolean deleteActor(Integer idActor);
    void updateActor(Actor actor);

}
