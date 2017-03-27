package com.isdzulqor.coba.heroku.service;

import com.isdzulqor.coba.heroku.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by isdzulqor on 3/27/17.
 */
public interface UserService {
    Page<User> findAll(Pageable pageable);

    List<User> findAll();

    User findById(int id);

    User create(User user) throws Exception;

    User update(User user) throws Exception;

    void delete(String id) throws Exception;
}
