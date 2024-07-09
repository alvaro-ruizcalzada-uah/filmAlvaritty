package es.uah.filmAlvaritty.dao;


import es.uah.filmAlvaritty.model.Actor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Repository
public class ActorsDAOImpl implements IActorsDAO {

    private IActorsJPA actorsJPA;

    @Override
    public List<Actor> findAll() {
        return actorsJPA.findAll();
    }

    @Override
    public Actor findActorById(Integer idActor) {
        Optional<Actor> optional = actorsJPA.findById(idActor);
        return optional.orElse(null);
    }

    @Override
    public List<Actor> findActorsByName(String name) {
        return actorsJPA.findByNameContainingIgnoreCase(name);
    }

    @Override
    public void saveActor(Actor actor) {
        actorsJPA.save(actor);
    }

    @Override
    public void deleteActor(Integer idActor) {
        actorsJPA.deleteById(idActor);
    }

    @Override
    public void updateActor(Actor actor) {
        actorsJPA.save(actor);
    }

}
