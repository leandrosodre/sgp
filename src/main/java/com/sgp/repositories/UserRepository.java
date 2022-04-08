package com.sgp.repositories;

import com.sgp.models.Sprint;
import com.sgp.models.Task;
import com.sgp.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
    User findByUserId(long userId);


}
