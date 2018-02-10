package com.kh013j.model.repository;

import com.kh013j.model.domain.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepositiry extends JpaRepository<Status, Long> {
    Status findFirstByName(String name);
}
