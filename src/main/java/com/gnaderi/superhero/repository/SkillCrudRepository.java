package com.gnaderi.superhero.repository;

import com.gnaderi.superhero.entity.Skill;
import com.gnaderi.superhero.entity.SuperheroPower;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Repository
public interface SkillCrudRepository extends CrudRepository<Skill, Long> {

    @Query(value = "SELECT s.* FROM SUPERHERO_POWER sp JOIN Skill s ON sp.SKILL_ID = s.id WHERE sp.SUPERHERO_ID =:superhero", nativeQuery = true)
//    @Query("select s FROM Skill s JOIN SuperheroPower sp ON sp.skillBySkillId.id = s.id WHERE sp.superheroBySuperheroId.id =?1",)
    List<Skill> findPowers(@Param("superhero") Long superhero);

}

