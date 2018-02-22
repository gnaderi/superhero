package com.gnaderi.superhero.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SUPERHERO_POWER")
public class SuperheroPower {
    private Long id;
    @JsonProperty("superheroId")
    private Superhero superheroBySuperheroId;
    @JsonProperty("skillId")
    private Skill skillBySkillId;

    @Id
    @GeneratedValue
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SuperheroPower() {
    }

    public SuperheroPower(Superhero superheroBySuperheroId, Skill skillBySkillId) {
        this.superheroBySuperheroId = superheroBySuperheroId;
        this.skillBySkillId = skillBySkillId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuperheroPower that = (SuperheroPower) o;
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
    @JoinColumn(name = "SKILL_ID", referencedColumnName = "ID", nullable = false)
    public Skill getSkillBySkillId() {
        return skillBySkillId;
    }

    public void setSkillBySkillId(Skill skillBySkillId) {
        this.skillBySkillId = skillBySkillId;
    }
}
