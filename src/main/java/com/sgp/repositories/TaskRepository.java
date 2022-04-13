package com.sgp.repositories;

import com.sgp.models.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TaskRepository extends CrudRepository<Task, String> {

    Optional<Task> findByTaskId(final Long id);

}
