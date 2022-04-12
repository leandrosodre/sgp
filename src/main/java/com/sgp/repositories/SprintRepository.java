package com.sgp.repositories;

import com.sgp.models.Sprint;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SprintRepository extends CrudRepository<Sprint, String> {

    @Query("from Sprint where open=1")
    Iterable<Sprint> findAllOpenSprints();
    
}
