package com.sgp.repositories;

import com.sgp.models.Sprint;
import com.sgp.models.Task;
import org.springframework.data.repository.CrudRepository;

public interface SprintRepository extends CrudRepository<Sprint, String> {
    Task findBySprintId(long sprintId);


}
