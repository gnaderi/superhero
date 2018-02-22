package com.gnaderi.superhero.repository;

import com.gnaderi.superhero.entity.Skill;
import com.gnaderi.superhero.entity.Superhero;
import com.gnaderi.superhero.entity.SuperheroPower;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Repository
public interface PowerCrudRepository extends CrudRepository<SuperheroPower, Long> {

}

