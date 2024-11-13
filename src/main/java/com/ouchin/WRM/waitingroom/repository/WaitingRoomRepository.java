package com.ouchin.WRM.waitingroom.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface WaitingRoomRepository extends JpaRepository<WaitingRoom, Integer> {
    
}
