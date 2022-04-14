package com.sgp.repositories;

import com.sgp.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {

    Optional<User> findByUserId(final Long id);

    @Query("select u from User u where u.login = ?1")
    User findByLogin(String login);

}
