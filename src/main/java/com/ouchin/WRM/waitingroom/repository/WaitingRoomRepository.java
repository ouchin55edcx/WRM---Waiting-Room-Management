package com.ouchin.WRM.waitingroom.repository;

import com.ouchin.WRM.waitingroom.entity.WaitingRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaitingRoomRepository extends JpaRepository<WaitingRoom, Integer> {
    
}
