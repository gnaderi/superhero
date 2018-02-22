package com.gnaderi.superhero.repository;

import com.gnaderi.superhero.entity.Publisher;
import com.gnaderi.superhero.entity.Skill;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Repository
public interface PublisherCrudRepository extends CrudRepository<Publisher, Long> {

}

