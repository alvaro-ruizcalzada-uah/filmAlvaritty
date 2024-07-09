package es.uah.filmAlvaritty.service;

import es.uah.filmAlvaritty.dao.IActorsDAO;
import es.uah.filmAlvaritty.model.Actor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ActorsServiceImpl implements IActorsService {

    private IActorsDAO actorsDAO;

    @Override
    public List<Actor> findAll() {
        return actorsDAO.findAll();
    }

    @Override
    public Actor findActorById(Integer idActor) {
        return actorsDAO.findActorById(idActor);
    }

    @Override
    public List<Actor> findActorsByName(String name) {
        return actorsDAO.findActorsByName(name);
    }


    @Override
    public boolean saveActor(Actor actor) {
        if (actorsDAO.findActorById(actor.getIdActor()) == null) {
            actorsDAO.saveActor(actor);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteActor(Integer idActor) {
        if (actorsDAO.findActorById(idActor) != null) {
            actorsDAO.deleteActor(idActor);
            return true;
        }
        return false;
    }

    @Override
    public void updateActor(Actor actor) {
        if (actorsDAO.findActorById(actor.getIdActor()) != null) {
            actorsDAO.updateActor(actor);
        }
    }
}
