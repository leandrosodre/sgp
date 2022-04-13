package com.sgp.repositories;

import com.sgp.models.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TeamRepository extends CrudRepository<Team, String> {

    Optional<Team> findByTeamId(final Long id);

}
