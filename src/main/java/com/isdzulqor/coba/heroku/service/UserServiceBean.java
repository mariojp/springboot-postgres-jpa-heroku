package com.isdzulqor.coba.heroku.service;

import com.isdzulqor.coba.heroku.entity.User;
import com.isdzulqor.coba.heroku.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by isdzulqor on 3/27/17.
 */
@Service
public class UserServiceBean implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<User> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public User create(User user) throws Exception {
        User toBeSavedUser = new User();
        BeanUtils.copyProperties(user, toBeSavedUser);
        toBeSavedUser.setEmail(user.getEmail().toLowerCase());
        toBeSavedUser.setLast(user.getLast().toLowerCase());
        toBeSavedUser.setFirst(user.getFirst().toLowerCase());
        toBeSavedUser.setCompany(user.getCompany().toLowerCase());
        toBeSavedUser.setCity(user.getCity().toLowerCase());
        return userRepository.save(toBeSavedUser);
    }

    @Override
    public User update(User user) throws Exception {
        return null;
    }

    @Override
    public void delete(String id) throws Exception {

    }
}
