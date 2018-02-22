package com.gnaderi.superhero.repository;

import com.gnaderi.superhero.entity.Publisher;
import com.gnaderi.superhero.entity.SuperheroAlliance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public interface AllianceCrudRepository extends CrudRepository<SuperheroAlliance, Long> {

}

