package com.gnaderi.superhero.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SUPERHERO_ALLIANCE")
public class SuperheroAlliance {
    private Long id;
    @JsonProperty("superheroId")
    private Superhero superheroBySuperheroId;
    @JsonProperty("allyId")
    private Superhero superheroByAllyId;

    @Id
    @GeneratedValue
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SuperheroAlliance() {
    }

    public SuperheroAlliance(Superhero superheroBySuperheroId, Superhero superheroByAllyId) {
        this.superheroBySuperheroId = superheroBySuperheroId;
        this.superheroByAllyId = superheroByAllyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuperheroAlliance that = (SuperheroAlliance) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @ManyToOne
    @JoinColumn(name = "SUPERHERO_ID", referencedColumnName = "ID", nullable = false)
    public Superhero getSuperheroBySuperheroId() {
        return superheroBySuperheroId;
    }

    public void setSuperheroBySuperheroId(Superhero superheroBySuperheroId) {
        this.superheroBySuperheroId = superheroBySuperheroId;
    }

    @ManyToOne
    @JoinColumn(name = "ALLY_ID", referencedColumnName = "ID", nullable = false)
    public Superhero getSuperheroByAllyId() {
        return superheroByAllyId;
    }

    public void setSuperheroByAllyId(Superhero superheroByAllyId) {
        this.superheroByAllyId = superheroByAllyId;
    }
}
