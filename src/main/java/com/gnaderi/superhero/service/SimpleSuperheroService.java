package com.gnaderi.superhero.service;

import com.gnaderi.superhero.entity.*;
import com.gnaderi.superhero.inbound.CreateSuperheroRequest;
import com.gnaderi.superhero.repository.*;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class SimpleSuperheroService implements SuperheroService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleSuperheroService.class);
    @Autowired
    private SuperheroCrudRepository shCrudRepository;
    @Autowired
    private PowerCrudRepository powerCrudRepository;
    @Autowired
    private SkillCrudRepository skillCrudRepository;
    @Autowired
    private PublisherCrudRepository publisherCrudRepository;
    @Autowired
    private AllianceCrudRepository allianceCrudRepository;

    @Transactional
    @Override
    public Superhero createSuperhero(String name, String pseudonym, Date firstAppearance, Long publisherId) {
        Publisher publisher = publisherCrudRepository.findOne(publisherId);
        Superhero superhero = new Superhero(name, pseudonym, firstAppearance, publisher);
        return shCrudRepository.save(superhero);
    }

    @Transactional
    @Override
    public SuperheroAlliance createAllies(Superhero superhero, Superhero ally) {
        SuperheroAlliance sa = new SuperheroAlliance(superhero, ally);
        return allianceCrudRepository.save(sa);
    }

    @Transactional
    @Override
    public SuperheroPower createPowers(Superhero superhero, Skill skill) {
        SuperheroPower power = new SuperheroPower(superhero, skill);
        return powerCrudRepository.save(power);
    }

    @Transactional
    @Override
    public Superhero createSuperhero(CreateSuperheroRequest req) {
        try {
            Superhero superhero = createSuperhero(req.getName(), req.getPseudonym(), req.getFirstAppearance(), req.getPublisher());
            if (superhero == null) {
                LOGGER.error("Unable to create superhero.");
                throw new RuntimeException("Unable to save the superhero!");
            }
            req.getSuperheroAllies().forEach(el -> {
                Superhero ally = shCrudRepository.findOne(el);
                SuperheroAlliance alliance = allianceCrudRepository.save(new SuperheroAlliance(superhero, ally));
                if (alliance == null) {
                    LOGGER.error("Unable to save superhero ally#{}",ally);
                    throw new RuntimeException("Unable to save superhero details.");
                }

            });
            req.getSuperheroSkills().forEach(el -> {
                Skill skill = skillCrudRepository.findOne(el);
                SuperheroPower superheroPower = powerCrudRepository.save(new SuperheroPower(superhero, skill));
                if (superheroPower == null) {
                    LOGGER.error("Unable to save superhero power#{}",skill);
                    throw new RuntimeException("Unable to save superhero details.");
                }

            });

            return superhero;

        } catch (Exception ex) {
            return null;
        }
    }


    @Override
    public List<Superhero> findAll() {
        Iterator<Superhero> iterator = shCrudRepository.findAll().iterator();
        return Lists.newArrayList(iterator);
    }

    @Override
    public List<Skill> findPowers(Superhero superhero) {
        return skillCrudRepository.findPowers(superhero.getId());
    }

    @Override
    public List<Superhero> findAllies(Superhero superhero) {
        return shCrudRepository.findAllies(superhero.getId());
    }

    @Override
    public Superhero findByName(String filename) {
        return shCrudRepository.findByName(filename);
    }

    @Override
    public Superhero findById(Long heroId) {
        return shCrudRepository.findOne(heroId);
    }

    @Transactional
    @Override
    public void deleteAll() {
        shCrudRepository.deleteAll();
    }
}