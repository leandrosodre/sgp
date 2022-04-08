package com.sgp.repositories;

import com.sgp.models.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, String> {
    Task findByTaskId(long taskId);


}
