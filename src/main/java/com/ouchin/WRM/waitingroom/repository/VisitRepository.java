package com.ouchin.WRM.waitingroom.repository;

import com.ouchin.WRM.waitingroom.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {
    
}
