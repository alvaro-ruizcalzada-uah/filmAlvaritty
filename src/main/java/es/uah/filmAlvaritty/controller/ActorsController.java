package es.uah.filmAlvaritty.controller;

import es.uah.filmAlvaritty.model.Actor;
import es.uah.filmAlvaritty.service.IActorsService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class ActorsController {

    private IActorsService actorsService;

    @GetMapping("/actors")
    public List<Actor> findAll() {
        return actorsService.findAll();
    }

    @GetMapping("/actors/{id}")
    public Actor findActorById(@PathVariable("id") Integer idActor) {
        return actorsService.findActorById(idActor);
    }

    @GetMapping("/actors/name/{name}")
    public List<Actor> findActorsByTitle(@PathVariable("name") String name) {
        return actorsService.findActorsByName(name);
    }

    @PostMapping(value = "/actors", produces = MediaType.TEXT_PLAIN_VALUE)
    public String saveActor(@RequestBody Actor actor) {
        return String.valueOf(actorsService.saveActor(actor));
    }

    @PutMapping("/actors")
    public void updateActor(@RequestBody Actor actor) {
        actorsService.updateActor(actor);
    }

    @DeleteMapping(value = "/actors/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String deleteActor(@PathVariable("id") Integer idActor) {
        return String.valueOf(actorsService.deleteActor(idActor));
    }
}
