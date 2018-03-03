package com.kh013j.model.repository;

import com.kh013j.model.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByEmail(String email);
    public User findByConfirmationtoken(String token);

    Page<User> findAll (Pageable pageable);
    Page<User> findAllByEnabled(Boolean enabled, Pageable pageable);
}
