package com.gnaderi.superhero.repository;

import com.gnaderi.superhero.entity.Skill;
import com.gnaderi.superhero.entity.Superhero;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Repository
public interface SuperheroCrudRepository extends CrudRepository<Superhero, Long> {
    @Query("select f from Superhero f where f.name = :heroName")
    Superhero findByName(@Param("heroName") String heroName);

    //    @Query("SELECT s FROM SuperheroAlliance sa JOIN  Superhero s ON sa.superheroByAllyId.id = s.id WHERE sa.superheroBySuperheroId.id =:superhero")
    @Query(value = "SELECT s.* FROM SUPERHERO_ALLIANCE sa LEFT JOIN  Superhero s ON sa.ALLY_ID = s.id WHERE sa.SUPERHERO_ID =:superhero", nativeQuery = true)
    List<Superhero> findAllies(@Param("superhero") Long superhero);

}

