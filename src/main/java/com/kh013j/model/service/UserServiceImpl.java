package com.kh013j.model.service;

import com.kh013j.model.domain.User;
import com.kh013j.model.repository.UserRepository;
import com.kh013j.model.service.interfaces.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
public class UserServiceImpl implements UserService {

    private static final int PAGE_SIZE = 5;

    @Resource
    private UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    /*    @Override
    public void delete(long id){
        userRepository.delete(id);
    }*/

    @Override
    public User delete(long id){
       User deletedUser = userRepository.findOne(id);
       userRepository.delete(deletedUser);
       return deletedUser;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(User user){
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User findById(long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findByConfirmationtoken(String token) {
        return userRepository.findByConfirmationtoken(token);
    }

    @Override
    public Integer deleteNotEnabledUsers() {
        return userRepository.deleteByEnabledFalse();
    }

    @Override
    public Page<User> findAllUser(Integer pageNumber) {
        PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE);
        return userRepository.findAll(request);
    }

    @Override
    public Page<User> findAllEnabledUser(Integer pageNumber, boolean enabled) {
        PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE);
        return userRepository.findAllByEnabled(enabled, request);
    }
}
