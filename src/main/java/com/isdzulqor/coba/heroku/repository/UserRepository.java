package com.isdzulqor.coba.heroku.repository;

import com.isdzulqor.coba.heroku.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by isdzulqor on 3/27/17.
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
