package com.gnaderi.superhero.service;


import com.gnaderi.superhero.entity.Skill;
import com.gnaderi.superhero.entity.Superhero;
import com.gnaderi.superhero.entity.SuperheroAlliance;
import com.gnaderi.superhero.entity.SuperheroPower;
import com.gnaderi.superhero.inbound.CreateSuperheroRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public interface SuperheroService {
    @Transactional
    Superhero createSuperhero(String name, String pseudonym, Date firstAppearance, Long publisherId);

    @Transactional
    SuperheroAlliance createAllies(Superhero superhero, Superhero ally);

    @Transactional
    SuperheroPower createPowers(Superhero superhero, Skill skill);

    @Transactional
    boolean createSuperhero(CreateSuperheroRequest request);

    List<Superhero> findAll();

    List<Skill> findPowers(Superhero superhero);

    List<Superhero> findAllies(Superhero superhero);

    Superhero findByName(String superheroName);

    Superhero findById(Long heroId);

    void deleteAll();
}