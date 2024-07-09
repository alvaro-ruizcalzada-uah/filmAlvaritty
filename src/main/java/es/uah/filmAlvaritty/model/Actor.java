package es.uah.filmAlvaritty.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="Actors", schema="filmsalvarittydb")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idActor")
    private Integer idActor;

    @Column(name = "name")
    private String name;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "country")
    private String country;

    @ManyToMany
    @JoinTable(name = "Films_has_Actors", joinColumns = {
            @JoinColumn(name = "Actors_idActor", referencedColumnName = "idActor")}, inverseJoinColumns = {
            @JoinColumn(name = "Films_id", referencedColumnName = "id")})
    @JsonIgnoreProperties("cast")
    private List<Film> filmography;

    public void addFilm(Film film) {
        if (film != null) {
            getFilmography().add(film);
            film.addActor(this);
        }
    }

    public void removeFilm(Film film) {
        if (film != null) {
            film.removeActor(this);
            getFilmography().remove(film);
        }
    }

}