package com.sgp.repositories;

import com.sgp.models.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, String> {
    Team findByTeamId(long teamId);


}
