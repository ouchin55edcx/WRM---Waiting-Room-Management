package com.ouchin.WRM.waitingroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ouchin.WRM.waitingroom.entity.Visit;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {
    
}
