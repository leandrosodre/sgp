package com.sgp.repositories;

import com.sgp.models.Sprint;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SprintRepository extends CrudRepository<Sprint, String> {

    @Query("from Sprint where open=1")
    Iterable<Sprint> findAllOpenSprints();
    
    Optional<Sprint> findBySprintId(final Long id);

}
