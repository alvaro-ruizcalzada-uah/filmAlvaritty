package es.uah.filmAlvaritty.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="Films", schema="filmsalvarittydb")
public class Film {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer idFilm;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "year")
    private Integer year;
    @Basic
    @Column(name = "running_time")
    private Integer runningTime;
    @Basic
    @Column(name = "country")
    private String country;
    @Basic
    @Column(name = "director")
    private String director;
    @Basic
    @Column(name = "genre")
    private String genre;
    @Basic
    @Column(name = "synopsis")
    private String synopsis;
    @Basic
    @Lob
    @Column(name = "poster")
    private byte[] poster;
    @ManyToMany(mappedBy = "filmography")
    @JsonIgnoreProperties("filmography")
    private List<Actor> cast;

    public Integer getId() {
        return idFilm;
    }

    public void setId(Integer idFilm) {
        this.idFilm = idFilm;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(Integer runningTime) {
        this.runningTime = runningTime;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public byte[] getPoster() {
        return poster;
    }

    public void setPoster(byte[] poster) {
        this.poster = poster;
    }

    public List<Actor> getCast() {
        return cast;
    }
    public void setCast(List<Actor> cast) {
        this.cast = cast;
    }
    public void addActor(Actor actor) {
        if (actor != null) {
            getCast().add(actor);
        }
    }
    public void removeActor(Actor actor) {
        if (actor != null) {
            getCast().remove(actor);
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(idFilm, film.idFilm) && Objects.equals(title, film.title) && Objects.equals(year, film.year) && Objects.equals(runningTime, film.runningTime) && Objects.equals(country, film.country) && Objects.equals(director, film.director) && Objects.equals(genre, film.genre) && Objects.equals(synopsis, film.synopsis) && Arrays.equals(poster, film.poster);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(idFilm, title, year, runningTime, country, director, genre, synopsis);
        result = 31 * result + Arrays.hashCode(poster);
        return result;
    }
}
