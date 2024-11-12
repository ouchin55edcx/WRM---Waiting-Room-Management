package com.ouchin.WRM.waitingroom.dto.response;

import com.ouchin.WRM.visitor.entity.Visitor;
import com.ouchin.WRM.waitingroom.entity.enums.Status;

import java.time.Duration;
import java.time.LocalTime;

public class VisitResponseDto {
    private Long id;
    private LocalTime arrivalTime;
    private LocalTime startTime;
    private LocalTime endTime;
    private Status status;
    private Byte priority;
    private Duration estimatedProcessingTime;
    private Visitor visitor;
    private WaitingRoomResponseDto waitingRoom;
}
