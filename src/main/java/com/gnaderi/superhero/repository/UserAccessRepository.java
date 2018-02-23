package com.gnaderi.superhero.repository;

import com.gnaderi.superhero.entity.UserAccess;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface UserAccessRepository extends CrudRepository<UserAccess, Long> {
}
